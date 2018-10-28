FROM openjdk:8u181-jdk
RUN apt-get update && apt-get --quiet --assume-yes install wget
RUN wget --quiet -O - http://apache-mirror.rbc.ru/pub/apache//directory/apacheds/dist/2.0.0.AM25/apacheds-2.0.0.AM25.tar.gz | tar -zxC /opt
WORKDIR /opt/apacheds-2.0.0.AM25
