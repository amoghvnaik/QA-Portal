FROM openjdk:11.0.6-jdk-slim
WORKDIR /opt/app
COPY ./target .
ENTRYPOINT ["/usr/local/openjdk-11/bin/java", "-jar", "feedback-api-0.0.1-SNAPSHOT.jar"]

#ENTRYPOINT ["sleep", "3000"]


