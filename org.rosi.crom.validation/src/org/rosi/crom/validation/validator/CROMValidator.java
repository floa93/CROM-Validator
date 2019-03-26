package org.rosi.crom.validation.validator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.rosi.crom.validation.Log;
import org.rosi.crom.validation.config.ConfigLoader;
import org.rosi.crom.validation.mapping.OCLFeatureMapping;
import org.rosi.crom.validation.ocl.CompleteOCLParser;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import crom_l1_composed.Model;


public class CROMValidator{
	private Shell shell;
	
	public CROMValidator(Shell shell) {
		this.shell = shell;
	}
	
	private void printf(String format, Object... args) {
		System.out.println(String.format(format, args));
	}
	
	// run SWT stuff in Display Thread
	private void alertError(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "", message);
				
			}
        });
	}
	
	private void alertInfo(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(shell, "", message);
				
			}
        });
	}
	
	public void validate(IPath path, Resource cromResource) {
		//check , Resource resourceIORM for null
		if (!(cromResource.getContents().isEmpty() || cromResource.getContents().get(0) instanceof Model))
			throw new IllegalArgumentException("The given CROM model '" + path.toPortableString() + "' was empty?");
			
		/*
		ValidationMarker mark = new ValidationMarker();
		mark.mark(path, resource);
		
		if(1==1)
			return;
		*/
		// Crom_l1_composed Model
		Model cromModel = (Model)cromResource.getContents().get(0);		
		//CROModel cromBuilder = new CROModel();
        //CROMVisitor visitor = new CROMVisitor();
        //visitor.visit(cromBuilder, cromModel);
        
		//CompleteOCL
		CompleteOCLParser completeOCLParser = new CompleteOCLParser(cromModel);
		//Load OCL validation file
		URL oclURL = getClass().getResource("/constraints/crom_constraints.ocl");
		completeOCLParser.loadFile(oclURL);

		//Load Configuration
		ConfigLoader configLoader = new ConfigLoader(path);
		configLoader.printConfig();
		
		//Feature Mapping
		URL featureMappingURL = getClass().getResource("/oclmapping/rules.oclmapping");
		OCLFeatureMapping featureMapping = new OCLFeatureMapping(featureMappingURL, configLoader.getConfigList());
		
		evaluateOclConstraints(completeOCLParser, featureMapping);
		
		printResults(shell, completeOCLParser);
	}
	
	/**
	 * @param cromResource
	 * @param configList
	 * @return Map, in which error classes are keys and the corresponding error messages are values 
	 */
	public Map<String, String> validate(Resource cromResource, List<String> configList) {
		// Load crom_l1_composed.Model from a .crom Resource
		crom_l1_composed.Model cromModel = (crom_l1_composed.Model)cromResource.getContents().get(0);	
		return validate(cromModel, configList);
	}
	
	/**
	 * @param cromModel
	 * @param configList
	 * @return Map, in which error classes are keys and the corresponding error messages are values 
	 */
	public Map<String, String> validate(crom_l1_composed.Model cromModel, List<String> configList) {
		//CompleteOCL
		CompleteOCLParser completeOCLParser = new CompleteOCLParser(cromModel);
		//Load OCL validation file
		URL oclURL = getClass().getResource("/constraints/crom_constraints.ocl");
		completeOCLParser.loadFile(oclURL);
		
		//Feature Mapping
		URL featureMappingURL = getClass().getResource("/oclmapping/rules.oclmapping");
		OCLFeatureMapping featureMapping = new OCLFeatureMapping(featureMappingURL, configList);
		
		evaluateOclConstraints(completeOCLParser, featureMapping);
		
		Map<String, String> errorList = completeOCLParser.getFailedConstraints();
		return errorList;
	}
	
	public static<T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
	  List<T> list = new ArrayList<T>(c);
	  Collections.sort(list);
	  return list;
	}
	
	private void evaluateOclConstraints(CompleteOCLParser oclParser, OCLFeatureMapping featureMapping) {
		Set<String> invariants = featureMapping.getInvariants();
		
		//todo: remove, just for easier testing
		List<String> sortedInvariants = asSortedList(invariants);
		
		for(String invariant : sortedInvariants) {
			ExpressionInOCL constraint = oclParser.getConstraint(invariant);
			if(constraint != null) {
				Object result = oclParser.evaluate(constraint, invariant);
				if(result instanceof CollectionValue) {
					CollectionValue setValue = (CollectionValue)result;
					printf("%s: [%s]%s", invariant, setValue.size().toString(), setValue.getElements().toString());
				}
				else
					printf("%s: %s", invariant, result);
			}
			else {
				printf("COULD NOT FIND CONSTRAINT %s in OCL", invariant);
			}
		}
	}
	
	private void printResults(Shell shell, CompleteOCLParser oclParser) {
		Map<String, String> failedConstraints = oclParser.getFailedConstraints();

		if(failedConstraints.isEmpty()) {
			alertInfo("CROM is wellformed");
		}
		else {
			printf("Please fix the following errors:");
			
			for(String errorMessage : failedConstraints.values()) {
				printf(errorMessage);
				Log.error(errorMessage);
			}
			
			
			String errors = String.join("\n", failedConstraints.values());
			//run SWT stuff in Display Thread			
			alertError("CROM is not wellformed. Fix the following errors:\n\n" + errors);
		}
	}
}
