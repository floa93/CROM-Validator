package mapping;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.rosi.crom.validation.mapping.FeatureMappingStandaloneSetup;
import org.rosi.crom.validation.mapping.featureMapping.Feature;
import org.rosi.crom.validation.mapping.featureMapping.Invariant;
import org.rosi.crom.validation.mapping.featureMapping.Model;
import org.rosi.crom.validation.mapping.featureMapping.Universal;

import com.google.inject.Injector;

public class FeatureMapping {
	public static final String UNIVERSAL_CONSTRAINT = "Universal";  
	
	private Map<String, Set<String>> featureMap;
	
	public FeatureMapping(URL dslURL) {
		// do this only once per application
		Injector injector = new FeatureMappingStandaloneSetup().createInjector();
		 
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

		if(validate(resource))
			parse(resource);
		else
			Log.error("Validation for DSL failed.");
	
	}
	
	private boolean validate(Resource resource) {
		// Validation
		IResourceValidator validator = ((XtextResource)resource).getResourceServiceProvider().getResourceValidator();
		List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		for (Issue issue : issues) {
		  System.out.println(issue.getMessage());
		}
		
		return issues.isEmpty();
	}
	
	private void parse(Resource resource) {
		featureMap = new HashMap<>();
		
		Model modelRootElement = (Model) resource.getContents().get(0);
		
		for(EObject object : modelRootElement.getElements()) {
			Set<String> featureInvariants = new HashSet<>();
			
			if(object instanceof Feature) {
				Feature feature = (Feature) object;
				for(Invariant invariant : feature.getElements()) 
					featureInvariants.add(invariant.getName());			
				
				featureMap.put(feature.getName(), featureInvariants);
			}
			else if(object instanceof Universal) {
				Universal universal = (Universal) object;
				
				for(Invariant invariant : universal.getElements()) 
					featureInvariants.add(invariant.getName());			
				
				featureMap.put(UNIVERSAL_CONSTRAINT, featureInvariants);
			}			
		}
	}
	
	public Map<String, Set<String>> getFeatureMap(){
		return featureMap;
	}
}
