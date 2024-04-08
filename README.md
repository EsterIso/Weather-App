<h1> Weather App</h1>

 ### 
<h2>Description</h2>
This project is a Weather Application in Java, which consists of backend and frontend components. This weather app offers users an easy and visually appealing way to check the weather conditions for a specified location. 


1. **Backend Logic(WeatherApp.java)**:
  - Retrieving weather data from an external API (https://api.open-meteo.com) which uses the provided location.
  - It uses Coordinates which are fetched using the geolocation API (https://geocoding-api.open-meteo.com) using the provided location.
  - It creates API requests using latitude and longitude coordinates to retrieve weather data.
  - It processes API answers, parses JSON data, and extracts weather data such as temperature, humidity, wind speed, and precipitation.
  - It transforms weather codes into human-readable descriptions.



2. **Frontend Interface (WeatherAppGui.java)**: 
  - Creates a GUI using Swing components
  - It includes components such as search bar, weather condition image, temperature display, weather condition description, humidity display,      windspeed display, precipitation display, and buttons.
  - It allows users to input a location via the search bar to retrieve and display weather data.
  - It dynamically refreshes the GUI based on the retrieved weather data.
  - It includes a dark mode feature that can be activated with a button and alters the appearance of interface components and icons.
  - It uses images to represent weather conditions, humidity, windspeed, and precipitation.


<br />


<h2>Languages and Utilities Used</h2>

- <b>Java</b> 
- <b>JFrame</b>
- <b>JPanel</b>
- <b>Hashmap</b>
- <b>Json</b>
- <b>HTTP Connection Utilities</b>
- <b>Date and Time Utilities</b>
- <b>Image I/O Utilities</b>


<h2>Environments Used </h2>

- <b>Windows 11</b>

<h2>Program walk-through:</h2>

<p align="center">
Launch the app: <br/>
<img src="https://i.imgur.com/OZGbqGC.png" height="50%" width="50%" alt=""/>
<br />
<br />
Searching for New York's Weather:  <br/>
<img src="https://i.imgur.com/KT1vy40.png" height="50%" width="50%" alt=""/>
<br />
<br />
Searching for Iceland's Weather:  <br/>
<img src="https://i.imgur.com/iarbZ2w.png" height="50%" width="50%" alt=""/>
<br />
<br />
Dark Mode toggled:  <br/>
<img src="https://i.imgur.com/QO3MYm0.png" height="50%" width="50%" alt=""/>
<br />
<br />

 
<!--
 ```diff
- text in red
+ text in green
! text in orange
# text in gray
@@ text in purple (and bold)@@
```
--!>
