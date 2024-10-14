**Coupling** means the way two classes interact with each other.
There are two type of coupling:
        1.Tight Coupling
        2. Loose Coupling

***Tight Coupling***
You’ve identified a common scenario in software design where tight coupling among classes can lead to challenges when changes are needed. Let’s briefly summarize the implications of tight coupling and offer some suggestions for improving the design, often referred to as promoting loose coupling.

**Tight Coupling Implications**:

**Pros**:

**Fast Coding**: As you mentioned, tight coupling can lead to faster initial development since you don't need to set up interfaces or abstractions between classes. Everything is directly connected and straightforward to implement.

**Cons**:

**Fragility**: If one class changes (like needing to fetch data from a web service instead of a database), you may need to modify multiple classes, increasing the risk of introducing bugs.

**Difficult Testing**: Each class depends on the implementation details of the others, making it tricky to test classes in isolation.

**Example Scenario**:
Given your example with three classes: Client, Service, and DatabaseSql, here's how they are tightly coupled:

Client has a direct object of Service.
Service has a direct object of DatabaseSql.

***Loose Coupling***

**Steps to Achieve Loose Coupling**

**1. Define a Contract (Interface**):
Create an interface that outlines the methods required to fetch data. This serves as a contract between the data fetching mechanism and the service provider.

**2. Use Dependency Injection in the Service Class:**
Rather than instantiating the data source directly in the service class, take the data source as a parameter in the constructor (or a setter), allowing for flexibility with different implementations.

**3. Use the Client to Provide Data Source Implementations:**
In the client class, create instances of the data source implementations and pass them to the service class using the interface. You may not need to typecast explicitly if you are already using the interface type.

