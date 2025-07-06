import requests
import psycopg2
from datetime import datetime
from config import DB_CONFIG, USGS_FEED_URL

def fetch_earthquake_data():
    response = requests.get(USGS_FEED_URL)
    response.raise_for_status()
    return response.json()

def store_earthquakes(data):
    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()

    cur.execute("""
        CREATE TABLE IF NOT EXISTS earthquake_anomalies (
            id SERIAL PRIMARY KEY,
            quake_id VARCHAR(50) UNIQUE,
            place TEXT,
            magnitude REAL,
            time TIMESTAMP,
            longitude DOUBLE PRECISION,
            latitude DOUBLE PRECISION,
            depth DOUBLE PRECISION
        );
    """)

    for feature in data["features"]:
        quake = feature["properties"]
        coords = feature["geometry"]["coordinates"]
        quake_id = feature["id"]

        cur.execute("""
            INSERT INTO earthquake_anomalies (quake_id, place, magnitude, time, longitude, latitude, depth)
            VALUES (%s, %s, %s, %s, %s, %s, %s)
            ON CONFLICT (quake_id) DO NOTHING;
        """, (
            quake_id,
            quake.get("place"),
            quake.get("mag"),
            datetime.utcfromtimestamp(quake.get("time") / 1000),
            coords[0],
            coords[1],
            coords[2]
        ))

    conn.commit()
    cur.close()
    conn.close()

if __name__ == "__main__":
    try:
        quake_data = fetch_earthquake_data()
        store_earthquakes(quake_data)
        print("Earthquake data ingested successfully.")
    except Exception as e:
        print("Error:", e)
