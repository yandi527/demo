FROM eclipse-temurin:11
ADD /Users/yandi.lin/.jenkins/workspace/demo/build/libs/demo-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
