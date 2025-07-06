import os
import praw
import psycopg2
from datetime import datetime
from pathlib import Path
from dotenv import load_dotenv

dotenv_path = Path(__file__).parent / '.env'
load_dotenv(dotenv_path=dotenv_path)

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

SUBREDDITS = ["worldnews", "science", "technology", "globalhealth"]
LIMIT = 10

def fetch_and_store_trends():
    reddit = get_reddit_client()
    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()

    cur.execute("""
    CREATE TABLE IF NOT EXISTS reddit_trends (
        id SERIAL PRIMARY KEY,
        subreddit VARCHAR,
        title TEXT,
        score INTEGER,
        url TEXT,
        created_at TIMESTAMP,
        UNIQUE(subreddit, title, created_at)
    );
    """)

    inserted_count = 0
    for sub in SUBREDDITS:
        print(f"Fetching top posts from r/{sub}")
        for post in reddit.subreddit(sub).hot(limit=LIMIT):
            title = post.title
            score = post.score
            url = post.url
            created_at = datetime.fromtimestamp(post.created_utc)

            try:
                cur.execute("""
                    INSERT INTO reddit_trends (subreddit, title, score, url, created_at)
                    VALUES (%s, %s, %s, %s, %s)
                    ON CONFLICT DO NOTHING;
                """, (sub, title, score, url, created_at))
                inserted_count += 1
            except Exception as e:
                print(f"Skipped: {e}")

    conn.commit()
    print(f"Inserted {inserted_count} posts.")
    cur.close()
    conn.close()

if __name__ == "__main__":
    fetch_and_store_trends()
