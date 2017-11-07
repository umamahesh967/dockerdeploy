FROM java:8-jre

ADD target/neo4j-service-0.1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 9001
