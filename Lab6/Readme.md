Lab 6 JSF
=========

Point 1:
--------
* I re-wrote the data access layer from Lab 5 - to be enterprise java beans (check the `services.impl` package)
* I used `@EJB` annotation in the JSF Beans - to have the persistance objects automatically injected - please check the `Beans` package
* I made a resource allocation page with two inputs - one for resource name and the other for the exam ID.
* I made 3 beans - check `ejb` package - one that keeps in memory syncronized map with all the resources, another bean that provides functionality to check if a resource is available and the last one that provides functionality for occupying a resource. The last bean is injected in the JSF bean using the `@EJB` annotation. When the user submits a request for occupying a resource - it is called here `ResourceAllocationBean.java`

Point 2:
--------
* At this point - in order to trigger the timer - I made a new page `performance-test.xhtml` in JSF so a new bean called `PerformanceTestBean.java` can in the constructor use the 2 built tasks which are triggered every 10 seconds. This is more of a workaround to ease the testing process. 
* The exam entity was optimized to use second-level cache - and we also optimized the student entity to use named entity graph optimatizion. I did this following the course slides.
* I made an `EJB` interceptor java bean - `PerformanceInterceptor.java` - relied again on the example from the course slides - then I made another 2 beans - `EntityGraph.java` + `SecondLevelCache.java` - and each of these classes contains the `doTest()` method. For each of these classes this method is designed to test the performance optimizations we did to the entities above. Also this `doTest()` method is called in the Scheduled Tasks mentioned above. 
