package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Recipe;
import index.FileHashMap;

public class LoadTimeThread extends Thread {
	public HashMap<Integer, List<Recipe>> recipeByTime;
	private FileHashMap<Integer, List<Recipe>>  fileTime = new FileHashMap<Integer, List<Recipe>> ();
	private String fileNameReviewsById = "RecipeByTime";
	
	
	@Override
	public void run() {
		System.out.println("Time thread");
		recipeByTime = fileTime.load(fileNameReviewsById);

	}

	public HashMap<Integer, List<Recipe>>  getRecipeByTime() {
		return recipeByTime;
	}
}
