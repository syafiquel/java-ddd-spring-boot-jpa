FROM openjdk:11-jdk

RUN git clone https://github.com/syafiquel/spring-boot-hibernate-postgres.git

WORKDIR /home/dev/spring-boot-hibernate-postgres

CMD [  "./mvnw spring-boot:run" ]



