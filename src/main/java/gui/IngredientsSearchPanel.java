package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import containers.Data;
import gui.results.RecipeResults;
import results.Results;
import search.IngredientSearch;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;

public class IngredientsSearchPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel titleLabel;
    private JLabel instrLabel1;
    private JLabel instrLabel2;
    private JTextField ingredSearchBar;
    private JButton searchButton;

    private Data data;
    private IngredientSearch ingredSearch;
    private RecipeResults recipeResults = null;

    IngredientsSearchPanel(Data data) {
    	this.data = data;
        titleLabel = new JLabel("Ingredients Search");
        instrLabel1 = new JLabel("Search for recipies by ingredients below:");
        instrLabel2 = new JLabel("(Seperate multiple entries with comma)");

        ingredSearchBar = new JTextField(10);
        searchButton = new JButton("Search");

        searchButton.addActionListener(new searchBtnListener(ingredSearchBar));
        
        // Style gui objects
        Font courierTitle = new Font("Courier", Font.BOLD, 27);
        titleLabel.setPreferredSize(new Dimension(530, 530));
        titleLabel.setFont(courierTitle);

        Font courierInstr = new Font("Courier", Font.PLAIN, 19);
        instrLabel1.setFont(courierInstr);
        instrLabel2.setFont(courierInstr);

        Font courierBold = new Font("Courier", Font.BOLD, 20);
        searchButton.setFont(courierBold);

        // Set the Layout for the Panel
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 80;
        add(titleLabel, gbc);
      
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 0;
        add(instrLabel1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(instrLabel2, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        add(ingredSearchBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(searchButton, gbc);


    }

    private class searchBtnListener implements ActionListener {

        private JTextField ingredQuery;

        searchBtnListener(JTextField ingredQuery) {
            this.ingredQuery = ingredQuery;
        }
        
        public void actionPerformed(ActionEvent s) {
        	System.out.println("button press");
            String ingredString;
            ingredString = ingredQuery.getText();
            
            if(recipeResults != null) {
            	remove(recipeResults);
            	System.out.println("removed");
            }
          
            IngredientSearch search = new IngredientSearch(data);
            Results results = search.search(ingredString);
            recipeResults = new RecipeResults(results.getRecipes(), data);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.weighty = 6;
            gbc.weightx = 7;
            add(recipeResults, gbc);
            updateUI();           
        }
    }
}