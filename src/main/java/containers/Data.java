package containers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import index.threads.SaveRecipesThread;
import index.threads.SaveReviewsThread;
import index.threads.SaveTimeThread;
import index.threads.LoadIngredientsThread;
import index.threads.LoadRecipesThread;
import index.threads.LoadReviewsThread;
import index.threads.LoadTimeThread;
import index.threads.SaveIngredientsThread;

public class Data implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6675170999080797863L;
	
	public HashMap<Integer, Recipe> recipeById; // recipe id get the recipe info
	public HashMap<Integer, List<Review>> reviewsById; //recipe id gets a list of reiew for that recipes
	public HashMap<String, List<Recipe>> recipeByIngredent;
	public HashMap<Integer, List<Recipe>> recipeByTime;
	
	public void index() {
		SaveRecipesThread recipesThread = new SaveRecipesThread();
		recipesThread.start();
		System.out.println("recipes thread started");

		
		SaveReviewsThread reviewsThread = new SaveReviewsThread();
		reviewsThread.start();
		System.out.println("reviews thread started");

		
		try {
			recipesThread.join();
			System.out.println("recipes thread finished");
			reviewsThread.join();
			System.out.println("reviews thread finished");
			
			recipeById = recipesThread.recipeById;

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		
		SaveIngredientsThread saveIngredients = new SaveIngredientsThread(recipeById);
		saveIngredients.start();
		
		SaveTimeThread saveTime = new SaveTimeThread(recipeById);
		saveTime.start();
		
		try {
			saveIngredients.join();
			System.out.println("ingredents thread finished");
			saveTime.join();
			System.out.println("ingredents thread finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void indexTime() {
			SaveRecipesThread recipesThread = new SaveRecipesThread();
			recipesThread.start();
			System.out.println("recipes thread started");
			
			try {
				recipesThread.join();
				System.out.println("recipes thread finished");		
				recipeById = recipesThread.recipeById;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			SaveTimeThread saveTime = new SaveTimeThread(recipeById);
			saveTime.start();
			
			try {
				saveTime.join();
				System.out.println("ingredents thread finished");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public void load() {
		LoadRecipesThread recipesThread = new LoadRecipesThread();
		recipesThread.start();
//		
		LoadReviewsThread reviewThread = new LoadReviewsThread();
		reviewThread.start();
		
		LoadIngredientsThread ingredientsThread = new LoadIngredientsThread();
		ingredientsThread.start();
		
		LoadTimeThread timeThread = new LoadTimeThread();
		timeThread.start();
		
		try {
			recipesThread.join();
			reviewThread.join();
			ingredientsThread.join();
			timeThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		recipeById = recipesThread.getRecipeById();
		reviewsById = reviewThread.getReviewsById();
		recipeByIngredent = ingredientsThread.getRecipeByIngredient();	
		recipeByTime = timeThread.getRecipeByTime();
		System.out.println("data loaded");

	
	}
	

}
