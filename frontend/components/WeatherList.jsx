import React, { useEffect, useState } from "react";
// import { fetchRecentWeather } from "../src/api/weatherApi";

// export default function WeatherList() {
//   const [weatherData, setWeatherData] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     fetchRecentWeather()
//       .then((data) => setWeatherData(data.content || []))
//       .catch((err) => console.error("Failed to load weather data:", err))
//       .finally(() => setLoading(false));
//   }, []);

//   if (loading) return <p>Loading weather data...</p>;

//   return (
//     <div>
//       <h2>Recent Weather Anomalies</h2>
//       <ul>
//         {weatherData.map((weather, index) => (
//           <li key={index}>
//             {weather.city}, {weather.country}: {weather.temperature}°C, {weather.condition} ({weather.timestamp})
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// }
export default function WeatherList() { 
  return <div style={{ padding: "1rem" }}>Anomalies will be listed here.</div>;
};
