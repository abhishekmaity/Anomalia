## 🌦️ Weather Ingestion Microservice

This microservice fetches real-time weather data from the [OpenWeatherMap API](https://openweathermap.org/api) and stores it in the PostgreSQL database used by the **Anomalia** backend.


### 📌 Features

- ✅ Fetches current weather for a target city
- ✅ Stores temperature, humidity, pressure, and timestamp
- ✅ Creates table `weather_anomalies` if not present
- ✅ Designed for plug-and-play use in a microservice pipeline
- 🧪 Easy to extend to hourly/daily forecasts or alerts


