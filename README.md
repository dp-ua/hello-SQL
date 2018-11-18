[![Build Status](https://travis-ci.com/dp-ua/hello-SQL.svg?branch=master)](https://travis-ci.com/dp-ua/hello-SQL)
# Project "Hello SQL"

## What was used in the project: 
* Project builder Maven
* Spring Boot
* Hibernate. MySQL 
* Testing with JUnit
* Using MockitoJUnit

## What need to start Project: 
###  MySQL base. Tuned in application.properties:
* spring.datasource.url=jdbc:mysql://localhost:3306/source  
* spring.datasource.username=user
* spring.datasource.password=password
### Accepted URLs:
* /hello/contacts?nameFilter=""
* /hello/add

The filter uses regular expressions and if you get an error about forbidden characters - they need to be encoded.
You can do this on this site: https://meyerweb.com/eric/tools/dencoder/
