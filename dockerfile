# select parent image
FROM maven:3.6.3-jdk-8

# copy the source tree and the pom.xml to our new container
# COPY ./ ./
COPY /target/spring-boot-docker-0.0.1-SNAPSHOT.jar test-project.jar

# # package our application code
# RUN mvn clean package

# set the startup command to execute the jar
CMD ["java", "-jar", "test-project.jar"]