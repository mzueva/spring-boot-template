Template for Spring Boot Application

Includes:

* Spring Boot
* Multi module Gradle build, including core library and MVC application
* Spring MVC with demo REST API
* Embedded Tomcat
* Swagger 2
* Logging Log4j2, configured Message helper
* Checkstyle, PMD, Sonarqube plugins 
* Tests examples

Build process:

 ```
    $ git clone https://github.com/mzueva/spring-boot-template.git
    $ cd spring-boot-template
    $ ./gradlew application:bootRepackage
    $ cd /application/build/libs/
    $ java -jar application-0.1.jar
 ```
 
Welcome page is available at **http://localhost:8080/app**

Swagger documentation is available at **http://localhost:8080/app/restapi/swagger-ui.html#/**
