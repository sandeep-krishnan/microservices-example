# microservices-example
# Build  
Execute the following commands to build and run 

mvn install ;   
docker-compose build;  
docker-compose up;  

# Testing
1) Check if service discovery is working by invoking catalog-service   
http://localhost:18080/catalog-service/api/products/1

2) Direct API to the catalog-service  
http://localhost:18081/api/products/1

3) Check if services are properly registered in discovery service  
http://localhost:18761  

4) Check if properties are set correctly  
http://localhost:18888/image-service/default 

# Debugging
## Docker commands 

Find and stop all running images  
docker ps | awk '{print $1}' | xargs docker stop   

Remove postgres container - to start with a clean slate  
docker rm -v postgres 
