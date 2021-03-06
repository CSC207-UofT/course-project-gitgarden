# CounterOffer

- Name: `CounterOffer`
- <u>Entity</u>
- Parent Class: `Offer`

| Responsibility                                                                                                   | Collaborators               |
|------------------------------------------------------------------------------------------------------------------|-----------------------------|
| 1. Store the previous offer identification <br /> 2. Store the request identification <br /> 3. Store counteroffer information | MatchManager <br /> Request <br /> Offer |


# Request

- `Request`
- <u>Entity</u>
- Parent Class: None

| Responsibility                      | Collaborators |
|-------------------------------------|---------------|
| Store farmer identification         | MatchManager  |
| Store product transferral specifics | CounterOffer  |
| Store instances of offers           | Offer         |


# Distributor

- `Distributor`
- <u>Entity</u>
- Parent Class: `User`

| Responsibility                     | Collaborators  |
|------------------------------------|----------------|
| Store distributor’s list of offers | MatchManager   |
| Store distributor’s preferences    | ProfileManager |


# Farmer

- `Farmer`
- <u>User</u>
- Parent Class: `User`

| Responsibility                         | Collaborators  |
|----------------------------------------|----------------|
| Stores farmer’s list of requests       | MatchManager   |
| Store farmer's preferences [expansion] | ProfileManager |


# ServiceController

- `ServiceController`
- <u>Interface Adapter</u>
- Parent Class: None
 
| Responsibility                                                                | Collaborators  |
|-------------------------------------------------------------------------------|----------------|
| Accept or decline inputs from UserInterface                                   | MatchManager   |
| Make variables for ProfileManager and MatchManager if the input is acceptable | ProfileManager |
| Report exception if the input is unacceptable                                 | UserInterface  |
