# service-discovery

We will create three microservices for this Netflix Eureka example.

1. **Eureka Service Registry Server** – This microservice will provide the service registry and discovery server.<br>
2. **Student Microservice** – Which will give some functionality based on the Student entity. It will be a rest based service and most importantly it will be a eureka client service, which will talk with eureka service to register itself in the service registry.<br>
3. **School Microservice** – Same type as of Student service – only added feature is that it will invoke Student service with service lookup mechanism. We will not use the absolute URL of student service to interact with that service.<br>

**Test Eureka Server**
Start the application as a spring boot application. Open the browser and go to http://localhost:8761/<br>

**Test Eureka Client**
Start this project as a spring boot application. Now verify that this service has been registered in the Eureka server automatically. Go to the Eureka service console and refresh the page. Now if everything goes well, we will see one entry for **student-service** in the eureka service console. This indicates that both Eureka server and client are aware of each other.<br> We will now verify that the /getStudentDetailsForSchool/{schoolname} endpoint is up and running. Go to the browser and go to http://localhost:8098/getStudentDetailsForSchool/abcschool, it will give the Student details for a particular school abcschool.<br>
Go to the browser and go to http://localhost:9098/getSchoolDetails/abcschool, it will give the school details for a particular school abcschool detail. We have **invoked student service internally**.<br>
 