FROM maven:3.6.0-jdk-8-alpine

COPY src /home/bps/src
COPY pom.xml /home/bps
COPY testng.xml /home/bps

RUN mvn -f /home/bps/pom.xml clean test -DskipTests=true