## 💬 Reddit Ingestion Microservice

This microservice collects trending Reddit posts from multiple high-signal subreddits and stores them in the PostgreSQL database for anomaly detection and event correlation under the **Anomalia** platform.

---

### ✅ Features

- 🔍 Fetches trending posts from subreddits like `worldnews`, `science`, `technology`, and `globalhealth`
- 🧠 Detects and stores anomalies in Reddit-based signals
- 🧱 Inserts into PostgreSQL with duplicate protection
- 🔐 Secure config via `.env` using `python-dotenv`

---
### 🚀 Usage
```bash
pip install -r requirements.txt
python3 reddit_ingest.py
```
