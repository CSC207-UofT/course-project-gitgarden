# Progress Report

## Summary of Member Contributions
- User Interface: Patrick + Melaney
- Data Persistency: Mark + Divit
- Backend Refactor: Onyx
- RatingStructure: Andy
- Memento: Jagat
- Testing: Andy + Onyx

The User Interface has been worked on by **Patrick** and **Melaney**. 
**Patrick** has been working more on updating the UI to connect with the new Phase
2 code, whereas **Melaney** has been implementing new UI features, such as Dark Mode.

We had a substantial amount of refactoring to do with regards to data persistency,
due to a Clean Architecture error in Phase 1 where the data access was placed in the
wrong layer. **Divit** reworked the data access code and connected it to the initial Phase
2 code which had significant differences in structure owing to Clean Architecture
changes. **Mark** updated the database and data access reflect the changes made
later in Phase 2.

There was also substantial refactoring to do in the backend, mostly with regards to
fixing Clean Architecture violations such as passing entities in our Controller.
This refactoring was completed by **Onyx**. Improvements for a more realistic
program (such as a way to trash requests) had to be implemented in the UI as well as
in the use cases/presenter/controller, resulting in heavy collaboration with the UI
team.

One new feature we decided to implement was a rating system for distributors.
The goal was to have farmers be able to rate distributors according to how 
satisfactory the transaction was. This was implemented by **Andy**.

Another new feature we decided to implement was a Memento design pattern
allowing profile modifications to be undone. This was implemented by **Jagat**.

We modified our tests and expanded them to include more cases.
This was done by **Andy and Onyx**.

## Notable Pull Requests by Each Group Member
- onyxc: Phase2 grand refactoring (https://github.com/CSC207-UofT/course-project-gitgarden/pull/22) and Working phase2 (https://github.com/CSC207-UofT/course-project-gitgarden/pull/42)

  The first pull request formed the basis of our phase2 backend, fixing many of the Clean Architecture violations that had occurred over the course of phase 1. The second pull request was a large number of bugfix commits by the end of which the program was functional.

- DivitSingh: Persistency (https://github.com/CSC207-UofT/course-project-gitgarden/pull/17)

  Introduced the ability to save user profiles, as well as request details. This was a huge step forward in our application, as we could now test our request and counteroffer system, and made the code compatible with the JavaSwing GUI.