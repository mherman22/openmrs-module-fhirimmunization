openmrs-module-procedure
=================================

Implement a 3-tier architecture in an OpenMRS module using any level 4 or level 5 FHIR v4 Resources. I chose procedure for this case and hopefully i will be able to create a module for it that fits well into the openMRS modular framework.

Description
-----------
Procedure module using the immunization fhir resource.

Building from Source
--------------------
You will need to have Java 1.6+ and Maven 2.x+ installed.  Use the command 'mvn package' to 
compile and package the module.  The .omod file will be in the omod/target folder.

Alternatively you can add the snippet provided in the [Creating Modules](https://wiki.openmrs.org/x/cAEr) page to your 
omod/pom.xml and use the mvn command:

    mvn package -P deploy-web -D deploy.path="../../openmrs-1.8.x/webapp/src/main/webapp"

It will allow you to deploy any changes to your web 
resources such as jsp or js files without re-installing the module. The deploy path says 
where OpenMRS is deployed.

Installation
------------
1. Build the module to produce the .omod file.
2. Use the OpenMRS Administration > Manage Modules screen to upload and install the .omod file.

If uploads are not allowed from the web (changable via a runtime property), you can drop the omod
into the ~/.OpenMRS/modules folder.  (Where ~/.OpenMRS is assumed to be the Application 
Data Directory that the running openmrs is currently using.)  After putting the file in there 
simply restart OpenMRS/tomcat and the module will be loaded and started.

stuff to be done here
---------------------
- a POJO which will have all the required and optional properties
- a liquibase.xml changeset that implements the database table
- a Hibernate interface and Implementation to CRUD to the database table
- a Service that provides helper methods to CRUD to the database table
