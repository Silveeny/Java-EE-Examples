#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build

COPY src /home/app/src
COPY pom.xml /home/app
COPY payara-micro.jar /home/app/payara-micro.jar
RUN cd /home/app && mvn clean install && mvn clean package

#
# Package stage
#
FROM java:8
COPY --from=build /home/app/payara-micro.jar /usr/local/lib/payara-micro.jar
COPY --from=build /home/app/target/wingman-core.war /usr/local/lib/wingman-core.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/payara-micro.jar", "--deploy", "/usr/local/lib/wingman-core.war", "--contextRoot"," /wingman", "--autoBindHttp" ]


#FROM openjdk:11
#COPY --from=build /home/app/payara-micro.jar /usr/local/lib/payara-micro.jar
#COPY --from=build /home/app/target/brain.war /usr/local/lib/brain.war
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/usr/local/lib/payara-micro.jar", "--deploy", "/usr/local/lib/brain.war", "--contextRoot"," /brain", "--autoBindHttp" ]
