FROM java:8
EXPOSE 8085
ADD target/timesheet-7.0.0-SNAPSHOT.war timesheet-7.0.0-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/timesheet-7.0.0-SNAPSHOT.war"]



