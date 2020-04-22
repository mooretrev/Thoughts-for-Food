package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Recipe;
import index.FileObject;

public class LoadIngredientsThread extends Thread{
	
	public HashMap<String, List<Recipe>> recipeByIngredient;
	private FileObject fileIngredients = new FileObject();
	private String fileNameReviewsById = "RecipesByIngredients";
	
	
	@Override
	public void run() {
		System.out.println("ingredient thread");
		recipeByIngredient = (HashMap<String, List<Recipe>>) fileIngredients.load(fileNameReviewsById);

	}

	public HashMap<String, List<Recipe>>  getRecipeByIngredient() {
		return recipeByIngredient;
	}

}
