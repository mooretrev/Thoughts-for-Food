package index.threads;

import java.util.HashMap;

import containers.Recipe;
import index.FileObject;
import index.IndexRecipes;

public class SaveRecipesThread extends Thread {
	
	public HashMap<Integer, Recipe> recipeById;

	private FileObject fileRecipeById = new FileObject();
	private String fileNameRecipeById = "RecipeById";
	
	@Override
	public void run() {
		IndexRecipes indexRecipes = new IndexRecipes();
		recipeById = indexRecipes.index();
		fileRecipeById.save(recipeById, fileNameRecipeById);
	}
	

}
