package gui.results;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import containers.Recipe;

public class RecipesResultsHeader extends JPanel{
	private GridBagConstraints c;
	
	public RecipesResultsHeader() {
		this.setLayout(new GridBagLayout());
		Border blackline = BorderFactory.createLineBorder(Color.black);

		this.setBorder(blackline);
		c = new GridBagConstraints();
		
		addComponents();
	}
	
	private void addComponents() {
		JLabel name = new JLabel("Name");
		JLabel cookTime = new JLabel("Cooktime");
		JLabel numIngredients = new JLabel("# of Ingredients");
		JLabel numInstruction = new JLabel("# of Instructions");
		
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		
		this.add(name, c);
		
		c.gridx = 1;
		this.add(cookTime, c);

		c.gridx = 2;
		this.add(numIngredients, c);
		
		c.gridx = 3;
		this.add(numInstruction, c);
	}

}
