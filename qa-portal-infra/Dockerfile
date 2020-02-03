FROM jboss/keycloak
WORKDIR /opt/jboss/keycloak/bin/exported_realms
COPY ./keycloak/exported_realms .
#RUN . /opt/jboss/keycloak/bin/exported_realms/Setup.sh
ENTRYPOINT ["/bin/sh", "/opt/jboss/keycloak/bin/standalone.sh"]
#ENTRYPOINT ["sleep", "3000"]
