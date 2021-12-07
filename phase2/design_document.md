# Design Document

- Details about specification, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/specification.md)
- Details about the process report, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/progress_report.md)

## Class Diagram


## Design Decisions


## Usage of Clean Architecture

Many of the changes in Phase 2 were made as a result of fixing Clean Architecture violations. For example, our database was in our Controller layer, and we moved it to the outermost layer, refactoring accordingly. As well, instead of passing Entities to the outer layers, we began passing Strings as data transfer objects, while having the use cases handle the conversion between types. We made sure that the Controller layer was not importing Entities, that the UI was not importing UseCase classes, and of course that no class imports concrete classes located in a more outward layer.

## Usage of SOLID Principles

#### Single Responsibility Principle
In the previous phase, we were told about how there were too many responsibilities given to some classes,
specifically those containing code for Data Persistency. We resolved this by
creating a new class JsonProvider that handles the saving of data. Earlier, this
code was present in the WelcomePage class, which was incorrect, since that class
was related to presenting the user with an opening screen, and not the saving of
files. Further, we added separate classes, such as RequestManager to exclusively
handle requests, as opposed to the umbrella class ServiceController which was used
for this purpose prior. The latter class still exists, however, it’s
responsibilities have been reduced by creating new classes such as RatingManager
and DataPresenter. This was relatively easy to follow in case of entity classes,
due to the fact that each entity by nature is defined to serve a specific purpose.
For instance, User represents a parent for both Farmers and Distributors, and
there is not much confusion on its responsibilities- it needs to store information
common to both subtypes of itself as parameters, as well as have getters and
setters for said parameters. However, in the case of the UseCase and Controller
classes, there was a good bit of difficulty understanding how to implement this
principle, without creating too many classes, or classes with only a single method
or so. By the end, we came to the conclusion of handling user input in the ServiceController
class, Managing Farmer and Distributor Profiles (including their storage) in the
ProfileManager Class, and handling the rankings of users via the RankingManager class.
#### Open/Closed Principle
A key example of this principle is in our DataAccessInterface class, 
which allows for newer methods of Data Persistency such as .csv to be implemented
by simply creating a class which implements the DataAccessInterface with minimal
effort. Currently, we only use the .json file extension for saving data, but this
opens the door to new methods to be added without any hassle or affecting the rest
of the program. In other places, the use of interfaces has ensured the potential
for extension, while preventing the need and possibility of any modifications.
#### Liskov Substitution Principle: 
Initially, there was a lot of confusion regarding the Request, Counteroffer and
Offer classes, as Request and Counteroffer were essentially containing the exact
same methods and parameters, but the difference lay in the fact that a Counteroffer
(as well as an Offer), are in response to a Request.
This meant that although a Request can exist by itself, a Counteroffer and Offer
cannot. Therefore, we were undecided on whether to use the same class to represent
both Request and Counteroffer. After much thinking, we realised that based on the
functionality of our code, a Counteroffer would disobey the Substitution Principle,
as it lacked the complete functionality of a Request despite having several common
variables with it. Therefore, we scrapped the idea of CounterOffer being a subclass
of Request in Phase 2 unlike in Phase 1.
#### Interface Segregation Principle: 
Previously, there were very few interfaces in our code, which meant creating new
classes would involve using a lot of redundant code. Now, not only have we
introduced multiple interfaces, but also role-specific ones. This means that when
one decides to extend our code, they will not be forced to implement redundant
methods. Further, this was also helpful in obeying Clean Architecture Principles,
and greatly improved our overall design methodology and efficiency of future
extension and current code. An example of this would be ProfileInterface and Request
Interface, that allows different types of profiles and requests to be made, with one
needing only to mandatorily implement the methods relevant to all profiles and
requests respectively.
#### Dependency Inversion Principle: 
This was a principle that we were extremely cautious about. To this end, we made an
effort to ensure that our Use Case and Controller classes only referred to classes
immediately below them in the hierarchy. Further, interfaces were created to add
abstraction layers between levels of the code hierarchy as a further precaution.
In fact, this was one of our major priorities in Phase 2, since we realised there
were a few cases of hard dependencies in our Phase 1 code. The addition of interfaces
, as well as getter and setter methods went a long way in resolving this issue,
as well as the conscious avoidance of creating methods that called constructors of
lower-level classes explicitly. Rather, we took in arguments of primitive types or
avoided the dependency by taking the parameter of the class type directly instead
of creating one in the higher-level class.

## Packaging Strategies

Our packaging strategy has remained the same since phase 1: we are packaging by layer. However, to ensure clarity, we separated the Frameworks and Drivers layer into two packages: UI and DataBase. As before, our program isn't separated into clear features, and most classes are used in multiple parts of the program. We have too many 'inside' classes to use the inside/outside packaging strategy, and none of us could think of a logical division into components. It turned out our layers were relatively balanced in phase 2, reinforcing that packaging by layer was the right choice.

## Design Patterns

#### Factory Method

We are using the Factory Method design pattern in creating Users and its subclasses. We delay the instantiation of these concrete products in the profile manager with separate factories, with each creator correlating to a unique class of user product.

#### Template

We are using the Template design pattern in createProfileCheck, a method in our Controller, to define the skeleton of our algorithm for creating users.

#### Memento

We are using the Memento design pattern to allow users to undo modifications made to their profile, and revert to a previous state of their profile.

#### Dependency Injection

We are using Dependency Injection with interfaces for our classes to further depend on abstractions rather than each others' details.
