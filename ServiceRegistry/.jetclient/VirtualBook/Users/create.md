```toml
name = 'create'
description = '/users'
method = 'POST'
url = 'http://localhost:8082/users/'
sortWeight = 1000000
id = '58fe107d-686d-4f7d-8d2d-26eaef1d5fe4'

[body]
type = 'JSON'
raw = '''
{
    "name":"Sachin tendulkar",
    "email":"sachin@gmail.com",
    "password":"abcd",
    "address": {
    "street":"Street no. 542",
    "city":"Mumbai",
    "state":"Maharashtra",
    "postalCode":"324513"
    }
}'''
```
