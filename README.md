openmrs-module-procedure
=================================

A [Procedure](https://www.hl7.org/fhir/procedure.html) is an action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.

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
============
Option A
--------
1. Build the module to produce the .omod file.
2. Use the OpenMRS Administration > Manage Modules screen to upload and install the .omod file.

Option B
--------
1. Setup a local instance of OpenMRS using [OpenMrs-SDK](https://wiki.openmrs.org/display/docs/OpenMRS+SDK).
2. cd into `openmrs-module-procedure` and build the module using `mvn clean package`.
3. Trigger `mvn openmrs-sdk:deploy -DserverId={your-server-name}` which will automatically deploy your `.omod` file onto your server.
4. Trigger `mvn openmrs-sdk:run -DserverId={your-server-name}` to start up the server

If uploads are not allowed from the web (changable via a runtime property), you can drop the omod
into the ~/.OpenMRS/modules folder.  (Where ~/.OpenMRS is assumed to be the Application 
Data Directory that the running openmrs is currently using.)  After putting the file in there 
simply restart OpenMRS/tomcat and the module will be loaded and started.
