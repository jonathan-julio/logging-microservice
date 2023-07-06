FROM openjdk:17
RUN mkdir /app
ARG JAR_FILE=target/service.jar
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]