# borrowed-books-api 

## Usage

### User

1.Register yourself, make sure you have encrypted your password with bcrypt:

```HTTP
POST /api/v1/register
Host: localhost:8080
Content-Type: application/json

{
  "fullname":"Your fullname",
  "email":"youremail@email.com",
  "pass":"$2a$04$53eu67JgpWU9F.jeBOWOquEag/HvW7CVLwS20AAloGengzm716rbu"
}
```

2.Now you can authenticate yourself. API uses OAuth2 protocol:

```HTTP
POST /oauth/token?password=yourpass&username=youremail@email.com&grant_type=password&client_secret=123456&client_id=clientapp
Host: localhost:8080
Authorization: Basic clientapp:123456
Accept: application/json
Content-Type: application/x-www-form-urlencoded
```
A successful authorization results in the following JSON response:
```JSON
{
  "access_token": "db9629be-5c8c-41af-8f7b-626e304c5c92",
  "token_type": "bearer",
  "refresh_token": "6b7bafee-9c70-4b06-8042-85ae8d5443fe",
  "expires_in": 43199,
  "scope": "openid"
}
```

3.Get information about authenticated user:
```HTTP
GET: /api/v1/user/me
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```
A successful results in the following JSON response:
```JSON
{
  "id": 1,
  "fullname": "Your fullname",
  "email": "youremail@email.com",
  "pass": "$2a$04$53eu67JgpWU9F.jeBOWOquEag/HvW7CVLwS20AAloGengzm716rbu",
  "authorities": [
    {
      "id": 1,
      "role": "USER",
      "authority": "USER"
    }
  ],
  "accountNonExpired": true,
  "accountNonLocked": true,
  "credentialsNonExpired": true,
  "enabled": true
}
```
4.If you want to logout:
```HTTP
GET: /api/v1/user/logout
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```
And the following response:
`Successfully logged out`
