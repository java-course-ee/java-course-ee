FROM openjdk:11.0.6-jre-slim-buster
ADD ["Greeting.class", "~/"]
WORKDIR "~/"
ENTRYPOINT ["java", "Greeting", "World"]