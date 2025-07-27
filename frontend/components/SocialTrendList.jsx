import React, { useEffect, useState } from "react";
// import { fetchRecentSocialTrends } from "../src/api/socialTrendApi";

// export default function SocialTrendList() {
//   const [trends, setTrends] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     fetchRecentSocialTrends()
//       .then((data) => setTrends(data.content || []))
//       .catch((err) => console.error("Failed to load social trends:", err))
//       .finally(() => setLoading(false));
//   }, []);

//     if (loading) return <p>Loading social trend data...</p>;

//   return (
//     <div>
//       <h2>Recent Social Trends</h2>
//       <ul>
//         {trends.map((trend, index) => (
//           <li key={index}>
//             {trend.platform}: #{trend.keyword} ({trend.timestamp})
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// }
export default function SocialTrendList() { 
  return <div style={{ padding: "1rem" }}>Anomalies will be listed here.</div>;
};
