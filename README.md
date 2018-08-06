# Support Wheel of Fate

A REST API to generate schedule that shows whose turn is it to support the business by selecting two engineers at random to both complete a half day of support (shift) each.

Rules
- An engineer can do at most one half day shift in a day.
- An engineer cannot have half day shifts on consecutive days.
- Each engineer should have completed one whole day of support in any 2 week period.

Application demo link: http://45.76.152.208:8082/

## Description

### Technology Stack
- Java 8
- Spring Boot 1.5.7
- SpringFramework Cloud
- H2 Database 1.4.x
- AWS Lambda

### Application
Application structure is based on Controller -> Service -> Repository pattern. An in-memory database is used and sample data is preloaded from 'data.sql' file in classpath on application start.

### UI View
A simple web page with Bootstrap and jQuery is used to call the REST API and display the return data. Spring thymeleaf is used for server-side rendering of the page. 

### Cloud
Spring Cloud Function is used to support serverless providers. Only AWS Lambda handler is implemented in this project.


Note: Lombok Project is used for POJO classes. For IDE setup follow https://projectlombok.org/setup/overview

## REST API

URI: /schedule/generate  
Method: POST
  
Request Header  
	Content-Type: application/x-www-form-urlencoded  
Request Body  
	Parameter Name: startDate    
	Possible value: Date in format 'yyyy-MM-dd'    
	Example: startDate=2018-03-26  
  
Response Header  
	Content-Type: application/json  
Response Body  
	Schedule object    
	
## Build and Run

Maven is used for dependencies and project build.

To build the project run following maven command   
`mvn clean package`  

Exceute following command to run the application  
`mvn spring-boot:run`  

Open the following URL in browser  
`localhost:8081/`  

Note: The default port set for this application is 8081 in application.properties file. Web server in the application will start on port 8081

## AWS Lambda

- Application is deployed on AWS Lambda as a Function.
- AWS API Gateway is used to execute the function

API URL: [URL will be provided separately]  
Method: POST  
Request:  
	Content-Type: application/json  
	Body:  
		{  
			"startDate":"2018-03-26"  
		}  
Response:  
	Content-Type: application/json  
	Body: Schedule object  

	