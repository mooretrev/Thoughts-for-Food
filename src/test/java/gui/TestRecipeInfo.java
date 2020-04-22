//package gui;
//
//import java.awt.Dimension;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.swing.JFrame;
//
//import org.junit.jupiter.api.Test;
//
//import containers.Data;
//import containers.Recipe;
//import containers.Review;
//import gui.results.RecipesInfo;
//import index.FileObject;
//
//class TestRecipeInfo {
//
//	@Test
//	void test() {
////		saveRecipe();
//		FileObject fileObject = new FileObject();
//		Recipe recipe = (Recipe) fileObject.load("recipe");
//		List<Review> reviews = (List<Review>) fileObject.load("reviews");
//		
//		new RecipesInfo(recipe, reviews);
//
//		try {
//			Thread.sleep(1000000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void saveRecipe() {
//		Data data = new Data();
//		data.loadRecipeById();
//		
//		Integer key = data.recipeById.keySet().iterator().next();
//		Recipe recipe = data.recipeById.get(key);
//		
//		FileObject fileObject = new FileObject();
//		fileObject.save(recipe, "recipe");
//	}
//	
//	public void loadSaveReview() {
//		Data data =  new Data();
//		data.loadRecipeById();
//		data.loadReviews();
//		
//		Integer key = data.recipeById.keySet().iterator().next();
//		
////		System.out.println(data.reviewsById.keySet());
//
//		List<Review> reviews = data.reviewsById.get(key);
//		
//		FileObject file = new FileObject();
//		file.save(reviews, "reviews");
//	}
//
//}
