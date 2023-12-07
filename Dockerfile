FROM amazoncorretto:17-alpine-jdk
#MAINTAINER KD
COPY target/Jobs-0.0.1-SNAPSHOT.jar kd-app.jar
ENTRYPOINT [ "java", "-jar","/kd-app.jar" ]