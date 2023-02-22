FROM openjdk:11
EXPOSE 9898
ADD target/bikefactory.jar bikefactory.jar
ENTRYPOINT ["java", "-jar", "/bikefactory.jar"]