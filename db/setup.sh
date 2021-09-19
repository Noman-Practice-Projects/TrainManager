# shellcheck disable=SC2188
while [ ! -e /var/run/postgresql/.s.PGSQL.5432 ]; do sleep 1; done
psql -c "ALTER USER ${POSTGRES_USER} PASSWORD '${POSTGRES_PASSWORD}';"
psql -f /mockinit/schema.sql
psql -f /mockinit/data.sql
