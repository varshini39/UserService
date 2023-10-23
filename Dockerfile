# Use a base image that includes Java
FROM eclipse-temurin:17

# Set the working directory
WORKDIR /app/user-service

# Copy the JAR file into the container
COPY target/user-service-1.jar user-service.jar

# Command to run your application
ENTRYPOINT ["java", "-jar", "user-service.jar"]
