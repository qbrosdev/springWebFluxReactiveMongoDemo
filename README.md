# springWebFluxReactiveMongoDemo

Demo project, using Spring WebFlux (spring which supports reactive APIs).
WebFlux allows developing reactive APIs which let the application server to run using less number of threads (in the application server). In this approach, the threads are non-blocking.
To prevent breaking the non-blocking feature, all the layers of the application (API, service, persistence) should be non-blocking.

The reactiveMongoDB, repository implementation, provides non-blocking reactive persistence layer.

Technology stack:
* Spring WebFlux
* MongoDB
* Spring Data (Reactive mongo)

> Note: Spring does not support in-memory Mongo-Db but there is a maven dependency which will download an image of MongoDB on each run.
Link: https://stackoverflow.com/a/31568654/3593084
