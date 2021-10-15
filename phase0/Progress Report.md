# Progress Report

## Summary

We have completed phase 0 tasks, which includes the CRC cards, scenario walk-through, skeleton program. We have also included the designs/extensions of the program that we will be implementing in the future to expand the functionalities of the program.

### The Specification:

Our project is an interface to connect produce farmers to distribution of their products. Farmers and distributors can make offers to each other to sell and buy produce. The program outputs a list of farmers or distributors which match their selected criteria. They can also choose to see a ranked list based on the users which fit their criteria best.

### CRC Models
All 11 planned classes in our program have a designated CRC model under the `crcCards` folder. The CRC model was constructed before the code to help establish the big picture anticipated in the specification. We specified which classes (RankingSystem, Offer, CounterOffer) and which responsibilities would be part of the project expansion.

### Scenario Walk-through
The use case we have chosen is the first one we have addressed in our skeleton program. The farmer opens the program and is guided through the steps for creating a request to sell a product, then presented with a list of distributors who are willing to automatically accept the request.

### Skeleton Program
The skeleton program contains 8 of the 11 planned classes and is designed to fulfill the use case currently outlined in our walk-through, but allow for easy extension to additional use cases later on. Since profiles cannot be permanently stored yet, we have included some sample distributors who only sell oranges and lemons.


## Open Questions
What do the users want and are they getting what they want from this app?
A farmer might be looking for exposure, good prices, speed, and carbon consciousness. Our app allows farmers to have options such as individuals, farmer's markets, and wholesale companies.
A distributor might be looking for good prices, speed, expansion of their supply chain, and carbon consciousness.
Both might look to expand their network and connect with reliable partners.

Can we continue to maintain the clean architecture structure in future expansions?
Though we have double-checked our classes follow Clean Architecture principles, this will be harder as our program will become more complicated. We may use flowcharts to visualize the interactions between classes, which would greatly help to ensure no classes are violating the Clean Architecture design principles.

Can we continue to follow SOLID design principles?
Our main consideration right now is that RankingSystem might violate the SRP if we design it with too much polymorphism, as Farmers and Distributors will have different ranking criteria.

How will we carry out testing when our program includes classes such as Offer, CounterOffer, and RankingSystem?
Creating different scenarios in order to simulate different situations.


## Worked Well
The CRC cards really helped us to know what to do with our programs. Thus, the distribution of work between the group members was straightforward. All of our members first went to work on their assigned classes (some bigger or very interrelated classes were worked on together with 2 people). This ensured that everyone contributed to the code. After that, we sat down in group meetings to go over each other’s code to resolve errors and clarify naming conventions. This strategy was both effective and inclusive for all of our group members.

## Group member contributions
The Specification, CWalk Throughs, and Progress Reports were done in group meetings with all members present.
The 8 classes in the skeleton program splitted between 7 group members. The first name is the person who designed the class, and those who contributed to the class design are also listed.

1. UserInterface: **Divit** + Onyx
2. ServiceController**:** **Mark** + Onyx + Divit + Andy
3. ProfileManager: **Patrick** + Onyx + Divit
4. MatchManager: **Onyx** 
5. Request - **Jagat** + Andy
6. User - **Andy & Melaney** + Onyx + Divit
7. Farmer - **Andy & Melaney**
8. Distributor - **Andy & Melaney** + Onyx + Patrick

The test cases were done majorly by:

10. UserInterfaceTest: **Onyx**
11. ServiceControllerTest: **Andy** + Onyx
12. ProfileManagerTest: **Onyx**
13. MatchManagerTest: **Onyx**
14. RequestTest: **Andy**
15. UserTest: **Andy**
16. FarmerTest: **Andy**
17. DistributorTest: **Andy**

## Future Plan
We have only implemented 8 out of the 11 planned classes. The rest of the 3 classes were planned for program extensions. With the additional classes, we wish to make our program more user friendly and less prone to errors.
