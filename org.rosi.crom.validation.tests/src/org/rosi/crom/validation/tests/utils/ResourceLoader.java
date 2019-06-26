package org.rosi.crom.validation.tests.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.framed.iorm.transformation.test.model.test.TestCase;
import org.osgi.framework.Bundle;

/** Used to load resources from the workspace
 * @author Florian Amberg
 *
 */
public class ResourceLoader {

	public static final String PLATFORM_BUNDLE = "org.rosi.crom.validation.tests";
	

	/** Load file into an Ecore Resource
	 * @param file
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static Resource loadFile(File file) throws URISyntaxException, IOException {
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createFileURI(file.toString()));
		resource.load(Collections.EMPTY_MAP);
		return resource;
	}
	
	/** Load file into an Ecore Resource
	 *
	 * @param filePath folder and file in the bundle, e.g. "testcases/fulfillment_test_1.xmi"
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public static Resource loadFile(String filePath) throws URISyntaxException, IOException {
		Bundle bundle = Platform.getBundle(PLATFORM_BUNDLE);
		URL fileURL = bundle.getEntry(filePath);
		File file;
		
		file = new File(FileLocator.resolve(fileURL).toURI());

		return loadFile(file);
	}
	
	/** Load file into an Ecore Resource
	 * @param filePath
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static TestCase loadTestCase(String filePath) throws IOException, URISyntaxException {
		Resource res = loadFile(filePath);
		return (TestCase) res.getContents().get(0);
	}
	
	/** Load file into an Ecore Resource
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static TestCase loadTestCase(File file) throws IOException, URISyntaxException {
		Resource res = loadFile(file);
		return (TestCase) res.getContents().get(0);
	}
}
