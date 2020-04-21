package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Recipe;
import index.FileHashMap;

public class LoadIngredientsThread extends Thread{
	
	public HashMap<String, List<Recipe>> recipeByIngredient;
	private FileHashMap<String, List<Recipe>>  fileIngredients = new FileHashMap<String, List<Recipe>> ();
	private String fileNameReviewsById = "RecipesByIngredients";
	
	
	@Override
	public void run() {
		System.out.println("ingredient thread");
		recipeByIngredient = fileIngredients.load(fileNameReviewsById);

	}

	public HashMap<String, List<Recipe>>  getRecipeByIngredient() {
		return recipeByIngredient;
	}

}
