package index;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.opencsv.CSVReader;

import containers.Recipe;

public class IndexRecipes {

	//	private String filePath = "test data/test_receipes_raw.csv";
	private String filePath = "data/RAW_recipes.csv";

	private int numRows = 12;

	public HashMap<Integer, Recipe> index() {
		HashMap<Integer, Recipe> map = new HashMap<Integer, Recipe>();


		try {
			FileReader filereader = new FileReader(filePath); 
			CSVReader csvReader = new CSVReader(filereader); 
			String[] data; 

			csvReader.readNext(); // skip the title line
			while ((data = csvReader.readNext()) != null) { 
				Recipe recipe = new Recipe();

				recipe.setId(Integer.parseInt(data[C.id.ordinal()]));
				recipe.setName(data[C.name.ordinal()]);
				recipe.setCookTime(Integer.parseInt(data[C.minutes.ordinal()]));
				recipe.setTags(splitArray(data[C.tags.ordinal()]));
				recipe.setNumInstructions(Integer.parseInt(data[C.numSteps.ordinal()]));
				recipe.setInstructions(splitArray(data[C.steps.ordinal()]));
				recipe.setDescription(data[C.description.ordinal()]);
				recipe.setNumIngredients(Integer.parseInt(data[C.numIngredents.ordinal()]));
				recipe.setIngredients(splitArray(data[C.ingredents.ordinal()]));
//				System.out.println(recipe);
				map.put(recipe.getId(), recipe);
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
