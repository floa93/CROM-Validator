package org.rosi.crom.validation.ocl;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.rosi.crom.validation.Utils;

import crom_l1_composed.Crom_l1_composedPackage;

/**
 * @author Florian Amberg
 *
 */
public class CompleteOCLParser {
	private OCL oclInstance;
	private EObject modelInstance;
	private Map<String, ExpressionInOCL> constraintMap;
	
	/**
	 * failedConstraints is a {@link Map} collection that contains the error class {@link String} as
	 * key and the error message {@link String} as value.
	 */	
	private Map<String, String> failedConstraints;
	
	
	/**
	 * @param modelInstance
	 */
	public CompleteOCLParser(EObject modelInstance) {
		this.modelInstance = modelInstance;
		
		// Create an EPackage.Registry for just the EXTLibraryPackage
		EPackage.Registry registry = new EPackageRegistryImpl();
		
		String Crom_l1_composedPackage_eNS_URI_FIXED = "platform:/resource/org.rosi.crom.metamodel/model/crom_l1_composed.ecore";
		registry.put(Crom_l1_composedPackage_eNS_URI_FIXED, Crom_l1_composedPackage.eINSTANCE);

		// Create an OCL that creates a ResourceSet using the minimal EPackage.Registry	    
		oclInstance = OCL.newInstance(registry);				
		

		failedConstraints = new HashMap<String, String>();
	}
	
	/**
	 * @param urlCompleteOCL
	 */
	public void loadFile(URL urlCompleteOCL) {
		URI uriCompleteOCL = null;
		//Convert URL to EMF URI
		try {
			uriCompleteOCL = Utils.getURI(urlCompleteOCL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// parse the contents as an OCL document
		Resource asResource = oclInstance.parse(uriCompleteOCL);

		// accumulate the document constraints in constraintMap and print all constraints
		constraintMap = new HashMap<String, ExpressionInOCL>();
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject next = tit.next();
			if (next instanceof Constraint) {
				Constraint constraint = (Constraint)next;
				ExpressionInOCL expressionInOCL;
				try {
					expressionInOCL = oclInstance.getSpecification(constraint);
					if (expressionInOCL != null) {
						String name = constraint.getName();
						if (name != null) {
							constraintMap.put(name, expressionInOCL);
						}
					}
				} catch (ParserException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @param name
	 * @return
	 */
	public ExpressionInOCL getConstraint(String name) {		   
		if(constraintMap.containsKey(name))
			return constraintMap.get(name);
		return null;
	}
	
	/**
	 * @param constraintName
	 * @return
	 */
	public Object evaluate(String constraintName) {
		ExpressionInOCL expression = getConstraint(constraintName);
		if(expression != null) 
			return evaluate(expression, constraintName);
		else
			return null;
	}
	
	
	/**
	 * @param expression
	 * @param constraintName
	 * @return
	 */
	public Object evaluate(ExpressionInOCL expression, String constraintName) {
		Object result = oclInstance.evaluate(modelInstance, expression);
		if(result instanceof TupleValue) {
			TupleValue richInvariant = (TupleValue)result;
			TupleTypeId types = richInvariant.getTypeId();
			TuplePartId typeStatus = types.getPartId("status");
			TuplePartId typeMessage = types.getPartId("message");
			
			// Custom Error
			if(typeStatus != null && typeMessage != null) {
				boolean status = (boolean)richInvariant.getValue(typeStatus);
				String error = richInvariant.getValue(typeMessage).toString();
				
				if(!status)
					failedConstraints.put(constraintName, error);
				
				return status;
			}
		}
		
		//classic ocl support
		if(result instanceof String)
			failedConstraints.put(constraintName, result.toString());
		
		return result;
	}

	/**
	 * @return
	 */
	public Map<String, String> getFailedConstraints() {
		return failedConstraints;
	}
}
