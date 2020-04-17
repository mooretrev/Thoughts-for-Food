package containers;

import java.util.HashMap;
import java.util.List;

import index.FileHashMap;
import index.IndexRecipes;
import index.IndexReviews;
import index.threads.RecipesThread;
import index.threads.ReviewsThread;

public class Data {
	
	public HashMap<Integer, Recipe> recipeById; // recipe id get the recipe info
	public HashMap<Integer, List<Review>> reviewsById; //recipe id gets a list of reiew for that recipes
	public HashMap<String, List<Recipe>> recipeByIngredent;
	public HashMap<Integer, List<Recipe>> recipeByTime;
 
	
	private FileHashMap<Integer, Recipe> fileRecipeById;
	private String fileNameRecipeById = "RecipeById";
	
	private FileHashMap<Integer, List<Review>> fileReviewsById;
	private String fileNameReviewsById = "ReviewById";
	
	public Data() {
		fileRecipeById = new FileHashMap<Integer, Recipe>();
		fileReviewsById = new FileHashMap<Integer, List<Review>>();
	}
	
	public void index() {
		IndexRecipes indexRecipes = new IndexRecipes();
		recipeById = indexRecipes.index();
		fileRecipeById.save(recipeById, fileNameRecipeById);
		
		IndexReviews indexReviews = new IndexReviews();
		reviewsById = indexReviews.index();
		fileReviewsById.save(reviewsById, fileNameReviewsById);
		
	}
	
	public void load() {
		RecipesThread recipesThread = new RecipesThread();
		recipesThread.start();
		
		ReviewsThread reviewThread = new ReviewsThread();
		reviewThread.start();
		
		try {
			recipesThread.join();
			reviewThread.join();
			System.out.println("data loaded");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		recipeById = recipesThread.getRecipeById();
		reviewsById = reviewThread.getReviewsById();
	}
	

}
