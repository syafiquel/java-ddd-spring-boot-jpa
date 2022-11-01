FROM openjdk:11-jdk

WORKDIR /home/dev

COPY . .

RUN ./mvnw spring-boot:run

CMD [  "/bin/bash" ]



