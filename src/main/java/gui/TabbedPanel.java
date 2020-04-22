package gui;

import java.awt.Font;

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

        namePanel = new NameSearchPanel();
        ingredientsPanel = new IngredientsSearchPanel();
        timePanel = new TimeSearchPanel();

        Font courierExclude = new Font("Courier", Font.PLAIN, 15);
        tabs.setFont(courierExclude);

        // Adding user defined pannels to JTabbedPane
        tabs.addTab("Name Search", namePanel);
        tabs.addTab("Ingredients Search", ingredientsPanel);
        tabs.addTab("Time Search", timePanel);
    }
}