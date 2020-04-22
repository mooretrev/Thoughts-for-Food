
package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Recipe;
import index.FileObject;
import index.IndexIngredents;

public class SaveIngredientsThread extends Thread{
	private FileObject  fileIngredients = new FileObject ();
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
