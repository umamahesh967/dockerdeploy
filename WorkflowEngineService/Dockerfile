FROM openjdk:8
ADD target/worksetup-service.jar worksetupService.jar
EXPOSE 8102
ENTRYPOINT ["java", "-jar", "worksetupService.jar"]
