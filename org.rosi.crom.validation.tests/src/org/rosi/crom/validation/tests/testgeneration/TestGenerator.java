package org.rosi.crom.validation.tests.testgeneration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.framed.iorm.featuremodel.FRaMEDFeature;
import org.framed.iorm.transformation.test.model.test.TestCase;
import org.rosi.crom.validation.tests.utils.ResourceLoader;

import crom_l1_composed.AbstractRole;
import crom_l1_composed.Acyclic;
import crom_l1_composed.CompartmentInheritance;
import crom_l1_composed.CompartmentType;
import crom_l1_composed.Constraint;
import crom_l1_composed.Crom_l1_composedFactory;
import crom_l1_composed.Cyclic;
import crom_l1_composed.DataInheritance;
import crom_l1_composed.DataType;
import crom_l1_composed.Fulfillment;
import crom_l1_composed.Group;
import crom_l1_composed.Irreflexive;
import crom_l1_composed.ModelElement;
import crom_l1_composed.Part;
import crom_l1_composed.Reflexive;
import crom_l1_composed.Relation;
import crom_l1_composed.Relationship;
import crom_l1_composed.RelationshipExclusion;
import crom_l1_composed.RelationshipImplication;
import crom_l1_composed.RoleConstraint;
import crom_l1_composed.RoleEquivalence;
import crom_l1_composed.RoleGroup;
import crom_l1_composed.RoleGroupElement;
import crom_l1_composed.RoleImplication;
import crom_l1_composed.RoleInheritance;
import crom_l1_composed.RoleProhibition;
import crom_l1_composed.RoleType;
import crom_l1_composed.Total;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

/**
 * @author Kevin Kassin This generates test cases in the folder "Generated"
 *         based on baseTest.xmi
 *         
 * @author Florian Amberg Edited to support the needs of evaluating a CROM file
 */
public class TestGenerator {

	/**
	 * Object that creates configurations for test cases
	 */
	public ConfigGenerator configGenerator;

	/**
	 * This method takes the basic test case to generate test cases influenced by an
	 * feature configuration.
	 * 
	 * @param testcase
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws UnsupportedModelException
	 */
	public void generateTestCases() throws IOException, URISyntaxException, UnsupportedModelException {
		configGenerator = new ConfigGenerator();
		List<BitSet> configList = configGenerator.generateConfigurations();

		for (BitSet config : configList) {
			TestCase testCase = ResourceLoader.loadTestCase("testcases/Generated/baseTest.xmi");

			// delete feature entries in framed model depending on configuration
			testCase = editFeatureConfiguration(testCase, config);
			// change crom model depending on configuration
			testCase = editCromModel(testCase, config);
			// change title and description of the generated testcase
			testCase = editTitle(testCase, config);
			testCase = editDescription(testCase, config);

			String str_config = configGenerator.bitSetToString(config);

			URI fileURI = URI.createFileURI("testcases/Generated/" + str_config + ".xmi");
			createTestFile(testCase, fileURI);
		}
	}

	/**
	 * Edits the title of the given testCase depending on the given configuration
	 * 
	 * @param testCase
	 * @param config
	 * @return changed testCase
	 */
	public TestCase editTitle(TestCase testCase, BitSet config) {
		testCase.setTitle("Generated test " + configGenerator.bitSetToString(config));
		return testCase;
	}

	/**
	 * Edits the description of the given testCase depending on the given
	 * configuration
	 * 
	 * @param testCase
	 * @param config
	 * @return changed testCase
	 */
	public TestCase editDescription(TestCase testCase, BitSet config) {
		String description;
		boolean firstFeature = true;
		description = "This test was generated. The following features are choosen: ";
		for (FRaMEDFeature feature : testCase.getFramedModel().getFramedConfiguration().getFeatures()) {
			if (!firstFeature)
				description = description + ", ";
			description = description + feature.getName();
			firstFeature = false;
		}
		testCase.setDescription(description);
		return testCase;
	}

	/**
	 * Edits the feature list/ framed configuration of the given testCase depending
	 * on the given configuration
	 * 
	 * @param testCase
	 * @param config
	 * @return changed testCase
	 */
	public TestCase editFeatureConfiguration(TestCase testCase, BitSet config) {
		EList<FRaMEDFeature> featureList = testCase.getFramedModel().getFramedConfiguration().getFeatures();

		if (!config.get(0) && !config.get(1))
			featureList.remove(getFeatureNumber("Role_Structure", featureList));
		if (!config.get(0)) {
			featureList.remove(getFeatureNumber("Role_Properties", featureList));
			featureList.remove(getFeatureNumber("Role_Behavior", featureList));
		}
		if (!config.get(1))
			featureList.remove(getFeatureNumber("Role_Inheritance", featureList));
		if (!config.get(2))
			featureList.remove(getFeatureNumber("Compartments", featureList));
		if (!config.get(3))
			featureList.remove(getFeatureNumber("Dates", featureList));
		if (!config.get(4) && !config.get(5) && !config.get(6) && !config.get(7) && !config.get(8))
			featureList.remove(getFeatureNumber("Role_Constraints", featureList));
		if (!config.get(4))
			featureList.remove(getFeatureNumber("Role_Implication", featureList));
		if (!config.get(5))
			featureList.remove(getFeatureNumber("Role_Prohibition", featureList));
		if (!config.get(6))
			featureList.remove(getFeatureNumber("Role_Equivalence", featureList));
		if (!config.get(7))
			featureList.remove(getFeatureNumber("Group_Constraints", featureList));
		if (!config.get(8))
			featureList.remove(getFeatureNumber("Occurrence_Constraints", featureList));
		if (!config.get(9) && !config.get(13))
			featureList.remove(getFeatureNumber("Dependent", featureList));
		if (!config.get(9)) {
			featureList.remove(getFeatureNumber("On_Relationships", featureList));
			featureList.remove(getFeatureNumber("Relationships", featureList));
		}
		if (!config.get(10) && !config.get(11) && !config.get(12))
			featureList.remove(getFeatureNumber("Relationship_Constraints", featureList));
		if (!config.get(10))
			featureList.remove(getFeatureNumber("Relationship_Cardinality", featureList));
		if (!config.get(11)) {
			featureList.remove(getFeatureNumber("Intra_Relationship_Constraints", featureList));
			featureList.remove(getFeatureNumber("Parthood_Constraints", featureList));
		}
		if (!config.get(12))
			featureList.remove(getFeatureNumber("Inter_Relationship_Constraints", featureList));
		if (!config.get(13)) {
			featureList.remove(getFeatureNumber("On_Compartments", featureList));
			featureList.remove(getFeatureNumber("Compartment_Types", featureList));
		}
		if (!config.get(14) && !config.get(15)) {
			featureList.remove(getFeatureNumber("Compartment_Structure", featureList));
		}
		if (!config.get(14)) {
			featureList.remove(getFeatureNumber("Compartment_Properties", featureList));
			featureList.remove(getFeatureNumber("Compartment_Behavior", featureList));
		}
		if (!config.get(15))
			featureList.remove(getFeatureNumber("Compartment_Inheritance", featureList));
		if (!config.get(16)) {
			featureList.remove(getFeatureNumber("Participants", featureList));
			featureList.remove(getFeatureNumber("Playable_by_Defining_Compartment", featureList));
		}
		if (!config.get(17))
			featureList.remove(getFeatureNumber("Data_Types", featureList));
		if (!config.get(18))
			featureList.remove(getFeatureNumber("Data_Type_Inheritance", featureList));
		if (!config.get(19)) {
			featureList.remove(getFeatureNumber("Roles", featureList));
			featureList.remove(getFeatureNumber("Contains_Compartments", featureList));
		}
		return testCase;
	}

	/**
	 * Edits the crom model of the given testCase depending on the given
	 * configuration
	 * 
	 * @param testCase
	 * @param config
	 * @return changed testCase
	 */
	public TestCase editCromModel(TestCase testCase, BitSet config) {
		EList<ModelElement> cromElements = testCase.getCromModel().getElements();
		List<ModelElement> ElementsToDelete = new ArrayList<ModelElement>();
		List<ModelElement> ElementsToDeleteFromGroup = new ArrayList<ModelElement>();
		List<Relation> RelationsToDelete = new ArrayList<Relation>();

		// Properties and Behavior
		// -----------------------
		// Role_Properties, Role_Behavior
		if (!config.get(0)) {
			deleteAttsAndOpsInRolesRecursive(cromElements);
		}

		// Compartment_Types, Compartment_Behavior, Compartment_Properties
		if (!config.get(14)) {
			// find compartments
			for (ModelElement element : cromElements) {
				// delete the attributes and operations
				if (element instanceof CompartmentType) {
					((CompartmentType) element).getAttributes().clear();
					((CompartmentType) element).getOperations().clear();
				}
			}
		}

		// Constraints
		// -----------
		// Role_Implication
		if (!config.get(4)) {
			changeRoleConstraints("RoleImplication", cromElements);
		}

		// Role_Prohibition
		if (!config.get(5)) {
			changeRoleConstraints("RoleProhibition", cromElements);
		}

		// Role_Equivalence
		if (!config.get(6)) {
			changeRoleConstraints("RoleEquivalence", cromElements);
		}

		// Group_Constraints
		if (!config.get(7)) {
			EList<Relation> relations = testCase.getCromModel().getRelations();
			// find compartment types
			for (ModelElement element : cromElements) {
				if (element instanceof CompartmentType) {
					CompartmentType ct = (CompartmentType) element;
					DeleteRoleGroupsInCompartmentType(ct, relations);
				}
				// search in groups down to the second level for compartments
				if (element instanceof Group) {
					for (ModelElement innerElement : ((Group) element).getElements()) {
						if (innerElement instanceof CompartmentType) {
							CompartmentType innerCt = (CompartmentType) innerElement;
							DeleteRoleGroupsInCompartmentType(innerCt, relations);
						}
						if (innerElement instanceof Group) {
							for (ModelElement innerInnerElement : ((Group) innerElement).getElements()) {
								if (innerInnerElement instanceof CompartmentType) {
									CompartmentType innerInnerCt = (CompartmentType) innerInnerElement;
									DeleteRoleGroupsInCompartmentType(innerInnerCt, relations);
								}
							}
						}
					}
				}
			}
		}

		// Occurence_Constraints
		if (!config.get(8)) {
			// find compartment types
			for (ModelElement element : cromElements) {
				if (element instanceof CompartmentType) {
					for (Part part : ((CompartmentType) element).getParts()) {
						part.setLower(0);
						part.setUpper(-1);
					}
				}
				// search in groups down to the second level for compartments
				if (element instanceof Group) {
					for (ModelElement innerElement : ((Group) element)
							.getElements()) {
						if (innerElement instanceof CompartmentType) {
							for (Part part : ((CompartmentType) innerElement).getParts()) {
								part.setLower(0);
								part.setUpper(-1);
							}
						}
						if (innerElement instanceof Group) {
							for (ModelElement innerInnerElement : ((Group) innerElement)
									.getElements()) {
								if (innerInnerElement instanceof CompartmentType) {
									for (Part part : ((CompartmentType) innerInnerElement)
											.getParts()) {
										part.setLower(0);
										part.setUpper(-1);
									}
								}
							}
						}
					}
				}
			}
		}

		// Relationship
		if (!config.get(9)) {
			deleteRelationshipsRecursive(cromElements);
		}

		// Relationship_Cardinality
		if (!config.get(10)) {
			deleteRelationshipCardinalitiesRecursive(cromElements);
		}

		// Intra_Relationship_Constraints
		if (!config.get(11)) {
			deleteIntraRelConsRecursive(cromElements);
		}

		// Inter_Relationship_Constraints
		if (!config.get(12)) {
			deleteInterRelConsRecursive(cromElements);
		}

		// Fulfillments
		// ------------
		// Compartments
		if (!config.get(2)) {
			// find fulfillments
			for (Relation relation : testCase.getCromModel().getRelations()) {
				if (relation instanceof Fulfillment) {
					// delete fulfilment if filler is compartment_type
					if (((Fulfillment) relation)
							.getFiller() instanceof CompartmentType)
						RelationsToDelete.add(relation);
				}
			}
			for (Relation relation : RelationsToDelete)
				testCase.getCromModel().getRelations().remove(relation);
			RelationsToDelete.clear();
		}

		// Dates
		if (!config.get(3)) {
			// find fulfillments
			for (Relation relation : testCase.getCromModel().getRelations()) {
				if (relation instanceof Fulfillment) {
					// delete fulfilment if filler is data type
					if (((Fulfillment) relation).getFiller() instanceof DataType)
						RelationsToDelete.add(relation);
				}
			}
			for (Relation relation : RelationsToDelete)
				testCase.getCromModel().getRelations().remove(relation);
			RelationsToDelete.clear();
		}

		// Group Constraints
		if (!config.get(7)) {
			deleteFulfillmentsWithFilledRoleGroups(testCase.getCromModel().getRelations());
			for (ModelElement element : cromElements) {
				if (element instanceof Group) {
					deleteFulfillmentsWithFilledRoleGroups(((Group) element).getRelations());
					for (ModelElement innerElement : ((Group) element).getElements()) {
						if (innerElement instanceof Group) {
							deleteFulfillmentsWithFilledRoleGroups(((Group) innerElement).getRelations());
						}
					}
				}
			}
		}

		// Playable_By_Defining_Compartment
		if (!config.get(16)) {
			// find fulfillments
			for (Relation relation : testCase.getCromModel().getRelations()) {
				if (relation instanceof Fulfillment) {
					if (((Fulfillment) relation)
							.getFiller() instanceof CompartmentType) {
						// delete fulfilment if filler is compartment_type
						CompartmentType filler = (CompartmentType) ((Fulfillment) relation)
								.getFiller();
						RoleType filled = (RoleType) ((Fulfillment) relation)
								.getFilled();
						// is filled role in filler compartment types
						for (Part part : filler.getParts()) {
							if (part.getRole() instanceof RoleType)
								if (part.getRole() == filled)
									RelationsToDelete.add(relation);
							if (part.getRole() instanceof RoleGroup) {
								if (RoleGroupChildContainsRole((RoleGroup) part.getRole(), filled))
									RelationsToDelete.add(relation);
							}
						}
					}
				}
			}
			for (Relation relation : RelationsToDelete)
				testCase.getCromModel().getRelations().remove(relation);
			RelationsToDelete.clear();
		}

		// Inheritances
		// ------------
		// Role_Inheritance
		if (!config.get(1)) {
			for (Relation relation : testCase.getCromModel().getRelations()) {
				// find compartment inheritances, delete them
				if (relation instanceof RoleInheritance)
					RelationsToDelete.add(relation);
			}
			for (Relation relation : RelationsToDelete)
				testCase.getCromModel().getRelations().remove(relation);
			RelationsToDelete.clear();
		}

		// Compartment_Inheritance
		if (!config.get(15)) {
			for (Relation relation : testCase.getCromModel().getRelations()) {
				// find compartment inheritances, delete them
				if (relation instanceof CompartmentInheritance)
					RelationsToDelete.add(relation);
			}
			
			int unique_i = 0;
			for (Relation relation : RelationsToDelete) {
				CompartmentInheritance ctInheritance = (CompartmentInheritance)relation;
				CompartmentType subCt = ctInheritance.getSub();
				for(Part part : subCt.getParts()) {
					if(part.getRole() instanceof RoleType){
						RoleType rt = (RoleType) part.getRole();
						rt.setName(String.format("%s_%s", rt.getName(), subCt.getName()));
						unique_i++;
					}
				}
				
				testCase.getCromModel().getRelations().remove(relation);
			}
			RelationsToDelete.clear();
		}

		// Data_Type_Inheritance
		if (!config.get(18)) {
			for (Relation relation : testCase.getCromModel().getRelations()) {
				// find data type inheritances, delete them
				if (relation instanceof DataInheritance)
					RelationsToDelete.add(relation);
			}
			for (Relation relation : RelationsToDelete)
				testCase.getCromModel().getRelations().remove(relation);
		}

		// Datatype
		// --------
		if (!config.get(17)) {
			for (ModelElement element : cromElements) {
				// find data types, delete them
				if (element instanceof DataType)
					ElementsToDelete.add(element);
				if (element instanceof Group) {
					for (ModelElement groupElement : ((Group) element)
							.getElements()) {
						if (groupElement instanceof DataType)
							ElementsToDeleteFromGroup.add(groupElement);
						if (groupElement instanceof Group)
							deleteDataTypesRecursive((Group) groupElement);
					}
					for (ModelElement elementToDelete : ElementsToDeleteFromGroup)
						((Group) element).getElements().remove(elementToDelete);
				}
			}
			for (ModelElement element : ElementsToDelete)
				cromElements.remove(element);
			ElementsToDelete.clear();
		}

		// compartment types in compartment types/ roles fulfill roles
		if (!config.get(19)) {
			for (ModelElement element : cromElements) {
				if (element instanceof CompartmentType) {
					CompartmentType compartmentType = (CompartmentType) element;
					compartmentType.getContains().clear();
					compartmentType.getFulfillments().clear();
				}
			}
		}

		return testCase;
	}

	
	/**
	 * deletes all relationships in compartment types starting from a given list of
	 * {@link ModelElement}s
	 * 
	 * @param elements a list of model elements
	 */
	private void deleteRelationshipsRecursive(EList<ModelElement> elements) {
		List<Relationship> RelationshipsToDelete = new ArrayList<Relationship>();
		// iterate over the given list of model elements
		for (ModelElement element : elements) {
			// compartment type found
			if (element instanceof CompartmentType) {
				CompartmentType compartmentType = (CompartmentType) element;
				// delete relationships
				for (Relationship relationship : (compartmentType.getRelationships()))
					RelationshipsToDelete.add(relationship);
				for (Relationship relation : RelationshipsToDelete)
					compartmentType.getRelationships().remove(relation);
				// delete relationships in inner compartment types
				for (CompartmentType innerCT : compartmentType.getContains())
					deleteRelationshipsInInnerCompartmentType(innerCT);
			}
			// group found: call operation recursively for its elements
			if (element instanceof Group) {
				deleteRelationshipsRecursive(((Group) element).getElements());
			}
		}
	}

	/**
	 * Traverses in a given Compartment Type: deletes relationships and calls method
	 * recursive for other groups
	 */
	public void deleteRelationshipsInInnerCompartmentType(CompartmentType compartmentType) {
		List<Relationship> RelationshipsToDelete = new ArrayList<Relationship>();
		for (Relationship relationship : (compartmentType.getRelationships()))
			RelationshipsToDelete.add(relationship);
		for (Relationship relation : RelationshipsToDelete)
			compartmentType.getRelationships().remove(relation);
		for (CompartmentType innerCT : compartmentType.getContains()) {
			deleteRelationshipsInInnerCompartmentType(innerCT);
		}
	}

	/**
	 * deletes all relationships cardinalities starting from a given list of
	 * {@link ModelElement}s
	 * 
	 * @param elements a list of model elements
	 */
	private void deleteRelationshipCardinalitiesRecursive(EList<ModelElement> elements) {
		for (ModelElement element : elements) {
			// compartment type found
			if (element instanceof CompartmentType) {
				for (Relationship relationship : (((CompartmentType) element).getRelationships())) {
					// get place, set place generic
					relationship.getFirst().setLower(0);
					relationship.getFirst().setUpper(-1);
					relationship.getSecond().setLower(0);
					relationship.getSecond().setUpper(-1);
				}
			}
			// group found: call operation recursively for its elements
			if (element instanceof Group) {
				deleteRelationshipCardinalitiesRecursive(((Group) element).getElements());
			}
		}
	}

	/**
	 * deletes all intra relationships constraints starting from a given list of
	 * {@link ModelElement}s
	 * 
	 * @param elements a list of model elements
	 */
	private void deleteIntraRelConsRecursive(EList<ModelElement> elements) {
		List<Constraint> ConstraintsToDelete = new ArrayList<Constraint>();
		for (ModelElement element : elements) {
			// compartment type found: find relatioships and delete its intra rel cons
			if (element instanceof CompartmentType) {
				for (Relation constraint : ((CompartmentType) element).getConstraints()) {
					if (constraint instanceof Reflexive
							|| constraint instanceof Irreflexive
							|| constraint instanceof Total
							|| constraint instanceof Cyclic
							|| constraint instanceof Acyclic)
						ConstraintsToDelete.add((Constraint) constraint);
				}
				for (Constraint constraint : ConstraintsToDelete)
					((CompartmentType) element).getConstraints().remove(constraint);
			}
			// group found: call operation recursively for its elements
			if (element instanceof Group) {
				deleteIntraRelConsRecursive(((Group) element).getElements());
			}
		}
	}

	/**
	 * deletes all inter relationships constraints starting from a given list of
	 * {@link ModelElement}s
	 * 
	 * @param elements a list of model elements
	 */
	private void deleteInterRelConsRecursive(EList<ModelElement> elements) {
		List<Constraint> ConstraintsToDelete = new ArrayList<Constraint>();
		for (ModelElement element : elements) {
			// compartment type found: find inter rel cons and delete them
			if (element instanceof CompartmentType) {
				for (Relation constraint : ((CompartmentType) element).getConstraints()) {
					if (constraint instanceof RelationshipImplication
							|| constraint instanceof RelationshipExclusion)
						ConstraintsToDelete.add((Constraint) constraint);
				}
				for (Constraint constraint : ConstraintsToDelete)
					((CompartmentType) element).getConstraints().remove(constraint);
			}
			// group found: call operation recursively for its elements
			if (element instanceof Group) {
				deleteInterRelConsRecursive(((Group) element).getElements());
			}
		}
	}

	/**
	 * deletes all attributes and operation in role group starting from a given list
	 * of {@link ModelElement}s
	 * 
	 * @param elements a list of model elements
	 */
	private void deleteAttsAndOpsInRolesRecursive(EList<ModelElement> elements) {
		for (ModelElement element : elements) {
			// compartment type found
			if (element instanceof CompartmentType) {
				// find role type of the compartment type and in role group
				for (Part part : ((CompartmentType) element).getParts()) {
					if (part.getRole() instanceof RoleType)
						DeleteAttsAndOpsFromRole((RoleType) part.getRole());
					if (part.getRole() instanceof RoleGroup) {
						// iterate over RoleGroup elements
						for (RoleGroupElement roleGroupElement : ((RoleGroup) part.getRole())
								.getElements()) {
							if (roleGroupElement instanceof RoleType)
								DeleteAttsAndOpsFromRole((RoleType) roleGroupElement);
							if (roleGroupElement instanceof RoleGroup)
								deleteAttsAndOpsFromRolesInRoleGroups((RoleGroup) roleGroupElement);
						}
					}
				}
			}
			// group found: call operation recursively for its elements
			if (element instanceof Group) {
				deleteAttsAndOpsInRolesRecursive(((Group) element).getElements());
			}
		}
	}

	/**
	 * Deletes attributes and operations of a given role
	 * 
	 * @param role
	 */
	public void DeleteAttsAndOpsFromRole(RoleType role) {
		role.getAttributes().clear();
		role.getOperations().clear();
	}

	/**
	 * Traverses in a given Rolegroup: delete attributes and operations in role,
	 * call method recursive for other role groups
	 * 
	 * @param roleGroup
	 */
	public void deleteAttsAndOpsFromRolesInRoleGroups(RoleGroup roleGroup) {
		for (RoleGroupElement roleGroupElement : roleGroup.getElements()) {
			if (roleGroupElement instanceof RoleType)
				DeleteAttsAndOpsFromRole((RoleType) roleGroupElement);
			if (roleGroupElement instanceof RoleGroup)
				deleteAttsAndOpsFromRolesInRoleGroups((RoleGroup) roleGroupElement);
		}
	}

	/**
	 * Deletes a role constraint of a type specified by constraintType from a given
	 * list of crom model elements
	 * 
	 * @param constraintType
	 * @param cromElements
	 */
	public void changeRoleConstraints(String constraintType, EList<ModelElement> cromElements) {
		EList<Constraint> constraints;
		ArrayList<Constraint> toDelete;

		// find compartment types
		for (ModelElement element : cromElements) {
			if (element instanceof CompartmentType) {
				// find constraints
				constraints = ((CompartmentType) element).getConstraints();
				toDelete = new ArrayList<Constraint>();
				for (Constraint constraint : constraints) {
					// find role implications
					if (constraint instanceof RoleImplication
							&& constraintType.equals("RoleImplication"))
						toDelete.add(constraint);
					if (constraint instanceof RoleProhibition
							&& constraintType.equals("RoleProhibition"))
						toDelete.add(constraint);
					if (constraint instanceof RoleEquivalence
							&& constraintType.equals("RoleEquivalence"))
						toDelete.add(constraint);
				}
				// delete role implication
				for (Constraint constraint : toDelete)
					constraints.remove(constraints.indexOf(constraint));
			}
		}
	}

	/**
	 * Traverses in a given Group: delete data types, call method recursive for
	 * other groups
	 * 
	 * @param group
	 */
	public void deleteDataTypesRecursive(Group group) {
		List<ModelElement> ElementsToDelete = new ArrayList<ModelElement>();
		for (ModelElement groupElement : group.getElements()) {
			if (groupElement instanceof DataType) {
				ElementsToDelete.add(groupElement);
			}
			if (groupElement instanceof Group)
				deleteDataTypesRecursive((Group) groupElement);
		}
		for (ModelElement element : ElementsToDelete) {
			group.getElements().remove(element);
		}
	}

	/**
	 * Checks if a played role is part of a role group of the playing compartment
	 * type itself
	 * 
	 * @param roleGroup
	 * @param filled
	 * @return boolean if a played role is part of a role group of the playing
	 *         compartment type itself
	 */
	public boolean RoleGroupChildContainsRole(RoleGroup roleGroup, RoleType filled) {
		for (RoleGroupElement roleGroupElement : roleGroup.getElements()) {
			if (roleGroupElement instanceof RoleType)
				if ((RoleType) roleGroupElement == filled)
					return true;
			if (roleGroupElement instanceof RoleGroup)
				RoleGroupChildContainsRole((RoleGroup) roleGroupElement, filled);
		}
		return false;
	}

	
	/**
	 * finds all {@link Fulfillment}s which are linked to role types or groups within a compartment type
	 * 
	 * @param relations a list of model relations
	 * @param ct the compartment type, in which to search for fullfilments
	 */
	private List<Fulfillment> FindFulfillmentsForCompartmentType(CompartmentType ct, EList<Relation> relations) {
		List<Fulfillment> fulfillmentsForRoleGroupsInCompartment = new ArrayList<Fulfillment>();
	
		for (Relation relation : relations) {
			if (relation instanceof Fulfillment) {
				Fulfillment ful = (Fulfillment) relation;

				if (ful.getFilled() instanceof RoleGroup) {
					if(ct.equals(GetCompartmentType(ful.getFilled())))
							fulfillmentsForRoleGroupsInCompartment.add(ful);
				}
			}
		}
		
		return fulfillmentsForRoleGroupsInCompartment;
	}
	
	/**
	 * finds the {@link CompartmentType} for an (inner) RoleGroup/RoleType recursive
	 * 
	 * @param relations a list of model relations
	 */
	private CompartmentType GetCompartmentType(EObject object) {
		if(object.eContainer() == null)
			return null;
		
		if(object.eContainer() instanceof CompartmentType) {
			return (CompartmentType)object.eContainer();
		}
		else
			return GetCompartmentType(object.eContainer());
	}

	
	/**
	 * Deletes all role groups in a given compartment type
	 * 
	 * @param compartment
	 * @param fulfillments 
	 */
	public void DeleteRoleGroupsInCompartmentType(CompartmentType compartment, EList<Relation> relations) {
		List<Part> rg_partsToDelete = new ArrayList<Part>();
		List<Constraint> constraintsToDelete = new ArrayList<Constraint>();
		List<RoleGroup> deletedRoleGroups = new ArrayList<RoleGroup>();

		List<RoleType> roleTypesToAddToCT_Role = new ArrayList<RoleType>();
		List<int[]> roleTypesToAddToCT_OC = new ArrayList<int[]>();
		
		List<Fulfillment> linkedFulfillments =  FindFulfillmentsForCompartmentType(compartment, relations);
		

		int[] standardOC = { 0, -1 };
		// find roleGroups
		for (Part part : compartment.getParts()) {
			if (part.getRole() instanceof RoleType) {
				RoleType role = (RoleType) part.getRole();
				int[] oc = { part.getLower(), part.getUpper() };
				roleTypesToAddToCT_Role.add(role);
				roleTypesToAddToCT_OC.add(oc);
				rg_partsToDelete.add(part);
			}
			if (part.getRole() instanceof RoleGroup) {
				RoleGroup roleGroup = (RoleGroup) part.getRole();
				deletedRoleGroups.add(roleGroup);
				for (RoleGroupElement element : roleGroup.getElements()) {
					if (element instanceof RoleType) {
						roleTypesToAddToCT_Role.add((RoleType) element);
						roleTypesToAddToCT_OC.add(standardOC);
					}
					// find role group in role group
					if (element instanceof RoleGroup) {
						deletedRoleGroups.add((RoleGroup) element);
						for (RoleGroupElement innerElement : ((RoleGroup) element).getElements()) {
							if (innerElement instanceof RoleType) {
								roleTypesToAddToCT_Role.add((RoleType) innerElement);
								roleTypesToAddToCT_OC.add(standardOC);
							}
							if (innerElement instanceof RoleGroup) {
								deletedRoleGroups.add((RoleGroup) innerElement);
							}
						}
					}
				}
				// delete role groups
				rg_partsToDelete.add(part);
				// delete constraints with a connection to the deleted role group
				for (Constraint con : compartment.getConstraints()) {
					if (con instanceof RoleConstraint) {
						RoleConstraint roleCon = (RoleConstraint) con;
						if (deletedRoleGroups.contains(roleCon.getFirst())
								|| deletedRoleGroups.contains(roleCon.getSecond()))
							constraintsToDelete.add(roleCon);
					}
				}
			}
		}
		for (Part part : rg_partsToDelete)
			compartment.getParts().remove(part);
		
		for (int i = 0; i < roleTypesToAddToCT_Role.size(); i++) {
			RoleType oldRoleType = roleTypesToAddToCT_Role.get(i);
			EObject oldRoleTypeContainer = oldRoleType.eContainer();
					
			Part newPart = Crom_l1_composedFactory.eINSTANCE.createPart();
			newPart.setRole(oldRoleType);
			if (!(roleTypesToAddToCT_OC.get(i).equals(standardOC)))
				newPart.setLower(roleTypesToAddToCT_OC.get(i)[0]);
			newPart.setUpper(roleTypesToAddToCT_OC.get(i)[1]);
			newPart.setWhole(compartment);
			
			// Create new fulfillments for children of RoleGroups
			if(!linkedFulfillments.isEmpty())
			{
				while(oldRoleTypeContainer instanceof RoleGroup) {
					RoleGroup roleGroup = (RoleGroup)oldRoleTypeContainer;

					Optional<Fulfillment> oldFulfillment = linkedFulfillments.stream()
									  	  .filter(f -> f.getFilled().equals(roleGroup))
									  	  .findFirst();
					if(oldFulfillment.isPresent()) {
						Fulfillment newFulfillment = Crom_l1_composedFactory.eINSTANCE.createFulfillment();
						newFulfillment.setFilled(newPart.getRole());
						newFulfillment.setFiller(oldFulfillment.get().getFiller());
						
						relations.add(newFulfillment);	
					}
					oldRoleTypeContainer = oldRoleTypeContainer.eContainer();
				}
			}
						
		}
		for (Constraint con : constraintsToDelete)
			compartment.getConstraints().remove(con);
	}

	/**
	 * delete fulfillments with role groups as filled roles
	 * 
	 * @param relations a list of relation to search in for fulfillments to delete
	 */
	private void deleteFulfillmentsWithFilledRoleGroups(EList<Relation> relations) {
		List<Fulfillment> fulfillmentsToDelete = new ArrayList<Fulfillment>();
		for (Relation relation : relations) {
			if (relation instanceof Fulfillment) {
				Fulfillment ful = (Fulfillment) relation;
				if (ful.getFilled() instanceof RoleGroup) {
					fulfillmentsToDelete.add(ful);
				}
			}
		}

		for (Fulfillment ful : fulfillmentsToDelete) {
			relations.remove(ful);
		}
	}

	/**
	 * Stores the given test case inside the specified {@link URI}
	 * 
	 * @param object {@link EObject} to be stored
	 * @param file   {@link URI} of destination file
	 * @return created {@link Resource}
	 */
	private Resource createTestFile(TestCase testCase, URI file) {
		ResourceSet set1 = new ResourceSetImpl();
		Resource res1 = set1.createResource(file);

		if (testCase != null)
			res1.getContents().add(EcoreUtil.copy(testCase));
		try {
			res1.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
		return res1;
	}

	/**
	 * This method calculates the index of the feature in the given featureList with
	 * the given featureName
	 * 
	 * @param featureName
	 * @param featureList
	 * @return the index of the feature in the given featureList with the given
	 *         featureName
	 */
	private static int getFeatureNumber(String featureName, EList<FRaMEDFeature> featureList) {
		for (FRaMEDFeature feature : featureList) {
			if (featureName.equals(feature.getName().getLiteral()))
				return featureList.indexOf(feature);
		}
		return -1;
	}

}
