## 🧠 Health Ingestion Microservice

Fetches global health indicators (e.g., life expectancy) from WHO's GHO API and stores them in PostgreSQL.

### 🔗 Source
- WHO GHO API: https://ghoapi.azureedge.net/api/WHOSIS_000001

### 🧠 Data Fields
- `indicator`: Indicator name (e.g., Life expectancy)
- `country`: Country name or code
- `date`: Year (e.g., 2024)
- `value`: Metric value

### 🧪 Usage
```bash
pip install -r requirements.txt
python3 health_ingest.py
