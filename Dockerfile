FROM eclipse-temurin:11-jre

WORKDIR /app

COPY target/demo-1.1.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
