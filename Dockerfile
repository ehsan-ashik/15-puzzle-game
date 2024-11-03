FROM maven:3.5.0-jdk-8

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY dist/FifteenPuzzleStart.jar /app/


# Run the Swing application
CMD ["java", "-jar", "FifteenPuzzleStart.jar"]
