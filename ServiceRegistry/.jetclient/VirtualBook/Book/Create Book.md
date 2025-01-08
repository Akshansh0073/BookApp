```toml
name = 'Create Book'
description = '/books/category/3'
method = 'POST'
url = 'http://localhost:8082/books/category/3'
sortWeight = 1000000
id = '3cbaa222-0aa2-41d7-94a2-d9000129b2c0'

[body]
type = 'JSON'
raw = '''
{
    "title":"Fundamental of atomic structure",
    "author":"akshansh",
    "price":300.0,
    "stock":100


}'''
```
