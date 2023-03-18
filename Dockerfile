FROM gradle:jdk17
WORKDIR /app
COPY /build/libs /app
# RUN gradle clean build --scan --stacktrace --info
CMD ["java","-jar","PantryPlanner-0.0.1-SNAPSHOT.jar"]
