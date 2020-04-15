package containers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import index.FileHashMap;
import index.IndexRecipes;
import index.IndexReviews;
import index.threads.RecipesThread;
import index.threads.ReviewsThread;

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1444720292418779919L;
	
	public HashMap<Integer, Recipe> recipeById; // recipe id get the recipe info
	public HashMap<Integer, List<Review>> reviewsById; //recipe id gets a list of reiew for that recipes

	private FileHashMap<Integer, Recipe> fileRecipeById;
	private String fileNameRecipeById = "RecipeById";
	
	private FileHashMap<Integer, List<Review>> fileReviewsById;
	private String fileNameReviewsById = "ReviewById";
	
	public Data() {
		fileRecipeById = new FileHashMap<Integer, Recipe>();
		fileReviewsById = new FileHashMap<Integer, List<Review>>();
	}
	
	public void index() {
		IndexReviews indexReviews = new IndexReviews();
		reviewsById = indexReviews.index();
		fileReviewsById.save(reviewsById, fileNameReviewsById);
		
		IndexRecipes indexRecipes = new IndexRecipes();
		recipeById = indexRecipes.index();
		fileRecipeById.save(recipeById, fileNameRecipeById);
		
	}
	
	public void load() {
		RecipesThread recipesThread = new RecipesThread(fileRecipeById);
		recipesThread.start();
		
		ReviewsThread reviewThread = new ReviewsThread(fileReviewsById);
		reviewThread.start();
		
		try {
			recipesThread.join();
			reviewThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recipeById = recipesThread.getRecipeById();
		reviewsById = reviewThread.getReviewsById();
	}
	

}
