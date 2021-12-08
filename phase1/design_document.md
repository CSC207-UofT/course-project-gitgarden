# Design Document

- Details about specification, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/working_main/phase1/specification.md)
- Details about the process report, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/working_main/phase1/progress_report.md)

## Class Diagram

![java](https://github.com/CSC207-UofT/course-project-gitgarden/blob/working_main/phase1/diagram.png)

- Blue solid lines with triangular arrow represent *inheritance*
- Red doted lines with triangular arrow represent *implementation*
- Dark blue solid lines with parallelogram arrows represent *compositions*
- Solid line with arrow signs represent *associations*
- Doted lines with arrow signs represent *dependency*

> - For detailed legend for the diagram, please refer to this [picture](https://en.wikipedia.org/wiki/Class_diagram#/media/File:Uml_classes_en.svg)
> - More details for the backend classes can be seen under [crcCards](https://github.com/CSC207-UofT/course-project-gitgarden/blob/working_main/crcCards.md) document (the crcCards does not include the classes for the GUI)



## Design Decisions

We decided to use `json` files to keep the data persistency of our code. This is because after some research on data persistency, `json` is the most intuitive method to carry out this task. We chose `Gson` because the examples and code are easy to understand and it does the job as expected.

Next, in the beginning, we were going to use the application [Vaadin](https://vaadin.com/start) to create our user interface, but there were way too many files in the starter’s code and we would have to go through a lot of dependency files to everything from our repo. After switching to GUI, things became much easier to work with.



## Usage of Clean Architecture

The entities we have are `Distributor`, `Farmer`, `Offer`, `Request`, `User`, and `RequestStructure`. `Distributor` and `Farmer` extends the `User` class, while `Offer` and `Request` implements the `RequestStructure`. All of the entities do not have dependencies pointed outwards.

The use cases are `MatchManager`, `ProfileInterface`, `ProfileManager`, `RankingManager`, and `RankInterface`. `MatchManager` interacts with `Distributor`; `ProfileManager` interacts with `Distributor`; `ProfileInterface` interacts with `User`; `RankingManager` interacts with `Farmer` and `Distributor`. All of the use cases have dependencies pointed inwards to Entities. And it contains application specific rules. For example, `ProfileManager` which will create a profile of the user interacting with Entities. Or, `RankingManager` which will rank the distributors based on the farmers’ preferences.

The Controller is the `ServiceController`, which interacts with `MatchManger` and `ProfileManager`. Both Managers are the use cases, therefore the `ServiceController` also has dependencies point inwards. It converts the data from Client.UI so that it can match the requirements in use cases(which points to entities). Our data persistency is also included in this layer as it stores our data in `json` files/reads the `json` files and converts them to java format. However, this should be moved to the outmost layer with Client.UI following the clean architecture in the upcoming phase 2.

The Client.UI is the outermost layer of the program, which contains `UserInterface`. It takes input from the client and has code dependencies pointed inwards to the `ServiceController`. 

In general, our code followed most of the Clean Architecture principles so far and the only problem with Clean Architecture is found and placed as the top priority in phase 2.



## Usage of SOLID Principles

#### Single Responsibility Principle

This was relatively easy to follow in case of entity classes, due to the fact that each entity by nature is defined to serve a specific purpose. For instance, User represents a parent for both Farmers and Distributors, and there is not much confusion on its responsibilities- it needs to store information common to both subtypes of itself as parameters, as well as have getters and setters for said parameters. However, in the case of the `UseCase` and Controller classes, there was a good bit of difficulty understanding how to implement this principle, without creating too many classes, or classes with only a single method or so. By the end, we came to the conclusion of handling user input in the Service Controller class, Managing Farmer and Distributor Profiles (including their storage) in the `ProfileManager` Class, and handling the rankings of users via the `RankingManager` class.

#### Open/Closed Principle

Among the SOLID principles, this was the one that was least discussed, but also the one most implemented subconsciously. Unfortunately, as our Phase 0 code was made to display a simple CLI for proof of concept, the addition of a GUI in Phase 1 meant that much of the user interface code had to be reorganized and rewritten to match the new system. However, this should no longer be an issue as future additions in Phase 2  were kept in mind when making the new interface, and our code shall be extendable from Phase 1 onwards.

#### Liskov Substitution Principle: 

Initially, there was a lot of confusion regarding the Request, Counteroffer and Offer classes, as Request and Counteroffer were essentially containing the exact same methods and parameters, but the difference lay in the fact that a Counteroffer (as well as an Offer), are in response to a Request. This meant that although a Request can exist by itself, a Counteroffer and Offer cannot. Therefore, we were undecided on whether to use the same class to represent both Request and Counteroffer. After much thinking, we realised that based on the functionality of our code, a Counteroffer could in fact use the same class as Request, and there was no danger of disobeying the Liskov Principle due to a tree-like visualisation of our code. A Request instance on the top of the tree would be considered a Request, while all the leaves and subtrees which were also Request instances would be in turn Counteroffers to the parent Request instance.

#### Interface Segregation Principle: 

While we were not able to implement an individual interface for each class to communicate between layers, we started doing so in the use case layer, as a prototype. Next time, we will fully implement all the required interfaces so that all method calls are made through interfaces, as opposed to directly made to a class.

#### Dependency Inversion Principle: 

This was a principle that we were extremely cautious about, and we made an effort to ensure that our Use Case and Controller classes only referred to classes immediately below them in the hierarchy. Further, interfaces were created to add abstraction layers between levels of the code hierarchy as a further precaution.



## Packaging Strategies

We used the by layer strategy because we don’t really have specific classes that are implemented just for specific features. The reason why we are not using the inside outside packaging strategy is because we have too many classes for inside, and it would be hard to locate files and lose the point of packaging. We can’t be using component strategy because there is not a logical way that we can group our files since all of our use cases use all of our entities and we have only one controller. Therefore, the best strategy is to just package by layer.



## Design Patterns

#### Factory Method

We are using the concept of factory method in creating users and its subclass. We attempt to delay the instantiation of these concrete products in the profile manager with separate factories, with each creator correlates to a unique class of user product.

#### Composite

We are using the Composite design pattern to implement a recursive structure in our code. Requests can contain other Requests, or contain an Offer. The Offer class is the leaf class in this structure, and we terminate the recursion once we get to an offer. This structure matched what the pattern is used to facilitate. 
