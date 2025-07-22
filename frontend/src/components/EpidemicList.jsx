import React, { useEffect, useState } from "react";
import { fetchRecentEpidemics } from "../api/epidemicApi";

export default function EpidemicList() {
  const [epidemics, setEpidemics] = useState([]);

  useEffect(() => {
    fetchRecentEpidemics()
      .then((data) => setEpidemics(data.content || []))
      .catch((err) => console.error("Failed to load epidemic data:", err));
  }, []);

  return (
    <div>
      <h2>Recent Epidemic Events</h2>
      <ul>
        {epidemics.map((event, index) => (
          <li key={index}>
            {event.country}: {event.indicator} - {event.value} ({event.date})
          </li>
        ))}
      </ul>
    </div>
  );
}
