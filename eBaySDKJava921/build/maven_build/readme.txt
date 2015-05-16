STEPS TO BUILD SDK CORE JAR USING MAVEN

Prerequisite
- JDK 1.6(after 1.6.04)

STEP 1:
Create a new project with following Maven project style folders:
src\main\java
src\main\resources

STEP 2:
Copy all source under '{JavaSDK}\source\core\src' folder to '{NewProject}\src\main\java' folder.
Copy all source under '{JavaSDK}\source\apiCalls\src' folder to '{NewProject}\src\main\java' folder. 
Copy all source under '{JavaSDK}\source\attributesLib\src' folder to '{NewProject}\src\main\java' folder. 
Copy all source under '{JavaSDK}\source\helper\src' folder to '{NewProject}\src\main\java' folder. 
Delete 'soap' folder under '{NewProject}\src\main\java\com\ebay' folder, as the source under 'soap'
will be auto-generated later by the Maven build.
Copy file '{JavaSDK}\build\custom-binding.xml' to '{NewPorject}\' folder.
Copy file '{JavaSDK}\build\jaxb-binding.xjb' to '{NewProject}' folder. 
Update custom-binding.xml with the correct WSDL location. wsdlLocation="./src/main/resources/eBaySvc.wsdl" 
Copy file '{JavaSDK}\source\wsdl\eBaySvc.wsdl' to '{NewProject}\src\main\resources' folder.
Copy file '{JavaSDK}\build\maven_build\pom.xml' to '{NewProject}\' folder.

SETP 3:
Open a command window, run
-------------------------------------------------
set MAVEN_OPTS=-Xmx512m
-------------------------------------------------
to ensure Maven has enough memory to run the SDK build

STEP 4:
In the sample commmand window, go to '{NewProject}\' folder, run
-------------------------------------------------
mvn -e clean package
-------------------------------------------------
to build the SDK core jar, if the build is successful, the jar file
will be built to '{NewProject}\target' folder.

Notes:
1. The Maven build will call wsimport ant task to generate proxy from eBay wsdl,
for details, please refer to pom.xml file.
2. The build was tested with following configuration-
- Java 1.6.06
- Maven 2.2.1
- Windows XP

