FROM openjdk:11.0.6-jre-slim-buster

RUN ["mkdir", "/opt/app", "-p"]

ADD ["entrypoint.sh", "/opt/app/"]
ADD ["target/remote-jmx.jar", "/opt/app/"]

RUN ["chmod", "+x", "/opt/app/entrypoint.sh"]
ENTRYPOINT ["/opt/app/entrypoint.sh"]