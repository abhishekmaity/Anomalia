import requests
import psycopg2
from datetime import datetime
from config import ALPHA_VANTAGE_API_KEY, SYMBOL, DB_CONFIG

def fetch_stock_data():
    url = f"https://www.alphavantage.co/query"
    params = {
        "function": "TIME_SERIES_INTRADAY",
        "symbol": SYMBOL,
        "interval": "60min",
        "apikey": ALPHA_VANTAGE_API_KEY
    }
    response = requests.get(url, params=params)
    response.raise_for_status()
    return response.json()

def store_stock_data(data):
    time_series = data.get("Time Series (60min)", {})
    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()

    cur.execute("""
        CREATE TABLE IF NOT EXISTS stock_anomalies (
            id SERIAL PRIMARY KEY,
            symbol VARCHAR(10),
            timestamp TIMESTAMP,
            open NUMERIC,
            high NUMERIC,
            low NUMERIC,
            close NUMERIC,
            volume BIGINT,
            UNIQUE(symbol, timestamp)
        );
    """)

    for timestamp, values in time_series.items():
        dt = datetime.strptime(timestamp, "%Y-%m-%d %H:%M:%S")
        cur.execute("""
            INSERT INTO stock_anomalies (symbol, timestamp, open, high, low, close, volume)
            VALUES (%s, %s, %s, %s, %s, %s, %s)
            ON CONFLICT (symbol, timestamp) DO NOTHING;
        """, (
            SYMBOL,
            dt,
            values.get("1. open"),
            values.get("2. high"),
            values.get("3. low"),
            values.get("4. close"),
            values.get("5. volume")
        ))

    conn.commit()
    cur.close()
    conn.close()

if __name__ == "__main__":
    try:
        data = fetch_stock_data()
        store_stock_data(data)
        print("Stock data ingested successfully.")
    except Exception as e:
        print("Error:", e)
