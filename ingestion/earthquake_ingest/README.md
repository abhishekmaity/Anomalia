## 🌍 Earthquake Ingestion Microservice

This microservice fetches real-time earthquake data from the [USGS Earthquake Feed](https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php) and stores it in PostgreSQL for use in the Anomalia system.

### ✅ Features
- Realtime ingestion from USGS GeoJSON feed
- Stores magnitude, location, depth, timestamp
- Deduplicates records via quake ID
- Designed for microservice architecture

### 🔧 Configuration
Edit `config.py` to set DB config or change to `all_day.geojson` or `all_week.geojson`.

### 🚀 Usage
```bash
pip install -r requirements.txt
python3 earthquake_ingest.py
```

### 🗃️ PostgreSQL Table Schema
```sql
CREATE TABLE earthquake_anomalies (
  id SERIAL PRIMARY KEY,
  quake_id VARCHAR(50) UNIQUE,
  place TEXT,
  magnitude REAL,
  time TIMESTAMP,
  longitude DOUBLE PRECISION,
  latitude DOUBLE PRECISION,
  depth DOUBLE PRECISION
);
```

### 📦 Data Source
[USGS Earthquake Feeds](https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php)
