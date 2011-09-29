#Project Info
TGIRest facilitates documentation of a JAX-RS REST API. Eventually it should encourage development that meets the hypermedia constraint (HATEOAS).

The library provides annotations that make it easy to describe your restful resources. Having a means to do this directly in the code means one less excuse for complete and useful documentation. Because the implementation and the meta data are right next to each other, maintenance should be easy as well.

##Dependencies
The number of dependencies are kept to a minimum so integration with existing an API is easy (hopefully). TGIRest relies on JSR-311 which provides JAX-RS interfaces and SLF4J for logging. There are other dependencies but those fall under the test scope.

##Background
This project started after I spent a lot of time trying to document a Java based REST API I built at work. I recently stumbled on Swagger/Klout and found it to be a good start but spent too much time trying to integrate. Eventually I did finish but came away with some motivations to create my own library.

##Goals
1. The server side component should have minimal dependencies.
    * It should not be a mix of JVM languages. Sticking with one - Java - will make it easier for users to understand.
    * Developers should be able to use the library with any JAX-RS implementation (Resteasy, Jersey, etc).

2. The server side component should "just work".
    * It should minimize collisions with already defined URIs.
    * It should be easy for developers to extend with their own annotations.
    * It should have some tests to make the second point

##Extra
There is a good 37signals blog post regarding API documentation. Check it out! http://37signals.com/svn/posts/3018-api-design-for-humans