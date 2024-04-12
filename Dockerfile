FROM openjdk:17-alpine
LABEL authors="rightpair"

RUN apk add --no-cache bash curl

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]