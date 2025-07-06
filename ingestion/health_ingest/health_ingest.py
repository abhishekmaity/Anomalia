import requests
import psycopg2
from config import WHO_API_URL, DB_CONFIG
from datetime import datetime

def fetch_health_data():
    response = requests.get(WHO_API_URL)
    response.raise_for_status()
    return response.json()

def store_health_data(data):
    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()

    cur.execute("""
        CREATE TABLE IF NOT EXISTS health_anomalies (
            id SERIAL PRIMARY KEY,
            indicator VARCHAR,
            country VARCHAR,
            date DATE,
            value NUMERIC,
            UNIQUE(indicator, country, date)
        );
    """)

    records = data.get("value", [])
    print(f"📊 Records received: {len(records)}")

    for item in records:
        indicator = item.get('Indicator', {}).get('Title') or item.get('indicator') or "unknown"
        country = item.get("SpatialDim") or item.get("country") or "unknown"
        date = item.get("TimeDim") or item.get("date") or "2024"
        raw_value = item.get("Value") or item.get("value")
        try:
            value = float(str(raw_value).split()[0]) if raw_value else None
        except:
            value = None
        if value is None:
            print(f"Skipping invalid value: {raw_value}")
            continue

        print(f"Inserting: {indicator}, {country}, {date}, {value}")

        try:
            cur.execute("""
                INSERT INTO health_anomalies (indicator, country, date, value)
                VALUES (%s, %s, %s, %s)
                ON CONFLICT (indicator, country, date) DO NOTHING;
            """, (
                indicator,
                country,
                f"{date}-01-01",
                value
            ))
        except Exception as e:
            print(f"Skipped record due to error: {e}")

    conn.commit()
    cur.close()
    conn.close()
    print("Health data committed to database.")


    conn.commit()
    cur.close()
    conn.close()

if __name__ == "__main__":
    try:
        data = fetch_health_data()
        store_health_data(data)
        print("Health data ingested successfully.")
    except Exception as e:
        print("Error:", e)
