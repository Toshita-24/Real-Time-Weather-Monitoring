# Real-Time-Weather-Monitoring
This project is a real-time data processing system that monitors weather conditions in major cities in India, utilizing data from the OpenWeatherMap API. The system provides daily summaries and insights, with temperature rollups and weather condition aggregates.

Backend: Spring Boot (Java) Database: MySQL Frontend: Angular API: OpenWeatherMap

Project Overview The system continuously collects weather data for specified metro cities (Delhi, Mumbai, Chennai, Bangalore, Kolkata, Hyderabad) and provides: Real-Time Monitoring: Calls the OpenWeatherMap API at a configurable interval. Daily Summaries: Rollups of daily weather data, with calculations of average, max, and min temperatures and the dominant weather condition. Data Visualization: Angular frontend to display summaries and historical data. Backend: Developed using Spring Boot and uses MySQL for data storage.

Features Weather Data Collection: Real-time fetching and processing of weather data at a configurable interval. Data Conversion: Temperature conversion from Kelvin to Celsius (or Fahrenheit based on user preference). Daily Rollups and Aggregates: Average Temperature: Calculated daily. Maximum and Minimum Temperature: Stored for daily summaries. Dominant Weather Condition: Most frequently occurring weather condition for the day. Frontend Visualization: Interactive data visualizations for current and historical weather trends.

System Structure and Workflow Backend (Spring Boot) The backend consists of:

WeatherService:

Fetches weather data from the OpenWeatherMap API every 5 minutes (configurable). Processes data to extract temperature and weather conditions. Stores data in the WeatherData table and aggregates in DailyWeatherSummary. DailyWeatherSummary Repository:

Stores daily rollups with calculated averages, min/max temperatures, and the dominant condition. WeatherController:

Provides endpoints: /weather/fetch: Trigger data fetch manually. /weather/summary/{city}: Fetch daily weather summary for a specified city. Database (MySQL) Tables:

WeatherData: Stores raw weather data with fields for city, temperature, conditions, etc. DailyWeatherSummary: Stores daily aggregates and rollups (average, max, min temperatures, dominant condition). Frontend (Angular) The frontend retrieves and displays data from the backend:

Real-Time Weather Data: Fetches and displays the current weather data from the OpenWeatherMap API. Daily Summaries: Shows daily aggregated weather summaries. Historical Trends: Line or bar charts to show trends of average, min, and max temperatures.
