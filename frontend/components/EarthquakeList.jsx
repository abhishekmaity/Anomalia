import React, { useEffect, useState } from 'react';
import { fetchRecentEarthquakes } from '../src/api/earthquakeApi';

const EarthquakeList = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchRecentEarthquakes()
      .then(response => setData(response.content))
      .catch(err => console.error('Error fetching earthquakes:', err))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <p>Loading earthquake data...</p>;

  return (
    <div>
      <h2>Recent Earthquakes</h2>
      <ul>
        {data.map((quake, idx) => (
          <li key={idx}>
            <strong>{quake.location}</strong> - Magnitude: {quake.magnitude} - Time: {quake.timestamp}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EarthquakeList;
