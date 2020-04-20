package gui.loading;

import javax.swing.*;
import java.awt.*;

public class SplashScreen {
	JFrame frame;
	JLabel image=new JLabel(new ImageIcon("assets/food.jpg"));
	JLabel text=new JLabel("Thought for Food");
	JProgressBar progressBar=new JProgressBar();
	JLabel message=new JLabel("Loading...");

	public SplashScreen()
	{
		createGUI();
		addImage();
		addText();
		addProgressBar();
		addMessage();
		runningPBar();
	}

	public void createGUI(){
		frame=new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setVisible(true);

	}

	public void addImage(){
		image.setSize(600,200);
		frame.add(image);
	}

	public void addText()
	{
		text.setFont(new Font("arial",Font.BOLD,30));
		text.setBounds(170,220,600,40);
		text.setForeground(Color.BLUE);
		frame.add(text);
	}

	public void addMessage()
	{
		message.setBounds(250,320,200,40);//Setting the size and location of the label
		message.setForeground(Color.black);//Setting foreground Color
		message.setFont(new Font("arial",Font.BOLD,15));//Setting font properties
		frame.add(message);//adding label to the frame
	}

	public void addProgressBar(){
		progressBar.setBounds(100,280,400,30);
		progressBar.setBorderPainted(true);
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.BLACK);
		progressBar.setValue(0);
		frame.add(progressBar);
	}

	public void runningPBar(){
		progressBar.setIndeterminate(true);
	}

	public void dispose() {
		frame.dispose();
	}
}