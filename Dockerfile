FROM eclipse-temurin:11
#ADD /Users/yandi.lin/.jenkins/workspace/demo/build/libs/demo-0.0.1-SNAPSHOT.jar /app.jar
ADD /Users/yandi.lin/Documents/empc_self_learning/ci_k8s_homework/demo/build/libs/demo-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
