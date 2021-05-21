{{ template:logo }}

{{ template:title }}

{{ template:badges }}

## Tech Stack  ![tech-stack](https://img.shields.io/badge/-Java-green?style=social&logo=Java) ![tech-stack](https://img.shields.io/badge/-Spring-green?style=social&logo=Spring) ![tech-stack](https://img.shields.io/badge/-GithubActions-green?style=social&logo=GitHub+Actions) ![tech-stack](https://img.shields.io/badge/-CircleCI-green?style=social&logo=CircleCI)

A Spring Boot Rest Reference Implementation. The API is secured using OpenId Client Credentials. KeyCloak is the OpenId Connect Identity Provider used to secured the API

## Installing and running this project
<details>
  <summary>Accompanying Blog Post</summary>
  <BR>

  The blog post accompanying this repository is available [here](https://www.todaystechnology.org/post/secure-spring-rest-api-using-openid-connect-and-keycloak-part-1)
  
</details>


<details>
  <summary>Run this Spring Boot Application</summary>
  <BR>

  The below command will start the application on port 8080

  ```bash
  mvn spring-boot:run
  ```
  The Swagger UI should be accessed at http://localhost:8080/swagger-ui/#/StudentResource 
</details>
