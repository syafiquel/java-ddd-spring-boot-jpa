FROM openjdk:11-jdk

WORKDIR /home/dev

COPY . .

RUN ./mvnw clean package -DskipTests

ENTRYPOINT [ "./mvnw","spring-boot:run" ]
