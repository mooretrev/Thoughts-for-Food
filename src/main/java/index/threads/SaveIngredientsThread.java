package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Data;
import containers.Recipe;
import index.FileHashMap;
import index.IndexIngredents;
import index.IndexTime;

public class SaveIngredientsThread extends Thread{
	private FileHashMap<String, List<Recipe>>  fileIngredients = new FileHashMap<String, List<Recipe>> ();
	private String fileNameReviewsById = "RecipesByIngredients";
	private HashMap<Integer, Recipe> recipeById;
		
	public SaveIngredientsThread(HashMap<Integer, Recipe> recipeById) {
		super();
		this.recipeById = recipeById;	
		}
	
	@Override
	public void run() {
		IndexIngredents indexIngredents = new IndexIngredents(recipeById);
		fileIngredients.save(indexIngredents.index(), fileNameReviewsById);
	}
}
