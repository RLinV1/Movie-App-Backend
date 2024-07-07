# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container at /app
COPY target/movies-0.0.1-SNAPSHOT.jar /app/movies-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application uses
EXPOSE 8080

# Command to run the application when the container starts
CMD ["java", "-jar", "movies-0.0.1-SNAPSHOT.jar"]
