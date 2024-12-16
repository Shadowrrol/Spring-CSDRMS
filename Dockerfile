# Use an official Maven image to build the Spring Boot app
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory for the app
WORKDIR /app

# Cache Maven dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy application source and build JAR file
COPY src ./src
RUN mvn clean package -DskipTests

# Use a production-ready Amazon Corretto image
FROM amazoncorretto:17

# Set working directory for the app
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/csdrms-0.0.1-SNAPSHOT.jar .

# Expose port 8080
EXPOSE 8080

# Environment variables for memory and JVM options
ENV JAVA_OPTS="-Xms512m -Xmx2048m -XX:+UseG1GC -XX:MaxMetaspaceSize=256m"

# Run the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/csdrms-0.0.1-SNAPSHOT.jar"]
