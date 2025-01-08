```toml
name = 'update user'
description = '/users/dfc4fef1-e2fa-4bbc-a7cd-624831555ab4'
method = 'PUT'
url = 'http://localhost:8082/users/dfc4fef1-e2fa-4bbc-a7cd-624831555ab4'
sortWeight = 4000000
id = '3687a6ee-f602-44cf-abb6-865246e33fa5'

[body]
type = 'JSON'
raw = '''
{
    "name":"Kirti Sharma",
    "email":"kirti@gmail.com",
    "password":"abcd",
    "address": {
    "street":"Street no. 12345",
    "city":"Haridwar",
    "state":"Uttarakhand",
    "postalCode":"324513"
    }
}'''
```
