package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Recipe;
import index.FileObject;
import index.IndexTime;

public class SaveTimeThread extends Thread {
	private FileObject  fileTime = new FileObject ();
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
