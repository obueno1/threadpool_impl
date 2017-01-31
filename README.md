#Hiring test for FieldLens

##Task
Given a text file containing a list of urls, determine, concurrently, in a pool of 20 threads, whether a search term is contained within the response from HTTP GET per url. Write URL to "results.txt" file if match is found.

##Approach
Implemented Thread Pool design pattern using Java 8 functional features including lamdas and Stream API.

Used Interfaces for URL Read/Write for testing east and modularly/easily adjusting sources and sinks.

##Tools
*Using Guice for dependency iqnjection<br>
*Using Log4J for logging<br>
*Using Apache HttpClient for HTTP GET requests<br>
*Using Java 8 Stream and Concurrency libraries<br>
*Using JUnit for testing<br>

##What's left?

*Improve naming conventions<br>
*Decouple dependencies<br>
*Use Guice more thoroughly for dependency injection<br>
*Improve Testing coverage<br>
*Improve logging configurations<br>
*Include Travis CI configurations for automated unit/integration testing
