<!-- ⚠️ This README has been generated from the file(s) "blueprint.md" ⚠️--><p align="center">
  <img src="https://github.com/SpringSecurity-Keycloak/SpringRestReferenceApplication/blob/master/documentation/SpringReferenceAppLogo.png" alt="Logo" width="150" height="auto" />
</p>

<h1 align="center">spring-reference-app</h1>

<p align="center">
		<a href="https://github.com/SpringSecurity-Keycloak/SpringRestReferenceApplication/actions/workflows/build.yml"><img alt="Build" src="https://github.com/SpringSecurity-Keycloak/SpringRestReferenceApplication/actions/workflows/build.yml/badge.svg" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_SpringRestReferenceApplication"><img alt="Coverage" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_SpringRestReferenceApplication&metric=coverage" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_SpringRestReferenceApplication"><img alt="Quality Gate Status" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_SpringRestReferenceApplication&metric=alert_status" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_SpringRestReferenceApplication"><img alt="Reliability Rating" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_SpringRestReferenceApplication&metric=reliability_rating" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_SpringRestReferenceApplication"><img alt="Security Rating" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_SpringRestReferenceApplication&metric=security_rating" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_SpringRestReferenceApplication"><img alt="Vulnerabilities" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_SpringRestReferenceApplication&metric=vulnerabilities" height="20"/></a>
	</p>



[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#tech-stack--tech-stackhttpsimgshieldsiobadge-java-greenstylesociallogojava-tech-stackhttpsimgshieldsiobadge-spring-greenstylesociallogospring-tech-stackhttpsimgshieldsiobadge-githubactions-greenstylesociallogogithubactions-tech-stackhttpsimgshieldsiobadge-circleci-greenstylesociallogocircleci)

## ➤ Tech Stack  ![tech-stack](https://img.shields.io/badge/-Java-green?style=social&logo=Java) ![tech-stack](https://img.shields.io/badge/-Spring-green?style=social&logo=Spring) ![tech-stack](https://img.shields.io/badge/-GithubActions-green?style=social&logo=GitHub+Actions) ![tech-stack](https://img.shields.io/badge/-CircleCI-green?style=social&logo=CircleCI)

A Spring Boot Rest Reference Implementation. The API is secured using OpenId Client Credentials. KeyCloak is the OpenId Connect Identity Provider used to secured the API


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#installing-and-running-this-project)

## ➤ Installing and running this project
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
