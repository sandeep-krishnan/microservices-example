# Building
Maven docker spotify plugin is integrated for this project. It will work only  
if the build is done within this project, not the parent.  

mvn dockerfile:build

# Testing
Management endpoint is enabled in the bootstrap.yml, which should show all the properties  
which are set for catalog-service in the config

http://localhost:8081/actuator/env

## Service registration
The application will register itself to the spring eureka server after startup  

http://localhost:8761/eureka/apps/catalog-service

