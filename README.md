##Hiring test for FieldLens

#Task
Given a text file containing a list of urls, determine, concurrently, in a pool of 20 threads, whether a search term is contained by the response from HTTP GET per url.

#Approach
Implemented Thread Pool design pattern using Java 8 functional features including lamdas and stream api

Used Interfaces for URL Read/Write for testing east and modularly/easily adjusting sources and sinks.

#Tools
Using Guice for dependency iqnjection
Using Log4J for logging
Using Apache HttpClient for HTTP GET requests
Using Java 8 Stream and Concurrency libraries
Using JUnit for testing

##What's left?

Improve naming conventions.
Decouple dependencies.
Use Guice more thoroughly for dependency injection.
Improve logging configurations.
Add Travis CI configurations.
