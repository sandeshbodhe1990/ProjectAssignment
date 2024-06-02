FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY ./target/customerManagement-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]