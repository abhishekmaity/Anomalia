import React, { useEffect, useState } from "react";
import { fetchRecentSocialTrends } from "../api/socialTrendApi";

export default function SocialTrendList() {
  const [trends, setTrends] = useState([]);

  useEffect(() => {
    fetchRecentSocialTrends()
      .then((data) => setTrends(data.content || []))
      .catch((err) => console.error("Failed to load social trends:", err));
  }, []);

  return (
    <div>
      <h2>Recent Social Trends</h2>
      <ul>
        {trends.map((trend, index) => (
          <li key={index}>
            {trend.platform}: #{trend.keyword} ({trend.timestamp})
          </li>
        ))}
      </ul>
    </div>
  );
}
