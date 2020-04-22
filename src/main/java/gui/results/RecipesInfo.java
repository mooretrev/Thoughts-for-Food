package gui.results;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.JavaBean;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import static javax.swing.ScrollPaneConstants.*;


import containers.Recipe;
import containers.Review;

public class RecipesInfo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1564937123487819078L;
	
	private Recipe recipe;
	private List<Review> reviews;
	private JPanel panel;
	private int numColumns = 1;
	private int WIDTH = 640;
	private int HEIGHT = 700;
	
	public RecipesInfo(Recipe recipe, List<Review> reviews) {
		super();
		this.recipe = recipe;
		this.reviews = reviews;
		
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.white);
		addComponents();

		panel.setSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new BorderLayout());
				
		this.add(panel);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void addComponents() {
		title();
		desciption();
		ingredients();
		steps();
		if(reviews != null) {
			review();
		}
	}
	
	private void title() {
		JTextArea title = new JTextArea(recipe.getName());
		title.setEditable(false);
		title.setSize(new Dimension(WIDTH, 100));
		title.setFont(new Font("AvantGarde", Font.PLAIN, 40));
		title.setLineWrap(true);
		title.setWrapStyleWord(true);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = numColumns;
		c.gridx = 0;
		c.gridy = 0;
//		c.weightx = 1;
//		c.weighty = 1;
		c.ipadx = 10;
		panel.add(title, c);
	}
	
	private void desciption() {
		JTextArea desc = new JTextArea(recipe.getDescription());
		desc.setFont(new Font("AvantGarde", Font.PLAIN, 20));
		desc.setLineWrap(true);
		desc.setLineWrap(true);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = numColumns;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 2;

		c.ipadx = 10;
		
		JScrollPane pane = new JScrollPane(desc);
		panel.add(pane, c);
		
	}
	
	private void ingredients(){
		JLabel numIngred = new JLabel("Ingredients: " + recipe.getNumIngredients());
		numIngred.setFont(new Font("AvantGarde", Font.PLAIN, 20));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = numColumns;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 1;

		c.ipadx = 10;
		panel.add(numIngred, c);
		
		List<String> ingredients = recipe.getIngredients();
		String text = "";
		
		for(int i = 0; i < ingredients.size(); ++i) {
			text += (i+1) + ".  " + ingredients.get(i) + "\n";
		}
		
		JTextArea ingre = new JTextArea(text);
		ingre.setSize(new Dimension(WIDTH, 100));
		ingre.setFont(new Font("AvantGarde", Font.PLAIN, 16));
		ingre.setLineWrap(true);
		ingre.setWrapStyleWord(true);
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = numColumns;
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 3;

		c.ipadx = 10;
		JScrollPane pane = new JScrollPane(ingre);
		panel.add(pane, c);
		
	}
	
	private void steps() {
		
		JLabel numIngred = new JLabel("Steps: " + recipe.getNumInstructions() );
		numIngred.setFont(new Font("AvantGarde", Font.PLAIN, 20));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = numColumns;
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 1;

		c.ipadx = 10;
		panel.add(numIngred, c);
		
		List<String> ingredients = recipe.getInstructions();
		String text = "";
		
		for(int i = 0; i < ingredients.size(); ++i) {
			text +=  (i + 1) +  ". " + ingredients.get(i) + "\n";
		}
		
		JTextArea ingre = new JTextArea(text);
		ingre.setSize(new Dimension(WIDTH, 100));
		ingre.setFont(new Font("AvantGarde", Font.PLAIN, 16));
		ingre.setLineWrap(true);
		ingre.setWrapStyleWord(true);
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = numColumns;
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 1;
		c.weighty = 4;

		c.ipadx = 10;
		JScrollPane pane = new JScrollPane(ingre);
		panel.add(pane, c);
				
	}
	
	void review() {
		System.out.println(reviews.size());
		Vector colNames = new Vector(Arrays.asList("user id", "rating", "review"));
		Vector rowData = new Vector();
		for(Review review : reviews) {
			Vector temp = new Vector();
			
			temp.add(review.getUserId());
			temp.add(review.getRating());
			temp.add(review.getReview());
			
			rowData.add(temp);
			
		}
		
		JTable table = new JTable(rowData, colNames);
		table.setFillsViewportHeight(true);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = numColumns;
		c.gridx = 0;
		c.gridy = 6;
		c.weightx = 1;
		c.weighty = 2;

		c.ipadx = 10;
		
		JScrollPane pane = new JScrollPane(table);
		panel.add(pane, c);
		

	}
	
	

}
