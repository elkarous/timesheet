<<<<<<< Updated upstream
FROM openjdk:8-jdk-alpine
EXPOSE 8083

ADD target/timesheet-0.0.1-SNAPSHOT.war timesheet-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/timesheet-0.0.1-SNAPSHOT.war"]
=======
FROM java:8
EXPOSE 8085
ADD target/timesheet-7.0.0-SNAPSHOT.war timesheet-7.0.0-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/timesheet-7.0.0-SNAPSHOT.war"]
>>>>>>> Stashed changes

