package tff;

import javax.swing.JFrame;

import containers.Data;
import gui.Window;
import gui.loading.SplashScreen;
import index.threads.LoadDataThread;

public class ApplicationMain {
	public static void main(String[] args) {
		Data data;
		LoadDataThread loadDataThread = new LoadDataThread();
		loadDataThread.start();

		SplashScreen splashScreen = new SplashScreen();

		try {
			loadDataThread.join();
			data = loadDataThread.getData();
			splashScreen.dispose();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Window window = new Window("Thought for Food", data);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

}
