FROM openjdk
WORKDIR usr/lib
EXPOSE 8073
ENV MONGO_DATABASE=ProdDb
ENV MONGO_URL = mongodb://localhost:27017/ProdDb
ADD ./target/ProductMongo-0.0.1-SNAPSHOT.jar /usr/lib/ProductMongo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ProductMongo-0.0.1-SNAPSHOT.jar"]