# MonBlog
Une application spring boot pour le backend d'un blog

## 1. Requirements
### 1.1. JAVA 8 or later
Download and install JDK 8 https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
### 1.2. Maven
Download https://maven.apache.org/download.cgi

Install https://maven.apache.org/install.html

## 2. Checkout the project 

https://github.com/FatoumiMahmoud/MonBlog

## 3. Build 

```
cd MonBlogApi
mvn clean install
```

## 4. Run
### 4.1. Using maven
mvn spring-boot:run -Dspring-boot.run.arguments=--init
### 4.2. Using java
```
java -jar target\monblogapi-0.0.1-SNAPSHOT.jar --init
```

## 5. Swagger URL
http://localhost:9080/swagger-ui.html
 