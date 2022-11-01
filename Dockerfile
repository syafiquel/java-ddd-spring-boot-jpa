FROM openjdk:11-jdk


WORKDIR /home/dev

COPY . .

RUN ./mvnw clean package -DskipTests

COPY target/film.app-0.0.1-SNAPSHOT.jar film.app-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java","-jar","/film.app-0.0.1-SNAPSHOT.jar" ]

#CMD [  "/bin/bash" ]
