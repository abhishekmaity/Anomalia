import os
import praw
import psycopg2
from datetime import datetime
from dotenv import load_dotenv

load_dotenv()

# Reddit credentials
REDDIT_CLIENT_ID = os.getenv("W1Fnuv5ExpxppibkJcyfIA")
REDDIT_CLIENT_SECRET = os.getenv("sxZyxX5PuP6annGQt9ksWGVHQgyYQA")
REDDIT_USER_AGENT = os.getenv("AnomaliaTrendApp/1.0 for project")
REDDIT_USERNAME = os.getenv("anomalia_devlopment")
REDDIT_PASSWORD = os.getenv("anomalia")

# DB credentials
DB_CONFIG = {
    "host": os.getenv("DB_HOST", "localhost"),
    "port": os.getenv("DB_PORT", "5432"),
    "database": os.getenv("DB_NAME", "anomalia"),
    "user": os.getenv("DB_USER", "postgres"),
    "password": os.getenv("DB_PASSWORD", "anomalia")
}

def get_reddit_client():
    return praw.Reddit(
        client_id=REDDIT_CLIENT_ID,
        client_secret=REDDIT_CLIENT_SECRET,
        user_agent=REDDIT_USER_AGENT,
        username=REDDIT_USERNAME,
        password=REDDIT_PASSWORD
    )

def fetch_and_store_trends():
    print("Reddit ingestion for trends!")

if __name__ == "__main__":
    fetch_and_store_trends()
