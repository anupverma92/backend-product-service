FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backend-product-service.jar
ENTRYPOINT ["java","-jar","/backend-product-service.jar"]