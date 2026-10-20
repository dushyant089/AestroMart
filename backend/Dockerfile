
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Create Java truststore from the TiDB Cloud CA certificate
COPY tidb-ca.pem /app/tidb-ca.pem

RUN keytool -importcert \
    -noprompt \
    -alias tidb-cloud-ca \
    -file /app/tidb-ca.pem \
    -keystore /app/tidb-truststore.jks \
    -storepass changeit

# Build the Spring Boot application
RUN mvn -B -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy application and TiDB TLS truststore
COPY --from=build /app/target/ecommerce-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build /app/tidb-truststore.jks /app/tidb-truststore.jks

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
