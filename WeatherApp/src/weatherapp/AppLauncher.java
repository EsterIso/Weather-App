package weatherapp;

import javax.swing.*;

public class AppLauncher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				//display weather app GUI
				new WeatherAppGui().setVisible(true);
				
				//System.out.println(WeatherApp.getLocationData("New York"));
				
				//System.out.println(WeatherApp.getCurrentTime());
			}
		});

	}

}
