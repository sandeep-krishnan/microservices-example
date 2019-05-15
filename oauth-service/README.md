# Testing 

$ curl -X POST \
  http://localhost:8901/oauth/token \
  -H 'Authorization: Basic dWk6c2VjcmV0' \
  -H 'Postman-Token: 2aebe467-3024-4f8a-9193-aafc16144408' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F grant_type=password \
  -F scope=webclient \
  -F username=root \
  -F password=admin  
  
Response - {"access_token":"ec095f2c-5a7d-4d2f-8071-20a56031803e","token_type":"bearer","refresh_token":"f08ce4af-f51c-46cf-b2d9-397e4f7aada1","expires_in":43051,"scope":"webclient"}ATH032892:microservices-example krsandeep$

Use the above token to access the protected resource  
$ curl -X GET \
  http://localhost:8901/user \
  -H 'Authorization: Bearer ec095f2c-5a7d-4d2f-8071-20a56031803e' \
  -H 'Postman-Token: 45324ce5-4354-4798-918a-a5f9908286a5' \
  -H 'cache-control: no-cache'
  
  