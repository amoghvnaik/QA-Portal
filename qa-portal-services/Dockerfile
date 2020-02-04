FROM maven:3.6.1-jdk-8-slim AS build
ARG PROJECT
WORKDIR /build
COPY . .
RUN mvn clean install --projects api-common,${PROJECT}

FROM openjdk:8-alpine
ARG PROJECT
WORKDIR /opt/${PROJECT}
COPY --from=build /build/${PROJECT}/target/${PROJECT}-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-Dspring.datasource.url=jdbc:postgresql://postgres:5432/qa-portal", "-Dspring.data.mongodb.uri=mongodb://mongo/qa-portal-cv", "-jar", "./app.jar"]
