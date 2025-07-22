import React, { useEffect, useState } from "react";
import { fetchRecentWeather } from "../api/weatherApi";

export default function WeatherList() {
  const [weatherData, setWeatherData] = useState([]);

  useEffect(() => {
    fetchRecentWeather()
      .then((data) => setWeatherData(data.content || []))
      .catch((err) => console.error("Failed to load weather data:", err));
  }, []);

  return (
    <div>
      <h2>Recent Weather Anomalies</h2>
      <ul>
        {weatherData.map((weather, index) => (
          <li key={index}>
            {weather.city}, {weather.country}: {weather.temperature}°C, {weather.condition} ({weather.timestamp})
          </li>
        ))}
      </ul>
    </div>
  );
}
