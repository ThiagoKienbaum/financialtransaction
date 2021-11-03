![GitHub](https://img.shields.io/github/license/ThiagoKienbaum/financialtransaction)
![GitHub last commit](https://img.shields.io/github/last-commit/ThiagoKienbaum/financialtransaction)
![GitHub language count](https://img.shields.io/github/languages/count/ThiagoKienbaum/financialtransaction)
![GitHub top language](https://img.shields.io/github/languages/top/ThiagoKienbaum/financialtransaction)


![GitHub followers](https://img.shields.io/github/followers/ThiagoKienbaum?label=Follow&style=social)
![GitHub stars](https://img.shields.io/github/stars/ThiagoKienbaum/financialtransaction?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/ThiagoKienbaum/financialtransaction?style=social)
![GitHub forks](https://img.shields.io/github/forks/ThiagoKienbaum/financialtransaction?style=social)


# Financial Transaction

## Getting started
First you will need to install `grails 2.5.6` and `docker`

## Development setup

```shell
git clone https://github.com/ThiagoKienbaum/financialtransaction.git 
cd financialtransaction

docker run -t -i -p 3306:3306 --name dockermysqldb -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.20
docker exec -it dockermysqldb /bin/bash

mysql -h localhost -u root -p
root

CREATE DATABASE financialtransaction;
exit
exit

grails compile
grails run-app
``` 

## Usage guide

### Create account
`POST: /financialtransaction/api/account`

Request Body:
```json
{ 
  "document_number": "12345678908" 
}
```

Response Body
```json
{
    "account_id": 0,
    "document_number": "12345678908"
}
```

### Retrieve account information
`GET: /financialtransaction/api/account/:accountId`

Response Body:
```json
{
  "account_id": 0,
  "document_number": "12345678908"
}
```

### Create a transaction
`POST: /financialtransaction/api/transaction`

Request Body:
```json
{
  "account_id": 0,
  "operation_type_id": 4,
  "amount": 50.00
}
```

Response Body:
```json
{
    "transaction_id": 0,
    "account_id": 0,
    "operation_type_id": 3,
    "amount": -50.0,
    "event_date": "2021-01-01T23:59:59Z"
}
```

## Meta

Thiago Kienbaum – [LinkedIn](https://www.linkedin.com/in/thiago-kienbaum/) – thiago.kienbaum@hotmail.com
