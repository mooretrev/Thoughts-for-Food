package gui;

import javax.swing.JFrame;

import containers.Data;
import search.NameSearch;

public class Window extends JFrame {
	
	private Data data;
	private NameSearch nameSearch;
	
	public Window(String title, Data data) {
		super(title);
		nameSearch = new NameSearch(data);
		
	}
}