#QA Portal Setup for Keycloak V6.0.1 only DO NOT USE ON MOST RECENT VERSIONS.
#!/bin/bash
cd ..
timeout 15 xterm -e ./standalone.sh
cd exported_realms
cp -R ./modules ../..
cp -R ./standalone ../..
cd ..
./standalone.sh -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=dir -Dkeycloak.migration.dir=exported_realms -Dkeycloak.migration.strategy=OVERWRITE_EXISTING