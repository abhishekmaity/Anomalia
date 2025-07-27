import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

// Pages / Components
import Dashboard from "../pages/Dashboard";
import EarthquakeList from "../../components/EarthquakeList";
import WeatherList from "../../components/WeatherList";
import EpidemicList from "../../components/EpidemicList";
import SocialTrendList from "../../components/SocialTrendList";
import FinancialAnomalyList from "../../components/FinancialAnomalyList";

export default function AppRoutes() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/earthquakes" element={<EarthquakeList />} />
        <Route path="/weather" element={<WeatherList />} />
        <Route path="/epidemics" element={<EpidemicList />} />
        <Route path="/social-trends" element={<SocialTrendList />} />
        <Route path="/financial" element={<FinancialAnomalyList />} />
      </Routes>
    </Router>
  );
}
