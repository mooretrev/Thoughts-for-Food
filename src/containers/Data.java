package containers;

import java.io.Serializable;
import java.util.HashMap;

import index.FileHashMap;
import index.IndexRecipes;

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1444720292418779919L;
	
	public HashMap<Integer, Recipe> recipeById;
	private FileHashMap<Integer, Recipe> fileRecipeById;
	private String fileNameRecipeById = "RecipeById";
	
	public HashMap<Integer, Review[]> reviewsById;
	private FileHashMap<Integer, Recipe> fileReviewsById;
	private String fileNameReviewsById = "ReviewById";
	
	public Data() {
		fileRecipeById = new FileHashMap<Integer, Recipe>();
		fileReviewsById = new FileHashMap<Integer, Recipe>();
	}
	
	public void index() {
		IndexRecipes indexRecipes = new IndexRecipes();
		recipeById = indexRecipes.index();
		
		fileRecipeById.save(recipeById, fileNameRecipeById);
	}
	
	public void load() {
		recipeById = fileRecipeById.load(fileNameRecipeById);
	}
	

}
