FROM openjdk:12-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
CMD ["./mvnw","install", "-Dmaven.test.skip=true"]
CMD ["./mvnw","package", "-Dmaven.test.skip=true"]

ARG JAR_FILE=target/*.jar 
COPY /target/producers-*.jar /producers.jar
EXPOSE 8080

ENTRYPOINT ["java","-Xmx521m" ,"-jar","/producers.jar"]