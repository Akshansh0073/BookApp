```toml
name = 'create order details'
description = '/orderdetail'
method = 'PUT'
url = 'http://localhost:8081/orderdetail?orderId=91306d99-b40a-4e77-8d89-7435c0d7999f'
sortWeight = 2000000
id = '6002b396-f5f4-4041-b359-9b4fac0f609b'

[[queryParams]]
key = 'orderId'
value = '91306d99-b40a-4e77-8d89-7435c0d7999f'

[body]
type = 'JSON'
raw = '["6766790ba3e1e56863771b24", "676b983cb31342747b5a6111","676d31e5aac40c6166fa6b68"]'
```
