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
import search.NameSearch;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;

public class NameSearchPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel titleLabel;
    private JLabel instrLabel;
    private JTextField nameSearchBar;
    private JButton searchButton;

    private Data data;
    private NameSearch nameSearch;
    private RecipeResults recipeResults = null;

    NameSearchPanel(Data data) {
    	this.data = data;
        titleLabel = new JLabel("Name Search");
        instrLabel = new JLabel("Search for recipies by name below:");
        nameSearchBar = new JTextField(10);
        searchButton = new JButton("Search");

        searchButton.addActionListener(new searchBtnListener(nameSearchBar));
        
        // Style gui objects
        Font courierTitle = new Font("arial", Font.BOLD, 27);
        titleLabel.setPreferredSize(new Dimension(530, 530));
        titleLabel.setFont(courierTitle);

        Font courierInstr = new Font("arial", Font.PLAIN, 19);
        instrLabel.setFont(courierInstr);

        Font courierBold = new Font("arial", Font.BOLD, 20);
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
        add(instrLabel, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        add(nameSearchBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(searchButton, gbc);


    }

    private class searchBtnListener implements ActionListener {

        private JTextField nameQuery;

        searchBtnListener(JTextField nameQuery) {
            this.nameQuery = nameQuery;
        }
        
        public void actionPerformed(ActionEvent s) {
        	System.out.println("button press");
            String nameString;
            nameString = nameQuery.getText();
            
            if(recipeResults != null) {
            	remove(recipeResults);
            	System.out.println("removed");
            }
          
            NameSearch search = new NameSearch(data);
            Results results = search.search(nameString);
            recipeResults = new RecipeResults(results.getRecipes(), data);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.weighty = 6;
            gbc.weightx = 7;
            add(recipeResults, gbc);
            updateUI();           
        }
    }
}