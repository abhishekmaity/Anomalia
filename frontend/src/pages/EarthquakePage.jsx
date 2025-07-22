import React, { useEffect, useState } from 'react';
import apiClient from '../api/apiClient';

function EarthquakePage() {
  const [data, setData] = useState([]);

  useEffect(() => {
    apiClient.get('/earthquakes/recent?page=0&size=10')
      .then((res) => setData(res.data.content))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div>
      <h2>Recent Earthquakes</h2>
      <ul>
        {data.map((event) => (
          <li key={event.id}>
            {event.location} - Magnitude: {event.magnitude}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default EarthquakePage;
