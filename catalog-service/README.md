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

## Redis
Product Api(by id) will invoke Image service to fetch image details, which will be 
cached in redis

GET http://localhost:18081/api/products/1

The update image API will trigger an event to kafka, which will be listened by Catalog
Service. The listener then invokes the evict cache on redis.

http://localhost:8082/api/images/1

The redis-cli can be used to check the entries in the cache.

$ docker exec -it 7411f4dcdb70 /bin/bash  
root@7411f4dcdb70:/data# redis-cli  
127.0.0.1:6379> keys *  
1) "imageCache::1"  