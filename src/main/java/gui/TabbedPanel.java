package gui;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;

// Needed for Swing classes
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import containers.Data;


class TabbedPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    JTabbedPane tabs;
    NameSearchPanel namePanel;
    IngredientsSearchPanel ingredientsPanel;
    TimeSearchPanel timePanel;
    Data data;
    

    TabbedPanel(Data data) {
        // Setting the JTabbedPane Position and Layout as Wrap
    	this.data = data;
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        tabs.setBackground(new Color(255,255,255));

        namePanel = new NameSearchPanel(data);
        timePanel = new TimeSearchPanel(data);
        ingredientsPanel = new IngredientsSearchPanel(data);

        Font courierExclude = new Font("arial", Font.PLAIN, 15);
        tabs.setFont(courierExclude);

        // Adding user defined pannels to JTabbedPane
        tabs.addTab("Name Search", namePanel);
        tabs.addTab("Ingredients Search", ingredientsPanel);
        tabs.addTab("Time Search", timePanel);
    }
}