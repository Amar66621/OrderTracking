

# Step 1: Use a base image
FROM eclipse-temurin:17

# Step 2: Set working directory
WORKDIR /OrderTracking

# Step 3: Copy your JAR file into the container
COPY /target/OrderTracking-0.0.1-SNAPSHOT.jar .

EXPOSE 8091
# Step 4: Set the command to run the JAR
CMD ["java", "-jar", "OrderTracking-0.0.1-SNAPSHOT.jar"]

