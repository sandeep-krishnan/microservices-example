# Testing
Check mongodb after application starts up  

mongo --username root --password --authenticationDatabase admin --host localhost --port 27017  

> show databases;  
admin   0.000GB  
config  0.000GB  
local   0.000GB  
test    0.000GB  


# Dev setup
# Mongo setup
Connect to mongo and execute the following commands  

> use admin  
switched to db admin  

> db.createUser(  
...   {  
...     user: "root",  
...     pwd: "admin",
...     roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]  
...   }  
... );  
Successfully added user: {  
	"user" : "root",  
	"roles" : [  
		{  
			"role" : "userAdminAnyDatabase",  
			"db" : "admin"  
		}  
	]  
}  

