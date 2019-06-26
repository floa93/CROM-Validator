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


/** Used to validate CROM models
 * @author Florian
 *
 */
public class CROMValidator{
	private Shell shell;
	
	/**
	 * @param shell
	 */
	public CROMValidator(Shell shell) {
		this.shell = shell;
	}
	
	/** To use when debugging
	 * @param format
	 * @param args
	 */
	private void printf(String format, Object... args) {
		System.out.println(String.format(format, args));
	}
	
	
	/** Run SWT output in Display Thread
	 * @param message
	 */
	private void alertError(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "Error", message);
				
			}
        });
	}
	
	/** Show alert as an Information
	 * @param message
	 */
	private void alertInfo(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(shell, "Information", message);
				
			}
        });
	}
	
	/** Validate a CROM resource. Path is required to load the .cfg 
	 * @param path
	 * @param cromResource
	 */
	public void validate(IPath path, Resource cromResource) {
		//check , Resource resourceIORM for null
		if (!(cromResource.getContents().isEmpty() || cromResource.getContents().get(0) instanceof Model))
			throw new IllegalArgumentException("The given CROM model '" + path.toPortableString() + "' was empty?");
			
		// Crom_l1_composed Model
		Model cromModel = (Model)cromResource.getContents().get(0);		
		
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
		
		//Evaluate the appropriate Constraints
		evaluateOclConstraints(completeOCLParser, featureMapping);
		
		//Output the results to the User
		printResults(shell, completeOCLParser);
	}
	

	/** Validate a CROM resource with a given config
	 * @param cromResource
	 * @param configList
	 * @return
	 */
	public Map<String, String> validate(Resource cromResource, List<String> configList) {
		// Load crom_l1_composed.Model from a .crom Resource
		crom_l1_composed.Model cromModel = (crom_l1_composed.Model)cromResource.getContents().get(0);	
		return validate(cromModel, configList);
	}
	
	/** Validate a CROM model with a given config
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
	
	/** Evaluate the OCL constraints
	 * @param oclParser
	 * @param featureMapping
	 */
	private void evaluateOclConstraints(CompleteOCLParser oclParser, OCLFeatureMapping featureMapping) {
		Set<String> invariants = featureMapping.getInvariants();
	
		for(String constraintName : invariants) {
			Object result = oclParser.evaluate(constraintName);
			if(result != null) {
				if(result instanceof CollectionValue) {
					CollectionValue setValue = (CollectionValue)result;
					printf("%s: [%s]%s", constraintName, setValue.size().toString(), setValue.getElements().toString());
				}
				else
					printf("%s: %s", constraintName, result);
			}
			else {
				printf("COULD NOT FIND CONSTRAINT %s in OCL", constraintName);
			}
		}
	}
	
	/** Show the results to the User
	 * @param shell
	 * @param oclParser
	 */
	private void printResults(Shell shell, CompleteOCLParser oclParser) {
		Map<String, String> failedConstraints = oclParser.getFailedConstraints();

		if(failedConstraints.isEmpty()) {
			alertInfo("CROM is wellformed");
		}
		else {
			printf("Please fix the following errors:");
			
			for(String errorMessage : failedConstraints.values()) {
				printf(errorMessage);
				Log.warning(errorMessage);
			}
			
			String errors = String.join("\n", failedConstraints.values());		
			alertError("CROM is not wellformed. Fix the following errors in your model:\n\n" + errors);
		}
	}
}
