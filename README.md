
To build and run, execute the following:
 `docker-compose up --build`

To build and run, execute the following: `docker run -d --name test-postgres-easy -e POSTGRES_PASSWORD=password -v $(pwd)/db/schema.sql:/docker-entrypoint-initdb.d/1-schema.sql -v $(pwd)/db/data.sql:/docker-entrypoint-initdb.d/2-data.sql -p 5432:5432 postgres:10 && docker build -t test-app-easy . && docker run -d --name test-app-easy -e SPRING_DATASOURCE_URL=jdbc:postgresql://192.168.1.213:5432/postgres -p 8080:8080 -ti test-app-easy /bin/bash`

** Note: Replace

<host_ip> with the actual ip address of the machine.</host_ip>
