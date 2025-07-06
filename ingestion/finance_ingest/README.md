# 💸 Finance Ingestion Microservice

Fetches stock market data from [Alpha Vantage](https://www.alphavantage.co/) and stores it in PostgreSQL.

## Features
- Uses Alpha Vantage intraday API (60min)
- Stores price, volume, timestamp, and symbol
- Deduplicates records by symbol + timestamp

## Configuration
Update `config.py` with your API key and desired stock symbol.

## Usage
```bash
pip install -r requirements.txt
python3 finance_ingest.py
```

## PostgreSQL Table
```sql
CREATE TABLE stock_anomalies (
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
```
