FROM jboss/keycloak:6.0.1
WORKDIR /opt/jboss/exported_realms
COPY ./keycloak/exported_realms .
#RUN . /opt/jboss/keycloak/bin/exported_realms/Setup.sh
ENTRYPOINT [ "/opt/jboss/tools/docker-entrypoint.sh" ]
CMD [ "/opt/jboss/exported_realms/Setup.sh" ]
#CMD ["-Dkeycloak.migration.action=import", "-Dkeycloak.migration.provider=dir", "-Dkeycloak.migration.dir=/opt/jboss/exported_realms", "-Dkeycloak.migration.strategy=OVERWRITE_EXISTING"]
#ENTRYPOINT ["/bin/sh"]
#ENTRYPOINT ["sleep", "3000"]
