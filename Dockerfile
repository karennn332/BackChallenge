FROM amazoncorretto:11-alpine-jdk
COPY target/Jobs-0.0.1-SNAPSHOT.jar kd-app.jar
ENTRYPOINT [ "java", "-jar","/kd-app.jar" ]