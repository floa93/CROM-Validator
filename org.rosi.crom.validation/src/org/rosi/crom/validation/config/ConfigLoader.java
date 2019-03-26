package org.rosi.crom.validation.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class ConfigLoader {
	//Features:
	//-----------------------
	//RML_Feature_Model
	//Role_Types
	//Role_Structure
	//Role_Properties
	//Role_Behavior
	//Role_Inheritance
	//Playable
	//Players
	//Naturals
	//Roles
	//Compartments
	//Dates
	//Dependent
	//On_Compartments
	//On_Relationships
	//Role_Constraints
	//Role_Implication
	//Role_Prohibition
	//Role_Equivalence
	//Group_Constraints
	//Occurrence_Constraints
	//Relationships
	//Relationship_Constraints
	//Relationship_Cardinality
	//Intra_Relationship_Constraints
	//Parthood_Constraints
	//Inter_Relationship_Constraints
	//Compartment_Types
	//Compartment_Structure
	//Compartment_Properties
	//Compartment_Behavior
	//Compartment_Inheritance
	//Participants
	//Contains_Compartments
	//Playable_by_Defining_Compartment
	//Data_Types
	//Data_Type_Inheritance
	//-----------------------
	
	public static List<String> loadStandardConfig(){
		List<String> standardConfig = new ArrayList<String>();
		try {
			URL url = new URL("platform:/plugin/org.framed.iorm.featuremodel/model.xml");
		    InputStream inputStream = url.openConnection().getInputStream();
		    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		    String inputLine;
		 
		    while ((inputLine = in.readLine()) != null) {
		        Pattern featurePattern = Pattern.compile("name=\\\"(.*?)\\\"");
		        Matcher featureMatcher = featurePattern.matcher(inputLine);
		        while(featureMatcher.find())
		        {
		        	standardConfig.add(featureMatcher.group(1));
		        }
		    }
		    
		    in.close();
		 
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		
	    return standardConfig;		
	}
	
	private List<String> customConfigList, standardConfigList;
	
	public ConfigLoader(IPath cromPath) {
		this.customConfigList = new ArrayList<>();
		this.standardConfigList = loadStandardConfig();
		loadCustomConfig(cromPath);
	}
	


	private void loadCustomConfig(IPath cromPath) {
		IPath configPath = cromPath.removeFileExtension().addFileExtension("crom_cfg");
		IFile configFile = ResourcesPlugin.getWorkspace().getRoot().getFile(configPath);
		try {
			InputStream inputStream = configFile.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			while(reader.ready()) {
				String feature = reader.readLine();
				if(standardConfigList.contains(feature))
					customConfigList.add(feature);
			}

			reader.close();
			inputStream.close();
			
		} catch (CoreException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getConfigList(){
		// if the custom config failed to load, we use the standard config
		if(customConfigList.size() == 0)
			return standardConfigList;
		
		return customConfigList;
	}

	public void printConfig() {
		String config = getConfigList().
				stream().
				map(f -> f).
				collect(Collectors.joining("\n//"));
		System.out.println(config);		
	}
}
