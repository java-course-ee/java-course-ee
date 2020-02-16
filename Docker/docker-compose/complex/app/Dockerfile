FROM openjdk:11.0.6-jre-slim-buster

RUN ["mkdir", "/opt/app", "-p"]

ADD ["entrypoint.sh", "/opt/app/"]
ADD ["target/complex-app.jar", "/opt/app/"]
ADD ["target/postgresql-42.2.0.jar", "/opt/app/"]

RUN ["chmod", "+x", "/opt/app/entrypoint.sh"]

EXPOSE 8080

ENTRYPOINT ["/opt/app/entrypoint.sh"]