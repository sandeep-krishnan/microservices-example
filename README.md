# microservices-example
# Build  
Execute the following commands to build and run 

mvn install ;   
docker-compose build;  
docker-compose up;  

# Debugging
## Docker commands 

Find and stop all running images  
docker ps | awk '{print $1}' | xargs docker stop   

Remove postgres container - to start with a clean slate  
docker rm -v postgres 
