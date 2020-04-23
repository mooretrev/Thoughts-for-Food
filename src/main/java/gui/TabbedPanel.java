package gui;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;

// Needed for Swing classes
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


class TabbedPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    JTabbedPane tabs;
    NameSearchPanel namePanel;
    IngredientsSearchPanel ingredientsPanel;
    TimeSearchPanel timePanel;
    

    TabbedPanel() {
        // Setting the JTabbedPane Position and Layout as Wrap
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        tabs.setBackground(new Color(255,255,255));

        namePanel = new NameSearchPanel();
        ingredientsPanel = new IngredientsSearchPanel();
        timePanel = new TimeSearchPanel();

        Font courierExclude = new Font("arial", Font.PLAIN, 15);
        tabs.setFont(courierExclude);

        // Adding user defined pannels to JTabbedPane
        tabs.addTab("Name Search", namePanel);
        tabs.addTab("Ingredients Search", ingredientsPanel);
        tabs.addTab("Time Search", timePanel);
    }
}