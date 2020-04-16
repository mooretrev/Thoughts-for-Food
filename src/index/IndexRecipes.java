package index;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import parser.CSVParser;

import containers.Recipe;

public class IndexRecipes {

	//	private String filePath = "test data/test_receipes_raw.csv";
	private String filePath = "data/RAW_recipes.csv";

	private int numRows = 12;

	public HashMap<Integer, Recipe> index() {
		HashMap<Integer, Recipe> map = new HashMap<Integer, Recipe>();

		ArrayList<String> data = null; 

		try {
			FileReader filereader = new FileReader(filePath); 
			CSVParser csvReader = new CSVParser(filereader); 

			csvReader.readLine(); // skip the title line
			while ((data = csvReader.readLine()) != null) { 
				Recipe recipe = new Recipe();

				if(data.size() == numRows) {
					recipe.setId(Integer.parseInt(data.get(C.id.ordinal())));
					recipe.setName(data.get(C.name.ordinal()));
					recipe.setCookTime(Integer.parseInt(data.get(C.minutes.ordinal())));
					recipe.setTags(splitArray(data.get(C.tags.ordinal())));
					recipe.setNumInstructions(Integer.parseInt(data.get(C.numSteps.ordinal())));
					recipe.setInstructions(splitArray(data.get(C.steps.ordinal())));
					recipe.setDescription(data.get(C.description.ordinal()));
					recipe.setNumIngredients(Integer.parseInt(data.get(C.numIngredents.ordinal())));
					recipe.setIngredients(splitArray(data.get(C.ingredents.ordinal())));
					map.put(recipe.getId(), recipe);
				}
			} 
			csvReader.close();
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return map;
	}

	public ArrayList<String> splitArray(String str) {
		String[] split = str.split(",");
		ArrayList<String> words = new ArrayList<String>();
		for(int i = 0; i < split.length; ++i) {
			words.add(split[i]);
		}


		for (int i = 0; i < words.size(); ++i) {
			String temp = words.get(i);
			temp = temp.replace("'", "");
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");


			if(temp.length() >= 1 && temp.charAt(0) == ' ') {
				temp = temp.substring(1);
			}

			if(temp.length() >= 1 && temp.charAt(temp.length() - 1) == ' ') {
				temp = temp.substring(0, temp.length() - 1);
			}


			words.set(i, temp);			
		}

		return words;
	}

	enum C 
	{ 
		name, id, minutes, contributorId, sumbitted, tags, nutrition, numSteps, steps, description, ingredents, numIngredents
	} 

}
