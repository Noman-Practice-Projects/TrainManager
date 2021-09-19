FROM postgres

# Setup user name and password
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password

WORKDIR "/"

RUN ["mkdir", "mockinit"]

# copy the db directory into postgres
COPY db/schema.sql /mockinit/schema.sql
COPY db/data.sql /mockinit/data.sql

# Copy the setup.sh into entry point of docker container
COPY db/setup.sh docker-entrypoint-initdb.d/setup.sh
RUN ["chmod", "+x", "/docker-entrypoint-initdb.d/setup.sh"]

USER "postgres"

# Expose port 5432 of the postgres
EXPOSE 5432

