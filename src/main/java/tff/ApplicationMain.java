package tff;

import javax.swing.JFrame;

import containers.Data;
import gui.Window;
import search.IngredientSearch;
import search.TimeSearch;

public class ApplicationMain {
	public static void main(String[] args) {

		Data data = new Data();
		data.load();		
		
		Window window = new Window("Thought for Food", data);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

}
