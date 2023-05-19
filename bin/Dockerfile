FROM adopt:17-slim

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve

COPY src ./src

RUN ./mvnw package -DskipTests

CMD ["java", "-jar", "target/adopt-openjdk-17-slim.jar"]