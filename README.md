# microservices-example
# Build  
Execute the following commands to build and run 

mvn install ;   
docker-compose build;  
docker-compose up;  

# Testing
1) Check if services are properly registered in discovery service - http://localhost:18761
2) Check if properties are set correctly - http://localhost:18888/image-service/default 

# Debugging
## Docker commands 

Find and stop all running images  
docker ps | awk '{print $1}' | xargs docker stop   

Remove postgres container - to start with a clean slate  
docker rm -v postgres 
