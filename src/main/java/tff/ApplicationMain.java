package tff;

import javax.swing.JFrame;

import containers.Data;
import gui.Window;
import results.Results;
import search.IngredientSearch;
import search.NameSearch;
import search.TimeSearch;

public class ApplicationMain {
	public static void main(String[] args) {

		Data data = new Data();
		data.load();		
		NameSearch n = new NameSearch(data);
		Results r = n.search("chile rellenos");
		System.out.println(r.getRecipes());
		// IngredientSearch s = new IngredientSearch(data);
		// s.search("butterscotch chips,chinese noodles,salted peanuts");

		Window window = new Window("Thought for Food", data);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

}
