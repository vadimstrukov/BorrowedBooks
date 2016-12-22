# borrowed-books-api 

## Usage

### User

* Register yourself, make sure you have encrypted your password with bcrypt:

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

* Now you can authenticate yourself. API uses OAuth2 protocol:

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

* Get information about authenticated user:
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
* If you want to logout:
```HTTP
GET: /api/v1/user/logout
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```
And the following response:
`Successfully logged out`

### Books
* Add book to your library. API uses Google Books API to save original book to database once:
```HTTP
POST: /api/v1/books/owned
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```
with body:

![alt text](https://github.com/vadimstrukov/borrowed-books-api/blob/develop/git_images/add_book.png "Adding book to your library")

* Get your library:
```HTTP
GET: /api/v1/books/owned
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```
Success response:

![alt text](https://github.com/vadimstrukov/borrowed-books-api/blob/develop/git_images/library_response.png "Getting your library")

* Delete book from library: 
```HTTP
DELETE: /api/v1/books/owned?id=bookid
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```

* Update book status: 
```HTTP
PUT: /api/v1/books/owned
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```
with body:

![alt text](https://github.com/vadimstrukov/borrowed-books-api/blob/develop/git_images/add_book.png "Adding book to your library")

* Check if book in library:
```HTTP
GET: /api/v1/books/owned/check?id=bookid
Host: localhost:8080
Authorization: Bearer db9629be-5c8c-41af-8f7b-626e304c5c92
```
Success response:
![alt text](https://github.com/vadimstrukov/borrowed-books-api/blob/develop/git_images/check_book.png)
