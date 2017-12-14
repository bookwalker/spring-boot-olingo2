Odata Olingo/Spring-Boot example
================================

Uses spring-boot and spring-data-jpa in combination with olingo.

Usage
-----

Requires at least JDK 7.

Run `./gradlew bootrun`

### Accessing the Service

Open the following URLs eg. using the Browser:

- `http://localhost:8080/odata/v2/$metadata`
- `http://localhost:8080/odata/v2/Contacts`
- `http://localhost:8080/odata/v2/Contacts?$filter=startswith(tolower(Name),'John')`

or `curl`

    curl "http://localhost:8080/odata/v2/Contacts?$filter=startswith(tolower(Name),tolower('John'))"

or `Postman` (see `/postman/OData.postman_collection.json`).
