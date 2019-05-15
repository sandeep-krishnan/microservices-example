# Testing 

curl -X POST \
  http://localhost:8901/oauth/token \
  -H 'Authorization: Basic dWk6c2VjcmV0' \
  -H 'Postman-Token: 2aebe467-3024-4f8a-9193-aafc16144408' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F grant_type=password \
  -F scope=webclient \
  -F username=root \
  -F password=admin
  
