FROM  openjdk:11-jdk-oraclelinux7 as base
ENV APP_HOME=/use/app/
WORKDIR $APP_HOME
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
WORKDIR $APP_HOME
ENTRYPOINT ["java","-jar","./app.jar"]