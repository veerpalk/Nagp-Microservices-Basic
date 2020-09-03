FROM java:8
EXPOSE 8761
ADD /target/discovery-server-0.0.1-SNAPSHOT.jar discovery-server.jar
ENTRYPOINT ["java","-jar","discovery-server.jar"]