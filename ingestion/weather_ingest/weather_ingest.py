import requests
import psycopg2
from datetime import datetime
from config import API_KEY, CITY, UNITS, DB_CONFIG

def fetch_weather():
    url = f"http://api.openweathermap.org/data/2.5/weather?q={CITY}&appid={API_KEY}&units={UNITS}"
    response = requests.get(url)
    response.raise_for_status()
    return response.json()

def store_weather(data):
    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()

    # Create table if it doesn't exist
    cur.execute("""
        CREATE TABLE IF NOT EXISTS weather_anomalies (
            id SERIAL PRIMARY KEY,
            city VARCHAR(50),
            temperature REAL,
            humidity INT,
            pressure INT,
            recorded_at TIMESTAMP
        );
    """)

    # Insert data into table
    cur.execute("""
        INSERT INTO weather_anomalies (city, temperature, humidity, pressure, recorded_at)
        VALUES (%s, %s, %s, %s, %s);
    """, (
        data['name'],
        data['main']['temp'],
        data['main']['humidity'],
        data['main']['pressure'],
        datetime.utcnow()
    ))

    conn.commit()
    cur.close()
    conn.close()

if __name__ == "__main__":
    try:
        weather = fetch_weather()
        store_weather(weather)
        print("Weather data inserted.")
    except Exception as e:
        print("Error:", e)
