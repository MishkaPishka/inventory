# select parent image
FROM maven:3.6.3-jdk-8

# copy the source tree and the pom.xml to our new container
# COPY ./ ./
# COPY /target/spring-boot-docker-0.0.1-SNAPSHOT.jar test-project.jar
#
# # # package our application code
# # RUN mvn clean package
#
# # set the startup command to execute the jar
# CMD ["java", "-jar", "test-project.jar"]

####
###
##
        # the first stage of our build will use a maven 3.6.1 parent image
        FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

        # copy the pom and src code to the container
        COPY ./ ./

        # package our application code
        RUN mvn clean package

        # the second stage of our build will use open jdk 8 on alpine 3.9
        FROM openjdk:8-jre-alpine3.9

        # copy only the artifacts we need from the first stage and discard the rest
        COPY --from=MAVEN_BUILD /target/spring-boot-docker-0.0.1-SNAPSHOT.jar /demo.jar

        # set the startup command to execute the jar
        CMD ["java", "-jar", "/demo.jar"]