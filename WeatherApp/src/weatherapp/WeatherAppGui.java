package weatherapp;

import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherAppGui extends JFrame {
    private JSONObject weatherData;
 // Add a field to keep track of dark mode state
    boolean darkMode = false;
    
    public WeatherAppGui(){
        // setup our gui and add a title
        super("Weather App");

        // configure gui to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of our gui (in pixels)
        setSize(450, 650);

        // load our gui at the center of the screen
        setLocationRelativeTo(null);

        // make our layout manager null to manually position our components within the gui
        setLayout(null);

        // prevent any resize of our gui
        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents(){
        // search field
        JTextField searchBar = new JTextField();

        // set the location and size of our component
        searchBar.setBounds(15, 15, 351, 45);

        // change the font style and size
        searchBar.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchBar);

        // weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        // temperature text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));

        // center the text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        // weather condition description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        // humidity image
        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(60, 470, 74, 66);
        add(humidityImage);

        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(65, 530, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        // windspeed image
        JLabel windspeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windspeedImage.setBounds(300, 470, 74, 66);
        add(windspeedImage);

        // windspeed text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(300, 530, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);
        
        // precipitation image
        JLabel precipitationImage = new JLabel(loadImage("src/assets/precipitation.png"));
        precipitationImage.setBounds(180, 470, 74, 66);
        add(precipitationImage);
        
        // precipitation text
        JLabel precipitationText = new JLabel("<html><b>Precipitation</b> 2mm</html>");
        precipitationText.setBounds(175, 530, 100, 55);
        precipitationText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(precipitationText);

        // search button
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));
        
        //dark mode
        JButton darkModeButton = new JButton(loadImage("src/assets/dark.png"));
        
     // Define a map to store image paths for precipitation, humidity, and windspeed in light mode
        Map<String, String> lightModeIconPaths = new HashMap<>();
        {
            lightModeIconPaths.put("precipitation", "src/assets/precipitation.png");
            lightModeIconPaths.put("humidity", "src/assets/humidity.png");
            lightModeIconPaths.put("windspeed", "src/assets/windspeed.png");
        }

        // Define a map to store image paths for precipitation, humidity, and windspeed in dark mode
        Map<String, String> darkModeIconPaths = new HashMap<>();
        {
            darkModeIconPaths.put("precipitation", "src/assets/precipitationLight.png");
            darkModeIconPaths.put("humidity", "src/assets/humidityLight.png");
            darkModeIconPaths.put("windspeed", "src/assets/windspeedLight.png");
        }

        
        //change the cursor to a hand cursor when hovering over this button
        darkModeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        darkModeButton.setBounds(375, 58, 47, 45);
        darkModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Container contentPane = getContentPane();
				// Toggle dark mode state
		        darkMode = !darkMode;
		        // Update background color based on dark mode state
		        
		        Map<String, String> iconPaths = darkMode ? darkModeIconPaths : lightModeIconPaths;

		        // Update precipitation icon
		        String precipitationImagePath = iconPaths.get("precipitation");
		        precipitationImage.setIcon(loadImage(precipitationImagePath));

		        // Update humidity icon
		        String humidityImagePath = iconPaths.get("humidity");
		        humidityImage.setIcon(loadImage(humidityImagePath));

		        // Update windspeed icon
		        String windspeedImagePath = iconPaths.get("windspeed");
		        windspeedImage.setIcon(loadImage(windspeedImagePath));
		        if (darkMode) {
		        	
		            contentPane.setBackground(new Color(25, 39, 52));
		            temperatureText.setForeground(Color.WHITE);
		            weatherConditionDesc.setForeground(Color.WHITE);
		            humidityText.setForeground(Color.WHITE);
		            windspeedText.setForeground(Color.WHITE);
		            precipitationText.setForeground(Color.WHITE);
		            searchBar.setBackground(new Color(136,153,172));
		            searchBar.setForeground(Color.WHITE);
		            
		        } else {
		            contentPane.setBackground(null); // Use the default background color
		            temperatureText.setForeground(null);
		            weatherConditionDesc.setForeground(null);
		            humidityText.setForeground(null);
		            windspeedText.setForeground(null);
		            precipitationText.setForeground(null);
		            searchBar.setBackground(null);
		            searchBar.setForeground(null);
		        }
			}
        });
        add(darkModeButton);
        
        //change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get location from user
                String userInput = searchBar.getText();

                // validate input - remove whitespace to ensure non-empty text
                if(userInput.replaceAll("\\s", "").length() <= 0){
                    return;
                }

                // retrieve weather data
                weatherData = WeatherApp.getWeatherData(userInput);

                // update gui

                // update weather image
                String weatherCondition = (String) weatherData.get("weather_condition");

                // depending on the condition, we will update the weather image that corresponds with the condition
                switch(weatherCondition){
                    case "Clear":
                        weatherConditionImage.setIcon(loadImage("src/assets/clear.png"));
                        break;
                    case "Cloudy":
                        weatherConditionImage.setIcon(loadImage("src/assets/cloudy.png"));
                        break;
                    case "Rain":
                        weatherConditionImage.setIcon(loadImage("src/assets/rain.png"));
                        break;
                    case "Snow":
                        weatherConditionImage.setIcon(loadImage("src/assets/snow.png"));
                        break;
                }

                // update temperature text
                double temperature = (double) weatherData.get("temperature");
                temperatureText.setText(temperature + " C");

                // update weather condition text
                weatherConditionDesc.setText(weatherCondition);

                // update humidity text
                long humidity = (long) weatherData.get("humidity");
                humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

                // update windspeed text
                double windspeed = (double) weatherData.get("windspeed");
                windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
                
                // update precipitation text
                double precipitation = (double) weatherData.get("precipitation");
                precipitationText.setText("<html><b>Precipitation</b> " + precipitation + "mm</html>");
            }
        });
        add(searchButton);
    }
    
    

    // used to create images in our gui components
    private ImageIcon loadImage(String resourcePath) {
        try {
            // read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));
            
            // returns an image icon so that our component can render it
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image from path: " + resourcePath);
            return null;
        }
    }
}







