FROM openjdk:8
EXPOSE 8083
ADD target/candidat.jar candidat.jar
ENTRYPOINT ["java", "-jar", "candidat.jar"]
