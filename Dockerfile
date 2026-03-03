FROM eclipse-temurin:25
ADD target/*.jar Ask-AI.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Ask-AI.jar"]
