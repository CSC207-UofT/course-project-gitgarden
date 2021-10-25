# Request

- Name: `Request`
- Parent Class: None
- *Entity*

| Responsibility                                                                                                 | Collaborators                                                                                 |
| ------------------------------------------------------------                                                   | ------------------------------------------------------------                                  |
| 1. Store farmer identification <br/> 2. Store product transferral specifics <br/> 3. Store instances of offers | [`MatchManager`](#MatchManager) <br/> [`Offer`](#Offer) <br/> [`CounterOffer`](#CounterOffer) |

# ServiceController

- Name: `ServiceController`
- Parent Class: None
- *Interface Adapter*

| Responsibility                                                                                                                                                                               | Collaborators                                                                                                    |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|
| 1. Accept or decline inputs from UserInterface <br/> 2. Make variables for ProfileManager and MatchManager if the input is acceptable <br/> 3. Report exception if the input is unacceptable | [`MatchManager`](#MatchManager) <br/> [`ProfileManager`](ProfileManager) <br/> [`UserInterface`](#UserInterface) |


# Offer

- Name: `Offer`
- Parent Class: None
- *Entity*

| Responsibility                                                                                  | Collaborators                                                                                     |
|-------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| 1. Store the distributor’s identification <br/> 2. Store identification of the original request | [`MatchManager`](#MatchManager) <br/> [`Request`](#Request) <br/> [`CounterOffer`](#CounterOffer) |


# CounterOffer

- Name: `CounterOffer`
- Parent Class: [`Offer`](#Offer)
- *Entity*

| Responsibility                                                                                                               | Collaborators                                                                       |
|------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| 1. Store the previous offer identification <br/> 2. Store the request identification <br/> 3. Store counteroffer information | [`MatchManager`](#MatchManager) <br/> [`Request`](#Request) <br/> [`Offer`](#Offer) |

# MatchManager

- Name: `MatchManager`
- Parent Class: None
- *Use Case*

| Responsibility                                                                                                                                                                                                                                                                                | Collaborators                                                                                                                                                                                                                                             |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1.Takes input of a single request <br/> 2. Return a list of recommended distributors, based on the given farmer's preferences <br/> 3. Receive distributor info and output a list of recommended farmers [expansion] <br/> 4. Create offer using distributor's information [expansion] | [`Farmer`](#Farmer) <br/> [`Distributor`](#Distributor) <br/> [`RankingManager`](#RankingManager) <br/> [`ProfileManager`](#ProfileManager) <br/> [`Request`](#Request) <br/> [`Offer`](#Offer) <br/> [`ServiceController`](#ServiceController) |


# ProfileManager

- Name: `ProfileManager`
- Parent Class: None
- *Use Case*

| Responsibility                                                                                                                                                           | Collaborators                                                                                           |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| 1. Take variables from ServiceController <br/> 2. Create Farmer/Distributor based on the given variables <br/> 3. Modify Farmer/Distributor based on the given variables | [`ServiceController`](#ServiceController) <br/> [`Farmer`](#Farmer) <br/> [`Distributor`](#Distributor) |


# User

- Name: `User`
- Parent Class: None
- *Entity*

| Responsibility                                   | Collaborators                                                                                      |
|--------------------------------------------------|----------------------------------------------------------------------------------------------------|
| 1. Stores name, address, identification, summary | [`ProfileManager`](#ProfileManager) <br/> [`Farmer`](#Farmer)  <br/> [`Distributor`](#Distributor) |


# Distributor

- Name: `Distributor`
- Parent Class: [`User`](#User)
- *Entity*

| Responsibility                                                                 | Collaborators                                                             |
|--------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| 1. Store distributor’s list of offers <br/> 2. Store distributor’s preferences | [`MatchManager`](#MatchManager) <br/> [`ProfileManager`](#ProfileManager) |


# Farmer

- Name: `Farmer`
- Parent Class: [`User`](#User)
- *User*

| Responsibility                                                                      | Collaborators                                                             |
|-------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| 1. Stores farmer’s list of requests <br/> 2. Store farmer's preferences [expansion] | [`MatchManager`](#MatchManager) <br/> [`ProfileManager`](#ProfileManager) |


# UserInterface
- Class name: `UserInterface`
- Parent class: None
- *UI*

| Responsibilities                                                                                                                                                                                                                  | Collaborators                             |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| 1. Display an interface to interact with the program  <br/> 2. Display results if valid information is entered  <br/> 3. Display exception if invalid information is entered  <br/> 4. Pass inputs to ServiceController | [`ServiceController`](#ServiceController) |


# RankingManager
- Class name: `RankingManager` [expansion]
- Parent Class: None
- *Use Case*

| Responsibilities                                                                                                                                           | Collaborators                                                                                 |
| ---                                                                                                                                                        | ---                                                                                           |
| 1. Rank a set of distributors based on preferences of a particular farmer  <br/> 2. Rank a set of farmers based on preferences of a particular distributor | [`Farmer`](#Farmer) <br/> [`Distributor`](#Distributor) <br/> [`MatchManager`](#MatchManager) |
