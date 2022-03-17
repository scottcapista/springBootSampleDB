# stableAPI

## Supported versions:
- Java 8 to 17
- MongoDB server 5.0 and up
- MongoDB Java Driver 4.4.1
- Maven 3.8.4

## Quick Start 
1. Start a local MongoDB instance.  If you have yet to install Mongo on your machine use the following [instructions](https://docs.mongodb.com/guides/server/install/).
2. Clone this repo<br>
    <code>git clone https://github.com/scottcapista/stableAPI.git</code>
3. Move to project directory<br>
    <code>cd stableAPI</code>
4. Start the spring boot application.  Server will start on localhost:8081.<br>
    <code>mvn spring-boot:run</code>
5. Use Postman by importing the below link as a collection. 
    https://www.getpostman.com/collections/9ff71190f9ebb13add48

## Results
Stable API has to be defined when instantiating the java driver so that connections established from the client are in the pool of active connections.  This can not be overridden at the time of performing a CRUD operation so any customer using the stable API will have to instantiate two client instances with seperate connection pools.

```text
2022-02-08 18:23:06.188  INFO 36756 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2022-02-08 18:23:06.192  INFO 36756 --- [           main] c.m.c.p.s.StableApiV2Application         : Started StableApiV2Application in 1.022 seconds (JVM running for 1.157)
2022-02-08 18:23:06.210  INFO 36756 --- [           main] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:5, serverValue:107}] to localhost:27017
2022-02-08 18:23:17.249  INFO 36756 --- [nio-8081-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-02-08 18:23:17.249  INFO 36756 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-02-08 18:23:17.250  INFO 36756 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2022-02-08 18:23:17.266  INFO 36756 --- [nio-8081-exec-1] c.m.c.p.s.c.PersonRestController         : Using Default Driver API
2022-02-08 18:23:22.736  INFO 36756 --- [nio-8081-exec-3] c.m.c.p.s.c.PersonRestController         : Using Stable Driver API
2022-02-08 18:23:22.743  INFO 36756 --- [nio-8081-exec-3] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:6, serverValue:108}] to localhost:27017
```

The log above shows that the driver is establishing a seperate connection pool for both the Default Driver and Stable API.
