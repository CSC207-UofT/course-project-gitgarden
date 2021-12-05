# Design Document

- Details about specification, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/specification.md)
- Details about the process report, please view this [file](https://github.com/CSC207-UofT/course-project-gitgarden/blob/main/phase2/progress_report.md)

## Class Diagram


## Design Decisions


## Usage of Clean Architecture


## Usage of SOLID Principles

#### Single Responsibility Principle

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
