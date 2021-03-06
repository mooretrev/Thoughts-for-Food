package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

import javax.swing.*;
import java.awt.*;

import containers.Data;
import search.NameSearch;

public class Window extends JFrame {
	
	private Data data;
	private NameSearch nameSearch;

	private final int WINDOW_WIDTH = 620; // Window width
	private final int WINDOW_HEIGHT = 600; // Window height
	
	private JPanel homePanel; // To reference a panel
    private JLabel mainLabel; // To reference a label
    private JLabel mainLabel2; // To reference a label
	private JLabel instrLabel1; // To reference a label
	private JLabel instrLabel2; // To reference a label
    private JButton continueButton; // To reference a button
    private TabbedPanel tab;
	
	public Window(String title, Data data) {
		// Set the window title.
		setTitle("Welcome to Our Search");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel and add it to the frame.
		buildHome();

		// Add the panel to the frame's content pane.
		add(homePanel);

		// Display the window.
		setVisible(true);

		// Prevent the window from being resized
//		setResizable(false);
		
		//super(title);
		//nameSearch = new NameSearch(data);
		this.data = data;
		
	}

	private void buildHome() {

        // create GUI objects
        mainLabel = new JLabel("    Welcome To ");
        mainLabel2 = new JLabel("   Thought For Food!");
		instrLabel1 = new JLabel("    You can search different recipies based on the ingredients you have, ");
		instrLabel2 = new JLabel("    the name of the recipe, or time to prepare.");
        continueButton = new JButton("Continue");
        
        // style GUI objects
        Font courier = new Font("arial", Font.BOLD, 50);
        mainLabel.setPreferredSize(new Dimension(250, 250));
        mainLabel.setFont(courier);

        mainLabel2.setPreferredSize(new Dimension(250, 250));
        mainLabel2.setFont(courier);
        
        Font courierReg = new Font("arial", Font.PLAIN, 18);
		instrLabel1.setFont(courierReg);
		instrLabel2.setFont(courierReg);

        Font courierBtn = new Font("arial", Font.BOLD, 12);
        continueButton.setFont(courierBtn);

        // Add an action listener to the button.
        continueButton.addActionListener(new continueBtnListener());

        // Create a JPanel object and let the panel field reference it.
        homePanel = new JPanel();
        JLabel image=new JLabel(new ImageIcon("assets/food.jpg"));
        image.setSize(610,200);
		homePanel.add(image);
        homePanel.setBackground(new Color(255,255,255));
        
        // set layout of home panel
        GroupLayout layout = new GroupLayout(homePanel);
        homePanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(false);

        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addComponent(mainLabel)
                .addComponent(mainLabel2)
				.addComponent(instrLabel1)
				.addComponent(instrLabel2)
                .addComponent(continueButton)
            );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGap(215)
            .addComponent(mainLabel)
            .addComponent(mainLabel2)
			.addGap(50)
			.addComponent(instrLabel1)
            .addComponent(instrLabel2)
            .addGap(20)
            .addGroup(layout.createParallelGroup(Alignment.CENTER)
                .addComponent(continueButton)
            )
        );

        // Add the label, text field, and button components to the panel.
        homePanel.add(mainLabel);
        homePanel.add(mainLabel2);
		homePanel.add(instrLabel1);
		homePanel.add(instrLabel2);
        homePanel.add(continueButton);

	}
	
	private class continueBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent s) {
            // Build the panel and add it to the frame.
            tab = new TabbedPanel(data);
            
            getContentPane().add(tab.tabs);
            tab.tabs.setSelectedIndex(0);  // open to tab 1
            
            // set visability
            homePanel.setVisible(false);
            tab.setVisible(true);
        }
    }
}