psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE "qa-portal";
    GRANT ALL PRIVILEGES ON DATABASE "qa-portal" TO postgres;
EOSQL