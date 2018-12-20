package org.rosi.crom.validation.validator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.rosi.crom.toformal.builder.CROMVisitor;
import org.rosi.crom.toformal.builder.CROModel;
import org.rosi.crom.validation.Log;
import org.rosi.crom.validation.config.ConfigLoader;
import org.rosi.crom.validation.ocl.CompleteOCLParser;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import crom_l1_composed.Model;
import mapping.FeatureMapping;


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
	
	public void validate(IPath path, Resource resource, Resource resourceIORM) {
		
		//check , Resource resourceIORM for null
		if (!(resource.getContents().isEmpty() || resource.getContents().get(0) instanceof Model))
			throw new IllegalArgumentException("The given CROM model '" + path.toPortableString() + "' was empty?");
			
		// Crom_l1_composed Model
		Model cromModel = (Model)resource.getContents().get(0);
		CROModel cromBuilder = new CROModel();
        CROMVisitor visitor = new CROMVisitor();
        visitor.visit(cromBuilder, cromModel);
        
		//CompleteOCL
		CompleteOCLParser completeOCLParser = new CompleteOCLParser(cromModel);
		//Load OCL validation file
		URL oclURL = getClass().getResource("/constraints/crom_l1_composed_pivot.ocl");
		completeOCLParser.loadFile(oclURL);
		
		//Evaluate Static Constraints : u_
		evaluateStaticConstraints(completeOCLParser);
		
		//
		URL featureMappingURL = getClass().getResource("/featuremapping/rules.featuremapping");
		FeatureMapping featureMapping = new FeatureMapping(featureMappingURL);
		
		//Load Configuration
		ConfigLoader configLoader = new ConfigLoader(path);
		evaluateDynamicConstraints(completeOCLParser, configLoader.getConfigList(), featureMapping);
		
		getResults(shell, completeOCLParser);
		
	}
	
	private void evaluateStaticConstraints(CompleteOCLParser oclParser) {
		List<String> constraints = oclParser.getUniversalConstraints();

		for(String constraint : constraints) {
			Object result = oclParser.evaluate(constraint);
			printf("%s: %s", constraint, result);
			
		}
	}
	
	private void evaluateDynamicConstraints(CompleteOCLParser oclParser, List<String> features, FeatureMapping featureMapping) {
		System.out.println(features);
		Map<String, Set<String>> featureMap = featureMapping.getFeatureMap();
		
		//universal constraints
		for(String invariant : featureMap.get(FeatureMapping.UNIVERSAL_CONSTRAINT)) {
			ExpressionInOCL constraint = oclParser.getConstraint(invariant);
			if(constraint != null) {
				Object result = oclParser.evaluate(constraint);
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
		
		//dynamic
		for(String feature : features) {	
			if(featureMap.containsKey(feature)){
				for(String invariant : featureMap.get(feature)) {
					ExpressionInOCL constraint = oclParser.getConstraint(invariant);
					if(constraint != null) {
						Object result = oclParser.evaluate(constraint);
						printf("%s: %s", invariant, result);
					}
					else {
						printf("COULD NOT FIND CONSTRAINT %s in OCL", invariant);
					}
				}
			}			
		}	
	}
	
	private void getResults(Shell shell, CompleteOCLParser oclParser) {
		List<String> errorList = oclParser.getFailedConstraints();

		if(errorList.isEmpty()) {
			alertInfo("CROM is wellformed");
		}
		else {
			printf("Please fix the following errors:");
			
			for(String error : errorList) {
				printf(error);
				Log.error(error);
			}
			
			String errors = String.join("\n", errorList);
			//run SWT stuff in Display Thread			
			alertError("CROM is not wellformed. Fix the following errors:\n\n" + errors);
		}
	}
}
