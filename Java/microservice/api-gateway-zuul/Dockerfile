FROM hub.qinchao.me/microservice/openjdk:8-jre
MAINTAINER sulvto

COPY target/api-gateway-zuul-1.0-SNAPSHOT.jar /api-gateway-zuul.jar

ENTRYPOINT ["java", "-jar", "/api-gateway-zuul.jar"]
