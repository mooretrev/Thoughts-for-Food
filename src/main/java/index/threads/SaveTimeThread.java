package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Recipe;
import index.FileHashMap;
import index.IndexTime;

public class SaveTimeThread extends Thread {
	private FileHashMap<Integer, List<Recipe>>  fileTime = new FileHashMap<Integer, List<Recipe>> ();
	private String fileNameReviewsById = "RecipeByTime";
	private HashMap<Integer, Recipe> recipeById;
		
	public SaveTimeThread(HashMap<Integer, Recipe> recipeById) {
		super();
		this.recipeById = recipeById;	
		}
	
	@Override
	public void run() {
		IndexTime indexTime = new IndexTime(recipeById);
		fileTime.save(indexTime.index(), fileNameReviewsById);
	}



}
