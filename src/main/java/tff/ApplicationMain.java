package tff;

import javax.swing.JFrame;

import containers.Data;
import gui.Window;
import search.IngredientSearch;
import search.NameSearch;
import search.TimeSearch;

public class ApplicationMain {
	public static void main(String[] args) {

		Data data = new Data();
		data.load();		
		NameSearch n = new NameSearch(data);
		n.search("chile rellenos");
		// IngredientSearch s = new IngredientSearch(data);
		// s.search("butterscotch chips,chinese noodles,salted peanuts");

		Window window = new Window("Thought for Food", data);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

}
