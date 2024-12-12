FROM openjdk:21-jdk
ARG JAR_FILE=target/S4_final_sprint_2024-travelapi-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
