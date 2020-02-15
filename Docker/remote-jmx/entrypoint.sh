#!/bin/bash

java \
  -Dcom.sun.management.jmxremote.port=10010 \
  -Dcom.sun.management.jmxremote.rmi.port=10010 \
  -Dcom.sun.management.jmxremote.host=0.0.0.0 \
  -Djava.rmi.server.hostname=0.0.0.0 \
  -Dcom.sun.management.jmxremote.local.only=false \
  -Dcom.sun.management.jmxremote.ssl=false \
  -Dcom.sun.management.jmxremote.authenticate=false \
  -jar /opt/app/remote-jmx.jar