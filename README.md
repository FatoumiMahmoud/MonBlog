# MonBlog
Une application spring boot pour le backend d'un blog

## Install le back end
### With tests 
```
cd MonBlogApi
mvn clean install
```
### Without tests
```
cd MonBlogApi
mvn clean install -DskipTests
```
## Run backend
### 1. Using maven (require a maven installation)
mvn spring-boot:run -Dspring-boot.run.arguments=--init
### 2. Using java (require JDK 8 or later)
```
java -jar target\monblogapi-0.0.1-SNAPSHOT.jar --init
```

## Test backend
open your default browser
```
http://localhost:9080/api/articles for articles list
http://localhost:9080/api/comments for comments list
```
## TODO swagger url
 