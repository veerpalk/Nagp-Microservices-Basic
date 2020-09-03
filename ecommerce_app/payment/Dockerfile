FROM java:8
EXPOSE 8094
ADD /target/payment-0.0.1-SNAPSHOT.jar payment.jar
ENTRYPOINT ["java","-jar","payment.jar"]