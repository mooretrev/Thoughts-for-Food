package containers;

import java.util.HashMap;
import java.util.List;

import index.threads.IndexRecipesThread;
import index.threads.IndexReviewsThread;
import index.threads.RecipesThread;
import index.threads.ReviewsThread;

public class Data {
	
	public HashMap<Integer, Recipe> recipeById; // recipe id get the recipe info
	public HashMap<Integer, List<Review>> reviewsById; //recipe id gets a list of reiew for that recipes
	public HashMap<String, List<Recipe>> recipeByIngredent;
	public HashMap<Integer, List<Recipe>> recipeByTime;
	
	public void index() {
		IndexRecipesThread recipesThread = new IndexRecipesThread();
		recipesThread.start();
		System.out.println("recipes thread started");

		
		IndexReviewsThread reviewsThread = new IndexReviewsThread();
		reviewsThread.start();
		System.out.println("reviews thread started");

		
		try {
			recipesThread.join();
			System.out.println("recipes thread finished");
			reviewsThread.join();
			System.out.println("reviews thread finished");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
