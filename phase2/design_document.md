# Design Document

- Details about specification, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/specification.md)
- Details about the process report, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/progress_report.md)

## Class Diagram


## Design Decisions


## Usage of Clean Architecture


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
opens the door to new methods
#### Liskov Substitution Principle: 

#### Interface Segregation Principle: 

#### Dependency Inversion Principle: 


## Packaging Strategies


## Design Patterns

#### Factory Method

We are using the concept of factory method in creating users and its subclass. We attempt to delay the instantiation of these concrete products in the profile manager with separate factories, with each creator correlates to a unique class of user product.

#### Composite

We are using the Composite design pattern to implement a recursive structure in our code. Requests can contain other Requests, or contain an Offer. The Offer class is the leaf class in this structure, and we terminate the recursion once we get to an offer. This structure matched what the pattern is used to facilitate. 
