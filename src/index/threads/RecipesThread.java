package index.threads;

import java.util.HashMap;

import containers.Recipe;
import index.FileHashMap;

public class RecipesThread extends Thread{
	
	public HashMap<Integer, Recipe> recipeById;
	private FileHashMap<Integer, Recipe> fileRecipeById = new FileHashMap<Integer, Recipe>();
	private String fileNameRecipeById = "RecipeById";
	
	@Override
	public void run() {
		System.out.println("recipes thread");
		recipeById = fileRecipeById.load(fileNameRecipeById);

	}

	public HashMap<Integer, Recipe> getRecipeById() {
		return recipeById;
	}
}
