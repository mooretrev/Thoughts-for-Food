//package gui;
//
//import javax.swing.JFrame;
//
//import org.junit.jupiter.api.Test;
//
//import containers.Recipe;
//import gui.results.RecipeResultRow;
//import index.FileObject;
//
//class TestRecipeResultRow {
//
//	@Test
//	void test() {
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.setSize(640, 100);
//		
//		FileObject fileObject = new FileObject();
//		Recipe recipe = (Recipe) fileObject.load("recipe");
//		
//		RecipeResultRow panel = new RecipeResultRow(recipe);
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
//}
