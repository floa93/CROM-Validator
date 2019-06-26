package org.rosi.crom.validation.tests;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Shell;
import org.framed.iorm.featuremodel.FRaMEDConfiguration;
import org.framed.iorm.transformation.test.model.test.TestCase;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.osgi.framework.Bundle;

import crom_l1_composed.Model;

import org.rosi.crom.validation.tests.testgeneration.TestGenerator;
import org.rosi.crom.validation.tests.utils.ResourceLoader;
import org.rosi.crom.validation.validator.CROMValidator;

/**
 * Parameterized test to run all test cases inside "testcases" directory
 *
 * @author Johannes Tandler
 * @author Florian Amberg Edited to support the evaluation of CROM files via OCL
 *
 */
@RunWith(Parameterized.class)
public class ValidationTestSuite {
    /**
     * Object that creates the generated test cases
     */
    private static TestGenerator TEST_GENERATOR = new TestGenerator();


    /**
     * Shared instance of the CROM Validator
     */
    private static CROMValidator cromValidator;

    /**
     * Perform pre-test initialization once
     */
    @BeforeClass
    public static void setUpOnce() {
        // SWT shell is not needed
        Shell shell = null;
        cromValidator = new CROMValidator(shell);
    }


    /**
     * Loads all {@link TestCase}s from the "testcases" directory of this plugin.
     *
     * @return {@link List} of {@link TestCase}
     * @throws Exception
     */
    @Parameterized.Parameters(name = "{index} : file={1}")
    public static Collection<Object[]> getTestCases() throws Exception {
        List<Object[]> list = new LinkedList<Object[]>();
        File file = null;

        TEST_GENERATOR.generateTestCases();
        // if bundle is available this test runs as plugin junit test
        Bundle bundle = Platform.getBundle(ResourceLoader.PLATFORM_BUNDLE);
        if (bundle != null) {
            // get dir out of bundle
            URL fileURL = bundle.getEntry("testcases/generated");
            file = new File(FileLocator.resolve(fileURL).toURI());
        } else {
            // otherwise just load it from the working directory
            file = new File("testcases/generated");
        }
        // load all test cases in this directory
        loadDirectory(list, file);
        return list;
    }

    /**
     * Loads all {@link TestCase} of the given directory
     *
     * @param list List of {@link TestCase}
     * @param file Current directory
     * @throws URISyntaxException 
     */
    private static void loadDirectory(List<Object[]> list, File file) throws IOException, URISyntaxException {
        for (File testFile : file.listFiles()) {
            // if entry is directory load it recursively
            if (testFile.isDirectory()) {
                loadDirectory(list, testFile);
            } else if (testFile.getName().endsWith("xmi")) {
                // if entry is file try to load test file
                TestCase testCase = ResourceLoader.loadTestCase(testFile);
                if (testCase != null) {
                    list.add(new Object[]{testCase, testFile.getName()});
                }
            }
        }
    }


    /**
     * current {@link TestCase}
     */
    private TestCase testCase;

    /**
     * default constructor
     *
     * @param testCase current {@link TestCase}
     * @param _bla     JUnit needs this, but we dont use it.
     * @throws Exception
     */
    public ValidationTestSuite(TestCase testCase, String _bla) throws Exception {
        this.testCase = testCase;
    }

    /**
     * Test a model for validation errors
     *
     * @throws IOException
     * @throws Exception
     */
    @Test
    public void doTest() throws IOException {
 	   
 	   Model cromModel = testCase.getCromModel();
 	   FRaMEDConfiguration framedConfiguration = testCase.getFramedModel().getFramedConfiguration();
 	   List<String> configList = org.rosi.crom.validation.config.ConfigGenerator.extractConfig(framedConfiguration);
 	   
 	   Map<String, String> failedConstraints = cromValidator.validate(cromModel, configList);
 	   
	   assertThat(failedConstraints.size(), is(0));	

       System.out.println(this.testCase);
     }

    @After
    public void deleteFiles() throws Exception {
        // delete created files after test
        if (testCase.getTitle().startsWith("Generated test")) 
        	deleteGeneratedTestCase();
    }

    /**
     * Deletes the test case file corresponding to the test case that was just executed
     */
    public void deleteGeneratedTestCase() {
        String filename = testCase.getTitle().substring(15);
        Bundle bundle = Platform.getBundle(ResourceLoader.PLATFORM_BUNDLE);
        URL fileURL = bundle.getEntry("testcases/Generated/" + filename + ".xmi");
        try {
            File file = new File(FileLocator.resolve(fileURL).toURI());
            Files.delete(Paths.get(file.getPath()));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}