//package gui;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.swing.JFrame;
//
//import org.junit.jupiter.api.Test;
//
//import containers.Data;
//import containers.Recipe;
//import gui.results.RecipeResults;
//import index.FileObject;
//
//class TestRecipeResults {
//
//	@Test
//	void test() {
//		Data data = new Data();
//		data.loadRecipeById();
//		data.loadReviews();
//		
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.setSize(640, 500);
//		
//		FileObject fileObject = new FileObject();
//		List<Recipe> recipes = (List<Recipe>) fileObject.load("recipes");
//		
//		RecipeResults panel = new RecipeResults(recipes, null);
//		
//		frame.add(panel);
//		
//		
//		try {
//			Thread.sleep(1000000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	void loadRecipes() {
//		Data data = new Data();
//		data.loadRecipeById();
//		
//		List<Recipe> recipes = new ArrayList<Recipe>(10);
//		
//		Iterator<Integer> iter = data.recipeById.keySet().iterator();
//		
//		for(int i = 0; i < 10; ++i) {
//			recipes.add(data.recipeById.get(iter.next()));
//		}
//		
//		FileObject file = new FileObject();
//		file.save(recipes, "recipes");
//		
//		
//		
//	
//		
//	}
//
//}
