FROM openjdk:8u181-jdk-alpine
RUN mkdir /opt
WORKDIR /opt
RUN wget --quiet -O - http://archive.apache.org/dist/activemq/5.11.1/apache-activemq-5.11.1-bin.tar.gz | tar -zx
WORKDIR apache-activemq-5.11.1/bin
CMD ./activemq start && tail -F ../data/activemq.log
EXPOSE 61616/tcp
EXPOSE 8161/tcp