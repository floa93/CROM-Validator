package org.rosi.crom.validation.config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.featuremodel.FRaMEDFeature;

import crom_l1_composed.Model;

public class ConfigGenerator {

	/**
	 * 
	 */
	private Shell shell;
	
	/**
	 * 
	 */
	private IPath cromPath;
	
	/**
	 * 
	 */
	private ResourceSet resourceSet;
	
	/**
	 * 
	 */
	private Resource cromResource;

	/**
	 * @param shell
	 * @param cromPath
	 * @param resourceSet
	 * @param cromResource
	 */
	public ConfigGenerator(Shell shell, IPath cromPath, ResourceSet resourceSet, Resource cromResource) {
		super();
		this.shell = shell;
		this.cromPath = cromPath;
		this.resourceSet = resourceSet;
		this.cromResource = cromResource;
	}
	
	//use standard config if iorm does not exist
	/**
	 * @param askOverride
	 */
	public void generate(boolean askOverride) {
		try {
			IPath iormPath = cromPath.removeFileExtension().addFileExtension("crom_diagram");
			URI iormURI = URI.createURI(iormPath.toString());
			Resource iormResource = resourceSet.getResource(iormURI, true);
			
			if (!(cromResource.getContents().isEmpty() || cromResource.getContents().get(0) instanceof Model))
				throw new IllegalArgumentException("The given CROM model '" + cromPath.toPortableString() + "' was empty?");
		
			org.framed.iorm.model.Model modelIORM = (org.framed.iorm.model.Model)iormResource.getContents().get(1);
			FRaMEDConfiguration framedConfiguration = modelIORM.getFramedConfiguration();
			
			// extract used config of the IORM
			List<String> configList = extractConfig(framedConfiguration);
			
		    saveAsFile(askOverride, configList);
		    
		} catch(Exception ex) {
			// probably ResourceException, since there is no IORM
			// load standard config and save
			List<String> configList = ConfigLoader.loadStandardConfig();
		    saveAsFile(askOverride, configList);
		}
	}
	
	/**
	 * @param askOverride
	 * @param configList
	 */
	private void saveAsFile(boolean askOverride, List<String> configList) {
		IPath configPath = cromPath.removeFileExtension().addFileExtension("crom_cfg");
		IFile configFile = ResourcesPlugin.getWorkspace().getRoot().getFile(configPath);
		
	    try {
	    	if(askOverride) {
	    		if (configFile.exists() && (MessageDialog.openQuestion(shell, "Confirmation Request",
					"The file '" + configFile.getFullPath() + "' already exists. Do you want to overwrite the existing file?"))){
					configFile.delete(true, null);
					}
	    	}
	    	else {
	    		configFile.delete(true, null);
	    	}
		
			
			//Bottleneck due to missing StringOutputStream	
	    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
			for (String line : configList) {
			   baos.write(line.concat(System.lineSeparator()).getBytes());
			 }
	
			byte[] bytes = baos.toByteArray();
			 
			ByteArrayInputStream content = new ByteArrayInputStream(bytes);

			//create file in workspace
			configFile.create(content, IResource.NONE, null);
			
			baos.close();
			content.close();
			
		} catch (CoreException | IOException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * Extracts the configuration as a List of Strings from a FRaMEDConfiguration
	 *  
	 * @param framedConfiguration
	 * @return
	 */
	public static List<String> extractConfig(FRaMEDConfiguration framedConfiguration){
		// extract used config of the IORM
		List<String> configList = new ArrayList<>();
	    if (framedConfiguration != null) {
	    	for (FRaMEDFeature f : framedConfiguration.getFeatures())
	    		configList.add(f.getName().getLiteral());	    		
	    }
	    return configList;
	}
}
