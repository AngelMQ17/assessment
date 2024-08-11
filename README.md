
# JR BE Assessment

Project developed as an assessment for the Jr. BE Software Engineer position.

## Description
This project is intended to be an account service using REST guidelines. The accounts should be able to be created, find them and transfer money between the accounts following the expected requirements.

## Framework and Dependencies

- Java 21
- Spring Web
- Spring Data JPA
- H2 Database

## How to run
In order to start the service, you can do it running this command line using the wrapper included with the initializer:
```http
  ./mvnw clean spring-boot:run
```

Or using your own installed Maven version:
```http
  mvn clean spring-boot:run
```
Once the service is running the DB is already populated with 2 test accounts, but you can create new ones anyways using the expected endpoint.

### Endpoints to use

- **GET /accounts** - Returns all the accounts
```http
  curl -v GET localhost:8080/accounts
```

- **GET /accounts/{accountId}** - Returns the account details by the given ID
```http
  curl -v GET localhost:8080/accounts/1
```

- **POST /accounts** - Creates a new account
```http
  curl --location --request POST 'localhost:8080/accounts' \
--header 'Content-Type: application/json' \
--data-raw '{
    "accountName": "TEST",
    "accountCurrency": "EUR",
    "accountBalance": 300.00,
    "isTreasuryAccount": true
}'
```

- **PUT /accounts/{accountId}** - Updates an account. If it doesn't exists, it creates it
```http
  curl --location --request POST 'localhost:8080/accounts' \
--header 'Content-Type: application/json' \
--data-raw '{
    "accountName": "TEST",
    "accountCurrency": "EUR",
    "accountBalance": 300.00,
    "isTreasuryAccount": true
}'
```

- **POST /send** - Sends money between the accounts
```http
  curl --location --request POST 'localhost:8080/send' \
--header 'Content-Type: application/json' \
--data-raw '{
    "senderAccountId": 1,
    "receiverAccountId": 2,
    "amount": 10
}'
```


## Running Tests
In order to run the tests, you can do it running this command line:
```http
  mvn test
```

Or using your own Maven instalation:

```http
  ./mvnw test
```

## Things To-do

- Checking our other projects I can see that we should use models and then creating DTOs per request instead of using DTOs directly, but was not completely sure how to implement it here.
- Test for MoneyTransferController is failing, and was not sure how to fix it.