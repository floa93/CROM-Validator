package org.rosi.crom.validation.mapping;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.rosi.crom.validation.Log;
import org.rosi.crom.validation.Utils;
import org.rosi.crom.validation.mapping.OclMappingStandaloneSetup;
import org.rosi.crom.validation.mapping.oclMapping.AndExpression;
import org.rosi.crom.validation.mapping.oclMapping.Expression;
import org.rosi.crom.validation.mapping.oclMapping.Literal;
import org.rosi.crom.validation.mapping.oclMapping.Model;
import org.rosi.crom.validation.mapping.oclMapping.NotExpression;

import com.google.inject.Injector;

/** Feature Mapping based on Xtext
 * @author Florian Amberg
 *
 */
public class OCLFeatureMapping {
	private List<String> featureConfigList;
	private Set<String> invariantSet;	
	
	
	/**
	 * @param dslURL
	 * @param featureConfigList
	 */
	public OCLFeatureMapping(URL dslURL, List<String> featureConfigList) {
		// save features
		this.featureConfigList = featureConfigList;
		this.invariantSet = new HashSet<>();
		
		// do this only once per application
		Injector injector = new OclMappingStandaloneSetup().createInjector();
		 
		// obtain a resourceset from the injector
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		 
		// load a resource by URI, in this case from the file system
		URI uri = null;
		try {
			uri = Utils.getURI(dslURL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		Resource resource = resourceSet.getResource(uri, true);
		
		List<Issue> issues = validate(resource);
		if(issues.isEmpty())
			parse(resource);
		else {
			String issue = issues.stream()
					.map(i -> i.getMessage())
					.collect(Collectors.joining());
			Log.error("Validation for %s failed: %s", dslURL.toString(), issue);			
		}
	
	}
	
	/** Checks the validity of the .oclmapping file
	 * @param resource
	 * @return
	 */
	private List<Issue> validate(Resource resource) {
		// Validation
		IResourceValidator validator = ((XtextResource)resource).getResourceServiceProvider().getResourceValidator();
		List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		return issues;
	}
	
	/** Parses a .oclmapping file
	 * @param resource
	 */
	private void parse(Resource resource) {		
		Model modelRootElement = (Model) resource.getContents().get(0);
		
		for(EObject object : modelRootElement.getElements()) {			
			if(object instanceof Expression) {
				Expression expression = (Expression)object;
				boolean evalResult = parseExpression(expression, true);
				
				if(evalResult) {
					invariantSet.addAll(
							expression.getElements()
							.stream()
							.map(e->e.getName())
							.collect(Collectors.toSet())
							);
				}				
			}	
		}
	}
	
	/** Parses the AST tree
	 * @param rootExpression
	 * @param result
	 * @return
	 */
	private boolean parseExpression(Expression rootExpression, boolean result) {
		if(rootExpression instanceof AndExpression) {
			AndExpression andExpression = (AndExpression) rootExpression;
			Expression left = andExpression.getLeft();
			Expression right = andExpression.getRight();
			
			boolean result_left = parseExpression(left, result);
			boolean result_right = parseExpression(right, result);
			
			result = result_left && result_right;
			
		}
		else if(rootExpression instanceof NotExpression) {
			NotExpression notExpression = (NotExpression) rootExpression;
			Expression operand = notExpression.getOperand();
			
			result = !(parseExpression(operand, result));
		}
		else if(rootExpression instanceof Literal) {
			Literal literal = (Literal) rootExpression;
			String feature = literal.getValue();
			
			if(feature.equals("true") || featureConfigList.contains(feature)) {
				result = result && true;
			}
			else {
				result = result && false;
			}
		}
		else {
			System.out.print("Error while parsing Expressions. Unkown Type:" + rootExpression.toString());
		}
		
		return result;
	}	
	
	
	/** Get the appropriate invariant names
	 * @return
	 */
	public Set<String> getInvariants(){
		return invariantSet;
	}
}
