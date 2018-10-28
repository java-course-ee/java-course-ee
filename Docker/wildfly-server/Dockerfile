FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
ENV JAVA_OPTS "-Xms128m -Xmx128m -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=128m -Djava.net.preferIPv4Stack=true -Djboss.modules.system.pkgs=$JBOSS_MODULES_SYSTEM_PKGS -Djava.awt.headless=true"