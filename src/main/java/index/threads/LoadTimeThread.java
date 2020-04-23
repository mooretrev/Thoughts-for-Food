package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Recipe;
import index.FileObject;

public class LoadTimeThread extends Thread {
	public HashMap<Integer, List<Recipe>> recipeByTime;
	private FileObject  fileTime = new FileObject ();
	private String fileNameReviewsById = "RecipeByTime";
	
	
	@Override
	public void run() {
		System.out.println("Time thread");
		recipeByTime = (HashMap<Integer, List<Recipe>>) fileTime.load(fileNameReviewsById);

	}

	public HashMap<Integer, List<Recipe>>  getRecipeByTime() {
		return recipeByTime;
	}
}
