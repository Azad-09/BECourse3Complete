FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE=ProdDb
ENV MONGO_URL = mongodb://localhost:27017/ProdDb
ADD ./target/Sprint4BE-0.0.1-SNAPSHOT.jar /usr/lib/Sprint4BE-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Sprint4BE-0.0.1-SNAPSHOT.jar"]