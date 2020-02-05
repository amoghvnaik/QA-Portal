FROM jboss/keycloak:6.0.1
WORKDIR /opt/jboss/keycloak/bin/exported_realms
COPY ./keycloak/exported_realms .
#RUN . /opt/jboss/keycloak/bin/exported_realms/Setup.sh
#ENTRYPOINT ["/bin/sh", "/opt/jboss/keycloak/bin/exported_realms/Setup.sh"]
ENTRYPOINT ["/bin/sh"]
#ENTRYPOINT ["sleep", "3000"]
