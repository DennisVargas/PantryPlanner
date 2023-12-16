# Dockerfile Defines the Pantry-Planner Docker Image

# Use a Java runtime as the base image 
FROM eclipse-temurin:17

# Set the working directory inside the container 
WORKDIR /app 

# Copy only the necessary files for running the application 
COPY build/libs/ . 

# Set the command to start the application 
CMD ["java", "-jar", "PantryPlanner-0.0.1-SNAPSHOT.jar"]
