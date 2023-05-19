FROM openjdk:17-slim

WORKDIR /app

VOLUME /tmp

COPY . .
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./

#RUN ./mvnw dependency:resolve

#COPY src ./src

#RUN ./mvnw package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/desafio1-0.0.1-SNAPSHOT.jar"]