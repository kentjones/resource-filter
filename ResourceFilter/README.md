ForgeRock Developer Programming Exercise
==============

	I created three test packages: com.kent.jones.atomic, ..factory, and ..service
		1. The atomic package is used to test the predicates individually. To run all the test, run "RunAtomicTests.java".
		2. The factory package is used to test the Filter Factory. To run all the tests, run "RunFactoryTests.java"
		3. The service package is used to test the API. There are two test types, Filtering by user and Filtering by Resource. 
			* All the tasked are complete for Filtering by user except for c.v and 4. Those tasked are done in Filtering by Resource
			* I only completed tasks c.2, c.v and 4 in Filtering by resources. The other tasks were completed in Filtering by users. 
			
I realized after reading the requirements for the third time that the API should be able to filter on a Map and not just User. That is why I have two implemenations of Filter by.      

 


Work Workflow
========


To exercise the API you should run the Test Suit "RunServiceTests." 




Background:
========

An application manages access to “resource” objects (e.g a user) and we need to provide a Java API for querying the set of
available resources. One of the requirements for the query API is to have filtering functionality allowing clients to select
resources which match certain criteria. For the sake of simplicity, a “resource” is represented using a Map<String,String>
which maps “property” names (keys) to their values. Property names are case sensitive, but property values are not.

