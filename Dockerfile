FROM openjdk:11-oraclelinux7

ADD target/demo-kafka-producer-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 5000