# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at the specified working directory
COPY target/blackjack-royale-0.jar ./blackjack-royale-0.jar

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "./blackjack-royale-0.jar"]
