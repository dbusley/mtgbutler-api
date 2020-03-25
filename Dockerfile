FROM openjdk:11

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

RUN echo "java -jar /app.jar" > /run.sh

ENTRYPOINT ["/bin/bash", "/run.sh"]