```toml
name = 'create'
description = '/bookresponse'
method = 'POST'
url = 'http://localhost:8081/bookresponse?bookId=4'
sortWeight = 1000000
id = '8a38f997-cb2f-4083-96fa-c7599c9947bb'

[[queryParams]]
key = 'bookId'
value = '4'

[body]
type = 'JSON'
raw = '''
{
    "quantity":12
}'''
```
