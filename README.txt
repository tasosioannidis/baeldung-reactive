This sample project provides an API which returns a stream of "person" objects.

Two ways are used concerning the REST interface:
- The usual RestController
- RouterFunctions functionality

Calling:
http://localhost:8080/router/people/stream
http://localhost:8080/people/stream

will print one person object every second on browser page, for 40 total objects.