FROM java:8
EXPOSE 9999
ADD /target/apigateway-0.0.1-SNAPSHOT.jar apigateway.jar
ENTRYPOINT ["java","-jar","apigateway.jar"]