FROM openjdk:17-jdk-alpine

RUN mkdir /api
RUN apk add --no-cache tzdata

ENV TZ=America/Sao_Paulo

WORKDIR /api

COPY process-cpr-api.jar /api/process-cpr-api.jar
COPY .env /api/.env

# Run as non-root
RUN addgroup --system spring && adduser --system spring -G spring
RUN chown -R spring:spring /api

ENTRYPOINT ["java","-jar","/api/process-cpr-api.jar"]
