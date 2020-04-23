package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import containers.Data;
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

    NameSearchPanel() {

        titleLabel = new JLabel("Name Search");
        instrLabel = new JLabel("Search for recipies by name below:");
        nameSearchBar = new JTextField(10);
        searchButton = new JButton("Search");

        searchButton.addActionListener(new searchBtnListener(nameSearchBar));
        
        // Style gui objects
        Font courierTitle = new Font("Courier", Font.BOLD, 27);
        titleLabel.setPreferredSize(new Dimension(530, 530));
        titleLabel.setFont(courierTitle);

        Font courierInstr = new Font("Courier", Font.PLAIN, 19);
        instrLabel.setFont(courierInstr);

        Font courierBold = new Font("Courier", Font.BOLD, 20);
        searchButton.setFont(courierBold);

        // Set the Layout for the Panel
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //gbc.gridwidth = GridBagConstraints.REMAINDER;
        //gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 80;
        add(titleLabel, gbc);

        //gbc.anchor = GridBagConstraints.SOUTH;
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
            String nameString;
            nameString = nameQuery.getText();

            
            NameSearch search = new NameSearch(data);
            Results results = search.search(nameString);
            RecipeResult recipeResults = new RecipeResult(results.getRecipes(), data);
            JFrame newFrame = new JFrame();
            newFrame.setVisible(true);
        }
    }
}