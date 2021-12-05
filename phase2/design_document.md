# Design Document

- Details about specification, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/specification.md)
- Details about the process report, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/progress_report.md)

## Class Diagram


## Design Decisions


## Usage of Clean Architecture


## Usage of SOLID Principles

#### Single Responsibility Principle
In the previous phase, we were told about how there were too many responsibilities given to some classes, specifically those containing code for Data Persistency. We resolved this by creating a new class JsonProvider that handles the saving of data. Earlier, this code was present in the WelcomePage class, which was incorrect, since that class was related to presenting the user with an opening screen, and not the saving of files.

#### Open/Closed Principle

#### Liskov Substitution Principle: 

#### Interface Segregation Principle: 

#### Dependency Inversion Principle: 


## Packaging Strategies


## Design Patterns

#### Factory Method

We are using the concept of factory method in creating users and its subclass. We attempt to delay the instantiation of these concrete products in the profile manager with separate factories, with each creator correlates to a unique class of user product.

#### Composite

We are using the Composite design pattern to implement a recursive structure in our code. Requests can contain other Requests, or contain an Offer. The Offer class is the leaf class in this structure, and we terminate the recursion once we get to an offer. This structure matched what the pattern is used to facilitate. 
