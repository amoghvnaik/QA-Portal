# QA Portal Infrastructure


Project providing instructions for setting up local development environment to support running the QA Portal

**[1. Postgres](#postgres)**
- [Install Postgres](#install-postgres)
- [Create qa-portal database](#create-qa-portal-database)
- [Create keycloak database](#create-keycloak-database)

**[2. Keycloak](#keycloak)**
- [Install Keycloak](#install-keycloak)
- [Import Keycloak Realm files](#import-keycloak-realm-files)
- [Start Keycloak instance](#start-keycloak-instance)
- [Manage Keycloak users](#manage-keycloak-users)
- [in-case-of-error-500](#in-case-of-error-500)


**[3. MongoDB](#mongodb)**
- [Install MongoDB](#install-mongodb)
- [Create qa-portal-cv database](#create-qa-portal-cv-database)

<a name="postgres"></a>
## 1. Postgres

<a name="install-postgres"></a>
### 1.1. Install Postgres

   - Go to the Postgres download page (https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) and select the download 
appropriate for your platform. Version 11 is currently being used by the QA Portal application

   - Once downloaded, run the installer, **supplying admin user and password (postgres / postgres)**

<a name="create-qa-portal-database"></a>
### 1.2. Create qa-portal database

   - Open pgadmin from the browser right click on Databases and select Create --> Database. Enter the database name as qa-portal and Save

   - The schema and tables will be created when the core-api project in the qa-portal-services folder is run (This is done by a library called Flyway)

<a name="create-keycloak-database"></a>
### 1.3. Create keycloak database

   - Open pgadmin from the browser right click on Databases and select Create --> Database. Enter the database name as keycloak and Save

   - The tables will be created and populated in Step 4 of the Keycloak instructions below.


<a name="keycloak"></a>
## 2. Keycloak

<a name="install-keycloak"></a>
### 2.1. Install Keycloak

   - Download Keycloak from https://www.keycloak.org/archive/downloads-6.0.1.html. Version 6.0.1 is the current version being used by the QA Portal applications.<br>

   - Select the Server - Standalone server distribution ZIP download.<br>

   - Unzip the downloaded file to a location of your choice (referenced as KEYCLOAK_HOME).<br>


<a name="import-keycloak-realm-files"></a>
### 2.2. Import Keycloak Realm files

   - Copy the exported_realms folder (and it's contents) into the KEYCLOAK_HOME/bin folder/<br>

   - Inside of the exported_realms folder run setup.bat on Windows or setup.sh on linux<br>

   - Once the command has executed, keycloak should be started (localhost:8080/auth/admin) and the qa-portal realm should be available (see drop down list at top left of side navigation on the 
admin page. You should also have a master realm available which is created by default)

<a name="start-keycloak-instance"></a>
### 2.3. Start Keycloak instance

   - From the KEYCLOAK_HOME/bin directory, run the ./standalone.bat script for a Windows OS, or run the ./standalone.sh for a linux OS. <br>

   - Set up an admin user and password (admin / admin). See [Keycloak documentation](https://www.keycloak.org/docs/latest/getting_started/index.html) 
sections 2.3 and 2.4 for full instructions.<br> 

<a name="manage-keycloak-users"></a>
### 2.4. Manage keycloak users

As part of the import in step 2.2, the following users should automatically be set up in your qa-portal realm.

   - adminclient1@qa.com with role of super-user and can perform administrative tasks through the portal
   
   - admin1@qa.com with role of training-admin
   
   - trainer1@qa.com  with roles training-manager, Cohort_CI_Intake_1 and Cohort_CI_Intake_2
   
   - trainer2@qa.com  with roles training-manager, Cohort_Java_Intake_1 and Cohort_Java_Intake_2
   
   - trainer3@qa.com  with roles training-manager, Cohort_Scala_Intake_1
   
   - trainee1@qa.com ... trainee5:qa.com with roles training-user and Cohort_CI_Intake_1
   
   - trainee6@qa.com ... trainee10@qa.com with roles training-user and Cohort_CI_Intake_2
   
   - trainee11@qa.com ... trainee15@qa.com with roles training-user and Cohort_Java_Intake_1
   
   - trainee16@qa.com ... trainee20@qa.com with roles training-user and Cohort_Java_Intake_2
   
   - trainee21@qa.com ... trainee25@qa.com with roles training-user and Cohort_Scala_Intake_1

Any additional new Portal users should be added through the QA Portal User management features of the administration application. This application will be available when you log into the portal as adminclient1@qa.com

<a name="in-case-of-error-500"></a>
### 2.5. In case of error 500

- In case of error 500 while running the software please check what version of JAVA you are running by looking into the top right of the screen in keycloak, and by clicking server Info.
	
- Keycloak only works properly with JRE or openJDK running
	
- The latest version of jre should be used. We advise to always keep java version updated to avoid environment issues.
	
- If any other version than jre is used, check your environment variable and look for the variable JAVA_HOME.
	
- Edit the Variable JAVA_HOME by assigning the path to the java folder you wish to use by default, Or remove it to use the default jre:latest.

<a name="mongodb"></a>
## 3. MongoDB

<a name="install-mongodb"></a>
### 3.1. Install MongoDb

   - Go to the MongoDb download page (https://docs.mongodb.com/manual/administration/install-community/) and select the download 
appropriate for your platform. Version 4.2 is currently being used by the QA Portal application.

   - Once downloaded, run the installer, **supplying admin user and password (mongo / mongo)**

<a name="create-qa-portal-cv-database"></a>
### 3.2. Create qa-portal-cv database

Open MongoDB Compass Community (or mongo shell) create database called qa-portal-cv and create a collection called cv-version
