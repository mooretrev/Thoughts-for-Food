package gui.results;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import containers.Data;
import containers.Recipe;
import containers.Review;

public class RecipeResults extends JPanel {

	private List<Recipe> recipes;
	private GridBagConstraints c;
	private Data data;

	public RecipeResults(List<Recipe> recipes, Data data) {
		this.recipes = recipes;
		this.data = data;
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		//		addComponents();
		addTableComponets();
		this.updateUI();
	}

	void addComponents(){
		int size = 10;
		if(!(recipes.size() > 10)) {
			size = recipes.size();
		}

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;		
		c.gridx = 0;
		c.gridy = 0;

		RecipesResultsHeader header = new RecipesResultsHeader();
		this.add(header, c);

		for(int i = 0; i < size; ++i) {
			c.gridy = i+1;
			RecipeResultRow row = new RecipeResultRow(recipes.get(i));
			this.add(row, c);
		}

	}

	void addTableComponets() {
		Vector colName = new Vector(Arrays.asList("Name", "Cooktime", "# of Ingredients", "# of Instruction"));
		Vector rowData = new Vector();

		int size = 10;
		if(!(recipes.size() > 10)) {
			size = recipes.size();
		}

		for(int i = 0; i < size; ++i) {
			Recipe recipe = recipes.get(i);
			Vector temp = new Vector(4);
			temp.add(recipe.getName());
			temp.add(recipe.getCookTime());
			temp.add(recipe.getNumIngredients());
			temp.add(recipe.getNumInstructions());
			rowData.add(temp);
		}

		JTable table = new JTable(rowData, colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table.setFillsViewportHeight(true);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				if(event.getValueIsAdjusting()) {
					Recipe recipe = recipes.get(table.getSelectedRow());
					List<Review> reviews;
					try {
						reviews = data.reviewsById.get(recipe.getId());
					} catch (Exception e) {
						reviews = null;
					}


					new RecipesInfo(recipe, reviews);
				}
			}
		});

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;		
		c.gridx = 0;
		c.gridy = 0;

		JScrollPane pane = new JScrollPane(table);

		this.add(pane, c);


	}

}
