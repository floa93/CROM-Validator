package org.rosi.crom.validation.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.junit.BeforeClass;
import org.rosi.crom.validation.tests.config.ConfigBuilder;
import org.rosi.crom.validation.tests.utils.ResourceLoader;
import org.rosi.crom.validation.validator.CROMValidator;

public class ErrorClassesTest
{
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
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	@Test
    public void testUniversalErrors() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/universal.crom");

	   //CT Inheritance is not allowed in this test case
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removeCompartmentInheritance();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //CompartmentContainsRoles
	   assertTrue(failedConstraints.containsKey("CompartmentContainsRoles"));
	   
	   //todo: use hamcrest
	   assertThat(failedConstraints.containsKey("CompartmentContainsRoles"), is(true));
	   
	   String errorCompartmentContainsRoles = failedConstraints.get("CompartmentContainsRoles");
	   assertThat(errorCompartmentContainsRoles, containsString("Every CompartmentType must define at least one RoleType. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentContainsRoles, containsString("CompartmentContainsRoles"));
	   
	   //CompartmentContainsFilledRoles
	   assertTrue(failedConstraints.containsKey("CompartmentContainsFilledRoles"));	 
	   
	   String errorCompartmentContainsFilledRoles = failedConstraints.get("CompartmentContainsFilledRoles");
	   assertThat(errorCompartmentContainsFilledRoles, containsString("RoleTypes in Compartments need to be filled. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentContainsFilledRoles, containsString("CompartmentContainsFilledRoles"));
	   
	   //RoleFilled
	   assertTrue(failedConstraints.containsKey("RoleFilled"));	 
	   
	   String errorRoleFilled = failedConstraints.get("RoleFilled");
	   assertThat(errorRoleFilled, containsString("Every RoleType must be filled. Failed for RoleType(s):"));
	   assertThat(errorRoleFilled, containsString("roleTypeA"));
	   
	   //RelationshipDefinedInCompartment
	   assertTrue(failedConstraints.containsKey("RelationshipDefinedInCompartment"));	 
	   
	   String errorRelationshipDefinedInCompartment = failedConstraints.get("RelationshipDefinedInCompartment");
	   assertThat(errorRelationshipDefinedInCompartment, containsString("Every Relationship needs to be defined in a CompartmentType. Failed for Relationship(s):"));
	   assertThat(errorRelationshipDefinedInCompartment, containsString("rstOutside"));
	   
	   //RelationshipRolesAreDistinct
	   assertTrue(failedConstraints.containsKey("RelationshipRolesAreDistinct"));	 
	   
	   String errorRelationshipRolesAreDistinct = failedConstraints.get("RelationshipRolesAreDistinct");
	   assertThat(errorRelationshipRolesAreDistinct, containsString("Relationships between the same RoleTypes are not allowed. Failed for Relationship(s) between:"));
	   assertThat(errorRelationshipRolesAreDistinct, containsString("relRoleA <-> relRoleA"));
	   
	   
	   //RelationshipRolesInSameCompartment
	   assertTrue(failedConstraints.containsKey("RelationshipRolesInSameCompartment"));	 
	   
	   String errorRelationshipRolesInSameCompartment = failedConstraints.get("RelationshipRolesInSameCompartment");
	   assertThat(errorRelationshipRolesInSameCompartment, containsString("The RoleTypes of a Relationship need to be in the same CompartmentType. Failed for Relationship(s) between:"));
	   assertThat(errorRelationshipRolesInSameCompartment, containsString("relRoleC <-> relRoleD"));
	   
	   //ConstraintDefinedInCompartment
	   assertTrue(failedConstraints.containsKey("ConstraintDefinedInCompartment"));	 
	   
	   String errorConstraintDefinedInCompartment = failedConstraints.get("ConstraintDefinedInCompartment");
	   assertThat(errorConstraintDefinedInCompartment, containsString("Constraints cannot be defined outside of a Compartment Type. Failed for RoleConstraint(s):"));
	   assertThat(errorConstraintDefinedInCompartment, containsString("relRoleB <=> relRoleA"));

	   //ConstraintRolesInSameCompartment
	   assertTrue(failedConstraints.containsKey("ConstraintRolesInSameCompartment"));	 
	   
	   String errorConstraintRolesInSameCompartment = failedConstraints.get("ConstraintRolesInSameCompartment");
	   assertThat(errorConstraintRolesInSameCompartment, containsString("Both RoleTypes of a RoleConstraint need to be defined in the same Compartment Type. Failed for RoleConstraint(s):"));
	   assertThat(errorConstraintRolesInSameCompartment, containsString("roleTypeA <=> relRoleA"));
   }
   
    /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testPropertiesAndBehaviour() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/properties_behavior.crom");
		
	   //RT and CT properties/behavior disabled	
	   //Role Inheritance disabled
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removePropertiesAndBehavior();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //RoleBehaviorNotAllowed
	   assertTrue(failedConstraints.containsKey("RoleBehaviorNotAllowed"));
	   
	   String errorRoleBehaviorNotAllowed = failedConstraints.get("RoleBehaviorNotAllowed");
	   assertThat(errorRoleBehaviorNotAllowed, containsString("RoleTypes can not define operations. Failed for RoleType(s):"));
	   assertThat(errorRoleBehaviorNotAllowed, containsString("roleType"));
	   
	   //RolePropertiesNotAllowed
	   assertTrue(failedConstraints.containsKey("RolePropertiesNotAllowed"));
	   
	   String errorRolePropertiesNotAllowed = failedConstraints.get("RolePropertiesNotAllowed");
	   assertThat(errorRolePropertiesNotAllowed, containsString("RoleTypes can not define attributes. Failed for RoleType(s):"));
	   assertThat(errorRolePropertiesNotAllowed, containsString("roleType"));
	   
	   //CompartmentBehaviorNotAllowed
	   assertTrue(failedConstraints.containsKey("CompartmentBehaviorNotAllowed"));
	   
	   String errorCompartmentBehaviorNotAllowed = failedConstraints.get("CompartmentBehaviorNotAllowed");
	   assertThat(errorCompartmentBehaviorNotAllowed, containsString("CompartmentTypes can not define operations. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentBehaviorNotAllowed, containsString("compartmentType"));
	   
	   //CompartmentPropertiesNotAllowed
	   assertTrue(failedConstraints.containsKey("CompartmentPropertiesNotAllowed"));
	   
	   String errorCompartmentPropertiesNotAllowed = failedConstraints.get("CompartmentPropertiesNotAllowed");
	   assertThat(errorCompartmentPropertiesNotAllowed, containsString("CompartmentTypes can not define attributes. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentPropertiesNotAllowed, containsString("compartmentType"));
	   
	   // TODO: RoleDefinedInCompartment
   }
   
  
   
   /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testRoleTypeInheritanceNot() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/roletype_inheritance_not.crom");
		
	   //RT and CT properties/behavior disabled	
	   //Role Inheritance disabled
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removeRoleInheritance();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	

	   //RoleDefinedInExactlyOneCompartment
	   assertTrue(failedConstraints.containsKey("RoleDefinedInExactlyOneCompartment"));
	   
	   String errorRoleDefinedInExactlyOneCompartment = failedConstraints.get("RoleDefinedInExactlyOneCompartment");
	   assertThat(errorRoleDefinedInExactlyOneCompartment, containsString("Every RoleType must be defined in exactly one CompartmentType. Failed for RoleType(s):"));
	   assertThat(errorRoleDefinedInExactlyOneCompartment, containsString("roleType in compartmentType"));  
	   assertThat(errorRoleDefinedInExactlyOneCompartment, containsString("roleType in compartmentType1"));  
	   
	   //RoleInheritanceNotAllowed
	   assertTrue(failedConstraints.containsKey("RoleInheritanceNotAllowed"));
	   
	   String errorRoleInheritanceNotAllowed = failedConstraints.get("RoleInheritanceNotAllowed");
	   assertThat(errorRoleInheritanceNotAllowed, containsString("RoleInheritance is not allowed. Failed for:"));
	   assertThat(errorRoleInheritanceNotAllowed, containsString("roleParent <- roleChild"));
   }
   
   /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testRoleTypePlayers() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/roleplayers.crom");
		
	   //RolePlayers disabled
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removeRolePlayers();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //RolePlayableByRoleNotAllowed
	   assertTrue(failedConstraints.containsKey("RolePlayableByRoleNotAllowed"));
	   
	   String errorRolePlayableByRoleNotAllowed = failedConstraints.get("RolePlayableByRoleNotAllowed");
	   assertThat(errorRolePlayableByRoleNotAllowed, containsString("RoleTypes can not play roles. Failed for Fulfillment(s):"));
	   assertThat(errorRolePlayableByRoleNotAllowed, containsString("[roleType -> roleType1 in compartmentType2]"));

	   //RolePlayableByCompartmentNotAllowed
	   assertTrue(failedConstraints.containsKey("RolePlayableByCompartmentNotAllowed"));
	   
	   String errorRolePlayableByCompartmentNotAllowed = failedConstraints.get("RolePlayableByCompartmentNotAllowed");
	   assertThat(errorRolePlayableByCompartmentNotAllowed, containsString("CompartmentTypes can not play roles. Failed for Fulfillment(s):"));
	   assertThat(errorRolePlayableByCompartmentNotAllowed, containsString("[compartmentPlayer -> roleType in compartmentType]"));

	   //RolePlayableByCompartmentNotAllowed
	   assertTrue(failedConstraints.containsKey("RolePlayableByDataNotAllowed"));
	   
	   String errorRolePlayableByDataNotAllowed = failedConstraints.get("RolePlayableByDataNotAllowed");
	   assertThat(errorRolePlayableByDataNotAllowed, containsString("DataTypes can not play roles. Failed for Fulfillment(s):"));
	   assertThat(errorRolePlayableByDataNotAllowed, containsString("[dataPlayer -> roleType in compartmentType]"));
   }
   
   /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testRoleTypeConstraints() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/roleconstraints.crom");
		
	   //RoleConstraints disabled
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removeRoleConstraints();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   	
	   assertThat(failedConstraints.size(), not(0));
	   //RoleImplicationNotAllowed
	   assertTrue(failedConstraints.containsKey("RoleImplicationNotAllowed"));
	   
	   String errorRoleImplicationNotAllowed = failedConstraints.get("RoleImplicationNotAllowed");
	   assertThat(errorRoleImplicationNotAllowed, containsString("Role implications are not allowed. Failed for RoleImplication(s):"));
	   assertThat(errorRoleImplicationNotAllowed, containsString("roleType <=> roleType1"));

	   //RoleProhibitionNotAllowed
	   assertTrue(failedConstraints.containsKey("RoleProhibitionNotAllowed"));
	   
	   String errorRoleProhibitionNotAllowed = failedConstraints.get("RoleProhibitionNotAllowed");
	   assertThat(errorRoleProhibitionNotAllowed, containsString("Role prohibitions are not allowed. Failed for RoleProhibition(s):"));
	   assertThat(errorRoleProhibitionNotAllowed, containsString("roleType <=> roleType1"));

	   //RoleEquivalenceNotAllowed
	   assertTrue(failedConstraints.containsKey("RoleEquivalenceNotAllowed"));
	   
	   String errorRoleEquivalenceNotAllowed = failedConstraints.get("RoleEquivalenceNotAllowed");
	   assertThat(errorRoleEquivalenceNotAllowed, containsString("Role equivalences are not allowed. Failed for RoleEquivalence(s):"));
	   assertThat(errorRoleEquivalenceNotAllowed, containsString("roleType <=> roleType1"));

	   //RoleGroupNotAllowed
	   assertTrue(failedConstraints.containsKey("RoleGroupNotAllowed"));
	   
	   String errorRoleGroupNotAllowed = failedConstraints.get("RoleGroupNotAllowed");
	   assertThat(errorRoleGroupNotAllowed, containsString("Role groups are not allowed:"));
	   assertThat(errorRoleGroupNotAllowed, containsString("roleGroup in compartmentType"));
	   
	   //RoleOccurrenceConstraintNotAllowed
	   assertTrue(failedConstraints.containsKey("RoleOccurrenceConstraintNotAllowed"));
	   
	   String errorRoleOccurrenceConstraintNotAllowed = failedConstraints.get("RoleOccurrenceConstraintNotAllowed");
	   assertThat(errorRoleOccurrenceConstraintNotAllowed, containsString("Occurence constraints are not allowed:"));
	   assertThat(errorRoleOccurrenceConstraintNotAllowed, containsString("[(1,1) for roleType in compartmentType]"));
	   assertThat(errorRoleOccurrenceConstraintNotAllowed, containsString("[(0,5) for roleType1 in compartmentType]"));
 }
   
   /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testRelationshipConstraints() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/relationships.crom");
		
	   //CT Inheritance disabled
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removeCompartmentInheritance();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //RelationshipHasCardinality
	   
	   //IntraRelationshipContainsValidRelationship
	   assertTrue(failedConstraints.containsKey("IntraRelationshipContainsValidRelationship"));
	   
	   String errorIntraRelationshipContainsValidRelationship = failedConstraints.get("IntraRelationshipContainsValidRelationship");
	   assertThat(errorIntraRelationshipContainsValidRelationship, containsString("Every Intra relationship needs to contain a valid Relationship. Failed for IntraRelationship(s):"));
	   assertThat(errorIntraRelationshipContainsValidRelationship, containsString("rstOutside in compartmentType"));

	   //InterRelationshipsAreDistinct
	   assertTrue(failedConstraints.containsKey("InterRelationshipsAreDistinct"));
	   
	   String errorInterRelationshipsAreDistinct = failedConstraints.get("InterRelationshipsAreDistinct");
	   assertThat(errorInterRelationshipsAreDistinct, containsString("The Relationships of an InterRelationshipConstraint can not be the same. Failed for InterRelationshipConstraint(s):"));
	   assertThat(errorInterRelationshipsAreDistinct, containsString("(rst<->rst) in compartmentType"));
			   
	   //InterRelationshipInSameCompartment
	   assertTrue(failedConstraints.containsKey("InterRelationshipInSameCompartment"));
	   
	   String errorInterRelationshipInSameCompartment = failedConstraints.get("InterRelationshipInSameCompartment");
	   assertThat(errorInterRelationshipInSameCompartment, containsString("The Relationships of an InterRelationshipConstraint must be in the same Compartment Type. Failed for InterRelationshipConstraint(s):"));
	   assertThat(errorInterRelationshipInSameCompartment, containsString("(rst<->rst1) in compartmentType"));
   }
    
   /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testRelationshipConstraintsNotAllowed() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/relationships_not.crom");
		
	   //RelationshipConstraints disabled
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removeRelationshipConstraints();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //RelationshipCardinalityNotAllowed
	   assertTrue(failedConstraints.containsKey("RelationshipCardinalityNotAllowed"));
	   
	   String errorRelationshipCardinalityNotAllowed = failedConstraints.get("RelationshipCardinalityNotAllowed");
	   assertThat(errorRelationshipCardinalityNotAllowed, containsString("Relationship cardinalities are not allowed. Failed for Relationship(s):"));
	   assertThat(errorRelationshipCardinalityNotAllowed, containsString("rst in compartmentType"));
	   
	   //IntraRelationshipConstraintsNotAllowed
	   assertTrue(failedConstraints.containsKey("IntraRelationshipConstraintsNotAllowed"));
	   
	   String errorIntraRelationshipConstraintsNotAllowed = failedConstraints.get("IntraRelationshipConstraintsNotAllowed");
	   assertThat(errorIntraRelationshipConstraintsNotAllowed, containsString("Intra relationship constraints are not allowed. Failed for IntraRelationship(s):"));
	   assertThat(errorIntraRelationshipConstraintsNotAllowed, containsString("rst in compartmentType"));
	   
	   //InterRelationshipConstraintsNotAllowed
	   assertTrue(failedConstraints.containsKey("InterRelationshipConstraintsNotAllowed"));
	   
	   String errorInterRelationshipConstraintsNotAllowed = failedConstraints.get("InterRelationshipConstraintsNotAllowed");
	   assertThat(errorInterRelationshipConstraintsNotAllowed, containsString("Inter relationship constraints are not allowed. Failed for Failed for InterRelationshipConstraint(s):"));
	   assertThat(errorInterRelationshipConstraintsNotAllowed, containsString("(rst1<->rst) in compartmentType"));
   }
   
   /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testCompartmentInheritance() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/compartment_inheritance.crom");
		
	   //No need to disable anything
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //SubCompartmentContainsRoleTypesOfBaseCompartment
	   assertTrue(failedConstraints.containsKey("SubCompartmentContainsRoleTypesOfBaseCompartment"));
	   
	   String errorSubCompartmentContainsRoleTypesOfBaseCompartment = failedConstraints.get("SubCompartmentContainsRoleTypesOfBaseCompartment");
	   assertThat(errorSubCompartmentContainsRoleTypesOfBaseCompartment, containsString("Sub Compartments need to contain Role Types of Base Compartments. Failed for Compartment Inheritance(s):"));
	   assertThat(errorSubCompartmentContainsRoleTypesOfBaseCompartment, containsString("compartmentParent <- compartmentChild"));
	   
	   //SubCompartmentContainsRelationshipsOfBaseCompartment
	   assertTrue(failedConstraints.containsKey("SubCompartmentContainsRelationshipsOfBaseCompartment"));
	   
	   String errorSubCompartmentContainsRelationshipsOfBaseCompartment = failedConstraints.get("SubCompartmentContainsRelationshipsOfBaseCompartment");
	   assertThat(errorSubCompartmentContainsRelationshipsOfBaseCompartment, containsString("Sub Compartments need to contain Relationships of Base Compartments. Failed for Compartment Inheritance(s):"));
	   assertThat(errorSubCompartmentContainsRelationshipsOfBaseCompartment, containsString("compartmentParent <- compartmentChild"));
	   
	   //SubCompartmentRelationshipsEqualsBaseCompartmentRelationships
	   assertTrue(failedConstraints.containsKey("SubCompartmentRelationshipsEqualsBaseCompartmentRelationships"));
	   
	   String errorSubCompartmentRelationshipsEqualsBaseCompartmentRelationships = failedConstraints.get("SubCompartmentRelationshipsEqualsBaseCompartmentRelationships");
	   assertThat(errorSubCompartmentRelationshipsEqualsBaseCompartmentRelationships, containsString("The Relationships of Sub Compartments need to equal to the Relationships of Base Compartments. Failed for Compartment Inheritance(s):"));
	   assertThat(errorSubCompartmentRelationshipsEqualsBaseCompartmentRelationships, containsString("compartmentParent <- compartmentChild"));
   }
   
   /**
	 * @throws URISyntaxException
	 * @throws IOException
	 */
   @Test
   public void testCompartmentInheritanceNot() throws URISyntaxException, IOException {
	   //Load faulty crom instance
	   Resource cromResource = ResourceLoader.loadFile("testcases/errorcases/compartment_inheritance_not.crom");
		
	   //Disable Compartment/DateInheritance, ContainsCompartment
	   ConfigBuilder configBuilder = new ConfigBuilder();
	   configBuilder.removeCompartmentInheritance()
	   				.removeContainsCompartment()
	   				.removeDataInheritance();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //CompartmentInheritanceNotAllowed
	   assertTrue(failedConstraints.containsKey("CompartmentInheritanceNotAllowed"));
	   
	   String errorCompartmentInheritanceNotAllowed = failedConstraints.get("CompartmentInheritanceNotAllowed");
	   assertThat(errorCompartmentInheritanceNotAllowed, containsString("CompartmentInheritance is not allowed. Failed for:"));
	   assertThat(errorCompartmentInheritanceNotAllowed, containsString("compartmentParent <- compartmentChild"));
	  		   
	   //CompartmentContainsCompartmentNotAllowed
	   assertTrue(failedConstraints.containsKey("CompartmentContainsCompartmentNotAllowed"));
	   
	   String errorCompartmentContainsCompartmentNotAllowed = failedConstraints.get("CompartmentContainsCompartmentNotAllowed");
	   assertThat(errorCompartmentContainsCompartmentNotAllowed, containsString("Compartments can not contain other Compartments. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentContainsCompartmentNotAllowed, containsString("compartmentChild"));
			   
	   //DataTypeInheritanceNotAllowed
	   assertTrue(failedConstraints.containsKey("DataTypeInheritanceNotAllowed"));
	   
	   String errorDataTypeInheritanceNotAllowed = failedConstraints.get("DataTypeInheritanceNotAllowed");
	   assertThat(errorDataTypeInheritanceNotAllowed, containsString("DataInheritance is not allowed. Failed for:"));
	   assertThat(errorDataTypeInheritanceNotAllowed, containsString("dataParent <- dataChild"));
   }
}