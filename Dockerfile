FROM openjdk:17
ADD target/RestAPI-Project.jar RestAPI-Project.jar
ENTRYPOINT [ "java","-jar","/RestAPI-Project.jar" ]
