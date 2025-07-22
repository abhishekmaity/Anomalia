import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Dashboard from '../pages/Dashboard';
import EarthquakePage from '../pages/EarthquakePage';

export default function AppRoutes() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/earthquakes" element={<EarthquakePage />} />
        {/* Add routes for /weather, /epidemics, /social, /stocks */}
      </Routes>
    </Router>
  );
}
