FROM java:8-jre

ADD target/gs-accessing-data-neo4j-0.1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 9001
