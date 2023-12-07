FROM openjdk:10.0.1-10-jre-slim
COPY target/Jobs-0.0.1-SNAPSHOT.jar kd-app.jar
WORKDIR /app
CMD [ "java","-jar","app.jar" ]