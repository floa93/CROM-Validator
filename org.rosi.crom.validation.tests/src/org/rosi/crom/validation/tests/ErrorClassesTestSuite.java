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

/** This class is used to test the errors and their responses
 * @author Florian Amberg
 *
 */
public class ErrorClassesTestSuite
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
	   assertThat(failedConstraints.containsKey("CompartmentContainsRoles"), is(true));
	   
	   String errorCompartmentContainsRoles = failedConstraints.get("CompartmentContainsRoles");
	   assertThat(errorCompartmentContainsRoles, containsString("Every CompartmentType must define at least one RoleType. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentContainsRoles, containsString("CompartmentContainsRoles"));
	   
	   //CompartmentContainsFilledRoles
	   assertThat(failedConstraints.containsKey("CompartmentContainsFilledRoles"), is(true));
	   
	   String errorCompartmentContainsFilledRoles = failedConstraints.get("CompartmentContainsFilledRoles");
	   assertThat(errorCompartmentContainsFilledRoles, containsString("RoleTypes in Compartments need to be filled. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentContainsFilledRoles, containsString("CompartmentContainsFilledRoles"));
	   
	   //RoleFilled
	   assertThat(failedConstraints.containsKey("RoleFilled"), is(true));
	   
	   String errorRoleFilled = failedConstraints.get("RoleFilled");
	   assertThat(errorRoleFilled, containsString("Every RoleType must be filled. Failed for RoleType(s):"));
	   assertThat(errorRoleFilled, containsString("roleTypeA"));
	   
	   //RelationshipDefinedInCompartment
	   assertThat(failedConstraints.containsKey("RelationshipDefinedInCompartment"), is(true));
	   
	   String errorRelationshipDefinedInCompartment = failedConstraints.get("RelationshipDefinedInCompartment");
	   assertThat(errorRelationshipDefinedInCompartment, containsString("Every Relationship needs to be defined in a CompartmentType. Failed for Relationship(s):"));
	   assertThat(errorRelationshipDefinedInCompartment, containsString("rstOutside"));
	   
	   //RelationshipRolesAreDistinct
	   assertThat(failedConstraints.containsKey("RelationshipRolesAreDistinct"), is(true)); 
	   
	   String errorRelationshipRolesAreDistinct = failedConstraints.get("RelationshipRolesAreDistinct");
	   assertThat(errorRelationshipRolesAreDistinct, containsString("Relationships between the same RoleTypes are not allowed. Failed for Relationship(s) between:"));
	   assertThat(errorRelationshipRolesAreDistinct, containsString("relRoleA <-> relRoleA"));
	   
	   
	   //RelationshipRolesInSameCompartment
	   assertThat(failedConstraints.containsKey("RelationshipRolesInSameCompartment"), is(true));
	   
	   String errorRelationshipRolesInSameCompartment = failedConstraints.get("RelationshipRolesInSameCompartment");
	   assertThat(errorRelationshipRolesInSameCompartment, containsString("The RoleTypes of a Relationship need to be in the same CompartmentType. Failed for Relationship(s) between:"));
	   assertThat(errorRelationshipRolesInSameCompartment, containsString("relRoleC <-> relRoleD"));
	   
	   //ConstraintDefinedInCompartment
	   assertThat(failedConstraints.containsKey("ConstraintDefinedInCompartment"), is(true));
	   
	   String errorConstraintDefinedInCompartment = failedConstraints.get("ConstraintDefinedInCompartment");
	   assertThat(errorConstraintDefinedInCompartment, containsString("Constraints cannot be defined outside of a Compartment Type. Failed for RoleConstraint(s):"));
	   assertThat(errorConstraintDefinedInCompartment, containsString("relRoleB <=> relRoleA"));

	   //ConstraintRolesInSameCompartment
	   assertThat(failedConstraints.containsKey("ConstraintRolesInSameCompartment"), is(true));
	   
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
	   assertThat(failedConstraints.containsKey("RoleBehaviorNotAllowed"), is(true));
	   
	   String errorRoleBehaviorNotAllowed = failedConstraints.get("RoleBehaviorNotAllowed");
	   assertThat(errorRoleBehaviorNotAllowed, containsString("RoleTypes cannot define operations. Failed for RoleType(s):"));
	   assertThat(errorRoleBehaviorNotAllowed, containsString("roleType"));
	   
	   //RolePropertiesNotAllowed
	   assertThat(failedConstraints.containsKey("RolePropertiesNotAllowed"), is(true));
	   
	   String errorRolePropertiesNotAllowed = failedConstraints.get("RolePropertiesNotAllowed");
	   assertThat(errorRolePropertiesNotAllowed, containsString("RoleTypes cannot define attributes. Failed for RoleType(s):"));
	   assertThat(errorRolePropertiesNotAllowed, containsString("roleType"));
	   
	   //CompartmentBehaviorNotAllowed
	   assertThat(failedConstraints.containsKey("CompartmentBehaviorNotAllowed"), is(true));
	   
	   String errorCompartmentBehaviorNotAllowed = failedConstraints.get("CompartmentBehaviorNotAllowed");
	   assertThat(errorCompartmentBehaviorNotAllowed, containsString("CompartmentTypes cannot define operations. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentBehaviorNotAllowed, containsString("compartmentType"));
	   
	   //CompartmentPropertiesNotAllowed
	   assertThat(failedConstraints.containsKey("CompartmentPropertiesNotAllowed"), is(true));
	   
	   String errorCompartmentPropertiesNotAllowed = failedConstraints.get("CompartmentPropertiesNotAllowed");
	   assertThat(errorCompartmentPropertiesNotAllowed, containsString("CompartmentTypes cannot define attributes. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentPropertiesNotAllowed, containsString("compartmentType"));
	   
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
	   assertThat(failedConstraints.containsKey("RoleDefinedInExactlyOneCompartment"), is(true));
	   
	   String errorRoleDefinedInExactlyOneCompartment = failedConstraints.get("RoleDefinedInExactlyOneCompartment");
	   assertThat(errorRoleDefinedInExactlyOneCompartment, containsString("Every RoleType must be defined in exactly one CompartmentType. Failed for RoleType(s):"));
	   assertThat(errorRoleDefinedInExactlyOneCompartment, containsString("roleType in compartmentType"));  
	   assertThat(errorRoleDefinedInExactlyOneCompartment, containsString("roleType in compartmentType1"));  
	   
	   //RoleInheritanceNotAllowed
	   assertThat(failedConstraints.containsKey("RoleInheritanceNotAllowed"), is(true));
	   
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
	   assertThat(failedConstraints.containsKey("RolePlayableByRoleNotAllowed"), is(true));
	   
	   String errorRolePlayableByRoleNotAllowed = failedConstraints.get("RolePlayableByRoleNotAllowed");
	   assertThat(errorRolePlayableByRoleNotAllowed, containsString("RoleTypes cannot play roles. Failed for Fulfillment(s):"));
	   assertThat(errorRolePlayableByRoleNotAllowed, containsString("[roleType -> roleType1 in compartmentType2]"));

	   //RolePlayableByCompartmentNotAllowed
	   assertThat(failedConstraints.containsKey("RolePlayableByCompartmentNotAllowed"), is(true));
	   
	   String errorRolePlayableByCompartmentNotAllowed = failedConstraints.get("RolePlayableByCompartmentNotAllowed");
	   assertThat(errorRolePlayableByCompartmentNotAllowed, containsString("CompartmentTypes cannot play roles. Failed for Fulfillment(s):"));
	   assertThat(errorRolePlayableByCompartmentNotAllowed, containsString("[compartmentPlayer -> roleType in compartmentType]"));

	   //RolePlayableByCompartmentNotAllowed
	   assertThat(failedConstraints.containsKey("RolePlayableByDataNotAllowed"), is(true));
	   
	   String errorRolePlayableByDataNotAllowed = failedConstraints.get("RolePlayableByDataNotAllowed");
	   assertThat(errorRolePlayableByDataNotAllowed, containsString("DataTypes cannot play roles. Failed for Fulfillment(s):"));
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
	   assertThat(failedConstraints.containsKey("RoleImplicationNotAllowed"), is(true));
	   
	   String errorRoleImplicationNotAllowed = failedConstraints.get("RoleImplicationNotAllowed");
	   assertThat(errorRoleImplicationNotAllowed, containsString("Role implications are not allowed. Failed for RoleImplication(s):"));
	   assertThat(errorRoleImplicationNotAllowed, containsString("roleType <=> roleType1"));

	   //RoleProhibitionNotAllowed
	   assertThat(failedConstraints.containsKey("RoleProhibitionNotAllowed"), is(true));
	   
	   String errorRoleProhibitionNotAllowed = failedConstraints.get("RoleProhibitionNotAllowed");
	   assertThat(errorRoleProhibitionNotAllowed, containsString("Role prohibitions are not allowed. Failed for RoleProhibition(s):"));
	   assertThat(errorRoleProhibitionNotAllowed, containsString("roleType <=> roleType1"));

	   //RoleEquivalenceNotAllowed
	   assertThat(failedConstraints.containsKey("RoleEquivalenceNotAllowed"), is(true));
	   
	   String errorRoleEquivalenceNotAllowed = failedConstraints.get("RoleEquivalenceNotAllowed");
	   assertThat(errorRoleEquivalenceNotAllowed, containsString("Role equivalences are not allowed. Failed for RoleEquivalence(s):"));
	   assertThat(errorRoleEquivalenceNotAllowed, containsString("roleType <=> roleType1"));

	   //RoleGroupNotAllowed
	   assertThat(failedConstraints.containsKey("RoleGroupNotAllowed"), is(true));
	   
	   String errorRoleGroupNotAllowed = failedConstraints.get("RoleGroupNotAllowed");
	   assertThat(errorRoleGroupNotAllowed, containsString("Role groups are not allowed:"));
	   assertThat(errorRoleGroupNotAllowed, containsString("roleGroup in compartmentType"));
	   
	   //RoleOccurrenceConstraintNotAllowed
	   assertThat(failedConstraints.containsKey("RoleOccurrenceConstraintNotAllowed"), is(true));
	   
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
	   assertThat(failedConstraints.containsKey("IntraRelationshipContainsValidRelationship"), is(true));
	   
	   String errorIntraRelationshipContainsValidRelationship = failedConstraints.get("IntraRelationshipContainsValidRelationship");
	   assertThat(errorIntraRelationshipContainsValidRelationship, containsString("Every Intra relationship needs to contain a valid Relationship. Failed for IntraRelationship(s):"));
	   assertThat(errorIntraRelationshipContainsValidRelationship, containsString("rstOutside in compartmentType"));

	   //InterRelationshipsAreDistinct
	   assertThat(failedConstraints.containsKey("InterRelationshipsAreDistinct"), is(true));
	   
	   String errorInterRelationshipsAreDistinct = failedConstraints.get("InterRelationshipsAreDistinct");
	   assertThat(errorInterRelationshipsAreDistinct, containsString("The Relationships of an InterRelationshipConstraint cannot be the same. Failed for InterRelationshipConstraint(s):"));
	   assertThat(errorInterRelationshipsAreDistinct, containsString("(rst<->rst) in compartmentType"));
			   
	   //InterRelationshipInSameCompartment
	   assertThat(failedConstraints.containsKey("InterRelationshipInSameCompartment"), is(true));
	   
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
	   assertThat(failedConstraints.containsKey("RelationshipCardinalityNotAllowed"), is(true));
	   
	   String errorRelationshipCardinalityNotAllowed = failedConstraints.get("RelationshipCardinalityNotAllowed");
	   assertThat(errorRelationshipCardinalityNotAllowed, containsString("Relationship cardinalities are not allowed. Failed for Relationship(s):"));
	   assertThat(errorRelationshipCardinalityNotAllowed, containsString("rst in compartmentType"));
	   
	   //IntraRelationshipConstraintsNotAllowed
	   assertThat(failedConstraints.containsKey("IntraRelationshipConstraintsNotAllowed"), is(true));
	   
	   String errorIntraRelationshipConstraintsNotAllowed = failedConstraints.get("IntraRelationshipConstraintsNotAllowed");
	   assertThat(errorIntraRelationshipConstraintsNotAllowed, containsString("Intra relationship constraints are not allowed. Failed for IntraRelationship(s):"));
	   assertThat(errorIntraRelationshipConstraintsNotAllowed, containsString("rst in compartmentType"));
	   
	   //InterRelationshipConstraintsNotAllowed
	   assertThat(failedConstraints.containsKey("InterRelationshipConstraintsNotAllowed"), is(true));
	   
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
	   assertThat(failedConstraints.containsKey("SubCompartmentContainsRoleTypesOfBaseCompartment"), is(true));
		 
	   String errorSubCompartmentContainsRoleTypesOfBaseCompartment = failedConstraints.get("SubCompartmentContainsRoleTypesOfBaseCompartment");
	   assertThat(errorSubCompartmentContainsRoleTypesOfBaseCompartment, containsString("Sub Compartments need to contain Role Types of Base Compartments. Failed for Compartment Inheritance(s):"));
	   assertThat(errorSubCompartmentContainsRoleTypesOfBaseCompartment, containsString("compartmentParent <- compartmentChild"));
	   
	   //SubCompartmentContainsRelationshipsOfBaseCompartment
	   assertThat(failedConstraints.containsKey("SubCompartmentContainsRelationshipsOfBaseCompartment"), is(true));
	   
	   String errorSubCompartmentContainsRelationshipsOfBaseCompartment = failedConstraints.get("SubCompartmentContainsRelationshipsOfBaseCompartment");
	   assertThat(errorSubCompartmentContainsRelationshipsOfBaseCompartment, containsString("Sub Compartments need to contain Relationships of Base Compartments. Failed for Compartment Inheritance(s):"));
	   assertThat(errorSubCompartmentContainsRelationshipsOfBaseCompartment, containsString("compartmentParent <- compartmentChild"));
	   
	   //SubCompartmentRelationshipsEqualsBaseCompartmentRelationships
	   assertThat(failedConstraints.containsKey("SubCompartmentRelationshipsEqualsBaseCompartmentRelationships"), is(true));
	   
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
	   				.removePlayableByDefiningCompartment()
	   				.removeDataInheritance();
	   
	   Map<String, String> failedConstraints = cromValidator.validate(cromResource, configBuilder.build());
	   
	   assertThat(failedConstraints.size(), not(0));	
	   
	   //CompartmentInheritanceNotAllowed
	   assertThat(failedConstraints.containsKey("CompartmentInheritanceNotAllowed"), is(true));
	   
	   String errorCompartmentInheritanceNotAllowed = failedConstraints.get("CompartmentInheritanceNotAllowed");
	   assertThat(errorCompartmentInheritanceNotAllowed, containsString("CompartmentInheritance is not allowed. Failed for:"));
	   assertThat(errorCompartmentInheritanceNotAllowed, containsString("compartmentParent <- compartmentChild"));
	  		   
	   //CompartmentContainsCompartmentNotAllowed
	   assertThat(failedConstraints.containsKey("CompartmentContainsCompartmentNotAllowed"), is(true));
	   
	   String errorCompartmentContainsCompartmentNotAllowed = failedConstraints.get("CompartmentContainsCompartmentNotAllowed");
	   assertThat(errorCompartmentContainsCompartmentNotAllowed, containsString("Compartments cannot contain other Compartments. Failed for CompartmentType(s):"));
	   assertThat(errorCompartmentContainsCompartmentNotAllowed, containsString("compartmentChild"));
			   
	   //PlayableByDefiningCompartmentNotAllowed
	   assertThat(failedConstraints.containsKey("PlayableByDefiningCompartmentNotAllowed"), is(true));
	   
	   String errorPlayableByDefiningCompartmentNotAllowed = failedConstraints.get("PlayableByDefiningCompartmentNotAllowed");
	   assertThat(errorPlayableByDefiningCompartmentNotAllowed, containsString("Defining Compartments cannot play inner RoleTypes. Failed for Fulfillment(s): "));
	   assertThat(errorPlayableByDefiningCompartmentNotAllowed, containsString("[playingCompartment -> playedRoleType in playingCompartment]"));
			   
	   //DataTypeInheritanceNotAllowed
	   assertThat(failedConstraints.containsKey("DataTypeInheritanceNotAllowed"), is(true));
	   
	   String errorDataTypeInheritanceNotAllowed = failedConstraints.get("DataTypeInheritanceNotAllowed");
	   assertThat(errorDataTypeInheritanceNotAllowed, containsString("DataInheritance is not allowed. Failed for:"));
	   assertThat(errorDataTypeInheritanceNotAllowed, containsString("dataParent <- dataChild"));
   }
}