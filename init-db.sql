SELECT 'CREATE DATABASE cloudsolux_foods_db'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'cloudsolux_foods_db')\gexec