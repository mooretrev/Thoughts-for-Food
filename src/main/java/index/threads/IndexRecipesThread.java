package index.threads;

import containers.Recipe;
import index.FileHashMap;
import index.IndexRecipes;

public class IndexRecipesThread extends Thread {
	
	private FileHashMap<Integer, Recipe> fileRecipeById = new FileHashMap<Integer, Recipe>();
	private String fileNameRecipeById = "RecipeById";
	
	@Override
	public void run() {
		IndexRecipes indexRecipes = new IndexRecipes();
		fileRecipeById.save(indexRecipes.index(), fileNameRecipeById);
	}
	

}
