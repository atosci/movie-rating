FROM openjdk:8-jre-alpine

EXPOSE 8083

ADD target/ratings-data-service-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","ratings-data-service-0.0.1-SNAPSHOT.jar"]

