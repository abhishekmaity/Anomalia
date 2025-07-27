import React, { useEffect, useState } from "react";
// import { fetchRecentEpidemics } from "../src/api/epidemicApi";

// export default function EpidemicList() {
//   const [epidemics, setEpidemics] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     fetchRecentEpidemics()
//       .then((data) => setEpidemics(data.content || []))
//       .catch((err) => console.error("Failed to load epidemic data:", err))
//       .finally(() => setLoading(false));
//   }, []);
  
//    if (loading) return <p>Loading epidemic data...</p>;

//   return (
//     <div>
//       <h2>Recent Epidemic Events</h2>
//       <ul>
//         {epidemics.map((event, index) => (
//           <li key={index}>
//             {event.country}: {event.indicator} - {event.value} ({event.date})
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// }
export default function EpidemicList() { 
  return <div style={{ padding: "1rem" }}>Anomalies will be listed here.</div>;
};
