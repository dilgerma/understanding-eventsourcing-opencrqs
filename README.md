## Understanding Eventsourcing - The Book

This is the sample project for the Book "Understanding Eventsourcing"

[Buy the book on Leanpub](https://leanpub.com/eventmodeling-and-eventsourcing)

Want to learn Event Modeling, Event Sourcing and slice-based Architectures in a practical way?
Join the Online Course [Implementing Eventsourcing](https://www.eventsourcingcourse.com)

This implementation is using:
- [OpenCQRS](https://www.opencqrs.com)
- [EventSourcingDB](https://www.thenativeweb.io/products/eventsourcingdb)

The first book to combine Eventmodeling, Eventsourcing to plan and build Software Systems of any size and complexity.

The Eventmodel is here:

[Eventmodel in Miro](https://miro.com/app/board/uXjVKvTN_NQ=/)

If you want to quickly learn about Eventmodeling, here is the original article:

[The original Eventmodeling Article](https://eventmodeling.org/posts/what-is-event-modeling/)

By subscribing to the newsletter you´ll get access to the "little" Eventmodeling Handbook, which can serve as a quick reference in addition to the book.

[The Little Eventmodeling Book](https://newsletter.nebulit.de/)

### Book

The Github Repository for the original implementation including all source code can be found here:
[Github](https://github.com/dilgerma/eventsourcing-book)

### Sample Application

The sample application is written in Kotlin / Spring / OpenCQRS

[Kotlin](https://kotlinlang.org/)
[Spring](https://spring.io/projects/spring-framework)
[OpenCQRS](https://www.opencqrs.com)
[EventSourcingDB](https://www.thenativeweb.io/products/eventsourcingdb)

You need to have Docker installed.

[Docker](https://www.docker.com/)

Here are the simple steps to start the application in a development environment.

- install IntelliJ IDEA

- Install the most recent Java SDK (File -> Project -> SDK)

- In the terminal type 'mvn clean install', this will do a full maven install of all the dependencies. You can do the same in IntelliJ as well.

- Ensure you have docker running (if you don't already have it installed on your machine, you need it for testcontainers to work. on Windows just install the docker desktop app).

- Build the app

Start the app by right-cicking on the ["ApplicationStarter"](https://github.com/dilgerma/eventsourcing-book/blob/main/src/test/kotlin/de/eventsourcingbook/cart/ApplicationStarter.kt) in src/test/kotlin and klick run.
This will start the whole application including all dependencies.

The App will start a PostgresDB and an EventSourcingDB.

Access the EventSourcingDB at http://localhost:3000
The App is running on port 8080.

### Code Generation

The source code in the book was mostly generated directly from the Event Model. If you want to see this process in action, I can highly
recommend this E-Mail Course that spans 8 days currently and guides you through the process of creating your own custom Code Generator.

[E-Mail Course](https://newsletter.nebulit.de/generator)
