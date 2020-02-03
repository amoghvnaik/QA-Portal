::QA Portal Setup for Keycloak V6.0.1 only DO NOT USE ON MOST RECENT VERSIONS.
@echo off
cd ..
START standalone.bat
timeout /t 15 /nobreak
taskkill /fi "windowtitle eq c:\Windows\SYSTEM32\cmd.exe - standalone.bat"

cd exported_realms
xcopy /Y /s .\modules ..\..\
xcopy /Y /s .\standalone ..\..\
cd ..
::echo "first standalone setup"
START standalone.bat  -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=dir -Dkeycloak.migration.dir=exported_realms -Dkeycloak.migration.strategy=OVERWRITE_EXISTING
::echo "second standalone setup"
exit