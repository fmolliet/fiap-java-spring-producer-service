FROM openjdk:12-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# RUN ./mvnw package -Dmaven.test.skip=true
CMD ["./mvnw", "-Dmaven.test.skip=true"]

ARG JAR_FILE=target/*.jar 
COPY /target/producers-*.jar /producers.jar
EXPOSE 8080

ENTRYPOINT ["java","-Xmx521m", "-Dserver.port=${PORT}" ,"-jar","/producers.jar"]