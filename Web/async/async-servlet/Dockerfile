FROM jboss/wildfly:19.0.0.Final
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
ADD ./target/async-servlet.war /opt/jboss/wildfly/standalone/deployments/
ENV JAVA_OPTS "-Xms128m -Xmx128m -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=128m -Djava.net.preferIPv4Stack=true -Djboss.modules.system.pkgs=$JBOSS_MODULES_SYSTEM_PKGS -Djava.awt.headless=true"
EXPOSE 8080
EXPOSE 9990
ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh"]
CMD ["-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]