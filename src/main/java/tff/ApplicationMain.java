package tff;

import javax.swing.JFrame;

import containers.Data;
import gui.Window;
import results.Results;
import search.NameSearch;

public class ApplicationMain {
	public static void main(String[] args) {

		Data data = new Data();
		data.load();		
		NameSearch n = new NameSearch(data);
		Results r = n.search("microwave chili");
		System.out.println(r.getRecipes());

		Window window = new Window("Thought for Food", data);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

}
