package org.rosi.crom.validation.tests.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/** Used to build the configs needed in the ErrorClassTestSuite
 * @author Florian Amberg
 *
 */
public class ConfigBuilder {
	   private List<String> config = getConfigListAll(); 
	
	   public ConfigBuilder removePropertiesAndBehavior() {
		   config.removeAll(
				   Arrays.asList("Role_Properties",
						   		 "Role_Behavior",
								 "Compartment_Properties",
								 "Compartment_Behavior")
				   );
	     return this;
	   }
	   
	   public ConfigBuilder removeCompartmentInheritance() {
		   config.remove("Compartment_Inheritance");
	     return this;
	   }
	   
	   public ConfigBuilder removeDataInheritance() {
		   config.remove("Data_Type_Inheritance");
	     return this;
	   }
	   
	   public ConfigBuilder removeContainsCompartment() {
		   config.remove("Contains_Compartments");
	     return this;
	   }
	   
	   public ConfigBuilder removePlayableByDefiningCompartment() {
		   config.remove("Playable_by_Defining_Compartment");
		   return this;
	   }
	   
	   public ConfigBuilder removeRoleInheritance() {
		   config.remove("Role_Inheritance");
	     return this;
	   }
	   
	   public ConfigBuilder removeRolePlayers() {
		   config.removeAll(
				   Arrays.asList("Naturals",
						   		 "Roles",
								 "Compartments",
								 "Dates")
				   );
	     return this;
	   }
	   
	   public ConfigBuilder removeRoleConstraints() {
		   config.removeAll(
				   Arrays.asList("Role_Implication",
						   		 "Role_Prohibition",
								 "Role_Equivalence",
								 "Group_Constraints",
								 "Occurrence_Constraints")
				   );
	     return this;
	   }
	   
	   public ConfigBuilder removeRelationshipConstraints() {
		   config.removeAll(
				   Arrays.asList("Relationship_Cardinality",
						   		 "Intra_Relationship_Constraints",
								 "Inter_Relationship_Constraints")
				   );
	     return this;
	   }
	
	   public List<String> build() {
	     return config;
	   }
	
	   /** All the configs as a default value
	 * @return
	 */
	private List<String> getConfigListAll(){
		   return new ArrayList<String>(
				   Arrays.asList(
				   "Role_Types",
				   "Role_Structure",
				   "Role_Properties",
				   "Role_Behavior",
				   "Role_Inheritance",
				   "Playable",
				   "Players",
				   "Naturals",
				   "Roles",
				   "Compartments",
				   "Dates",
				   "Dependent",
				   "On_Compartments",
				   "On_Relationships",
				   "Role_Constraints",
				   "Role_Implication",
				   "Role_Prohibition",
				   "Role_Equivalence",
				   "Group_Constraints",
				   "Occurrence_Constraints",
				   "Relationships",
				   "Relationship_Constraints",
				   "Relationship_Cardinality",
				   "Intra_Relationship_Constraints",
				   "Parthood_Constraints",
				   "Inter_Relationship_Constraints",
				   "Compartment_Types",
				   "Compartment_Structure",
				   "Compartment_Properties",
				   "Compartment_Behavior",
				   "Compartment_Inheritance",
				   "Participants",
				   "Contains_Compartments",
				   "Playable_by_Defining_Compartment",
				   "Data_Types",
				   "Data_Type_Inheritance"
				   )
			   );
	   }
}
