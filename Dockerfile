FROM openjdk:11
EXPOSE 8090
COPY target/ratings-data-service*.jar /target/ratings-data-service.jar
ENTRYPOINT ["java","-jar","/target/ratings-data-service.jar"]
