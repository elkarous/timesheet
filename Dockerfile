FROM java:8
EXPOSE 8083
ADD target/timesheet-0.0.1-SNAPSHOT.war timesheet-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/timesheet-0.0.1-SNAPSHOT.war"]

