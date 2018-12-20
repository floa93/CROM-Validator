package org.rosi.crom.validation.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class ConfigLoader {
	private ArrayList<String> customConfigList, standardConfigList;
	
	public ConfigLoader(IPath cromPath) {
		this.customConfigList = new ArrayList<>();
		this.standardConfigList = new ArrayList<>();

		loadStandardConfig();
		loadCustomConfig(cromPath);
		
		addNotFeatures();
	}

	private void loadStandardConfig() {
		try {
			URL url = new URL("platform:/plugin/org.framed.iorm.featuremodel/standardframedconfiguration/standardFramedConfiguration.crom_diagram");
		    InputStream inputStream = url.openConnection().getInputStream();
		    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		    String inputLine;
		 
		    while ((inputLine = in.readLine()) != null) {
		    	if(inputLine.contains("<features name")) {
			    	standardConfigList.add(inputLine.split("\"")[1]);		    		
		    	}
		    }
		    
		    in.close();
		 
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	private void loadCustomConfig(IPath cromPath) {
		IPath configPath = cromPath.removeFileExtension().addFileExtension("crom_cfg");
		IFile configFile = ResourcesPlugin.getWorkspace().getRoot().getFile(configPath);
		try {
			InputStream inputStream = configFile.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			while(reader.ready()) {
				String feature = reader.readLine();
				if(standardConfigList.contains(feature))
					customConfigList.add(feature);
			}

			reader.close();
			inputStream.close();
			
		} catch (CoreException | IOException e) {
			e.printStackTrace();
		}
	}

	
	private void addNotFeatures() {
		for(String standardFeature : standardConfigList) {
			if(!customConfigList.contains(standardFeature)) {
				String notFeature = String.format("not_%s", standardFeature);
				customConfigList.add(notFeature);
			}
		}
	}
	
	public ArrayList<String> getConfigList(){
		return customConfigList;
	}
}
