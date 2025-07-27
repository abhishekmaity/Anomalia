import React, { useEffect, useState } from "react";
// import { fetchRecentFinancialAnomalies } from "../src/api/financialApi";

// export default function FinancialAnomalyList() {
//   const [financials, setFinancials] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     fetchRecentFinancialAnomalies()
//       .then((data) => setFinancials(data.content || []))
//       .catch((err) => console.error("Failed to load financial anomalies:", err))
//       .finally(() => setLoading(false));
//   }, []);

//   if (loading) return <p>Loading financial anomaly data...</p>;

//   return (
//     <div>
//       <h2>Recent Financial Anomalies</h2>
//       <ul>
//         {financials.map((anomaly, index) => (
//           <li key={index}>
//             {anomaly.symbol} - {anomaly.eventType} ({anomaly.timestamp})
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// }
export default function FinancialAnomalyList() { 
  return <div style={{ padding: "1rem" }}>Anomalies will be listed here.</div>;
};