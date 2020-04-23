package index.threads;

import java.util.HashMap;

import containers.Recipe;
import index.FileObject;

public class LoadRecipesThread extends Thread{
	
	public HashMap<Integer, Recipe> recipeById;
	private FileObject fileRecipeById = new FileObject();
	private String fileNameRecipeById = "RecipeById";
	
	@Override
	public void run() {
		System.out.println("recipes thread");
		recipeById = (HashMap<Integer, Recipe>) fileRecipeById.load(fileNameRecipeById);

	}

	public HashMap<Integer, Recipe> getRecipeById() {
		return recipeById;
	}
}
