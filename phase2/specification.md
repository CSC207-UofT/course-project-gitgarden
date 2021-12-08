# Specification

## Introduction

Our project is a medium for connecting produce farmers to distributors of their products. The target audiences are farmers and distributors looking to expand their network. The farmers and distributors indicate the prices and quantities of the produce they are willing to sell and buy, respectively.

While running, the user (a farmer or distributor) is prompted to either log in to an existing profile or create a new profile. In the case of farmers, the user can make/edit a request or view others’ requests. They can accept/decline the offers and/or counteroffers made by distributors. Distributors, on the other hand, can respond to farmers’ requests by making offers or counteroffers, and also edit existing ones they have already made.

(changes since phase 1 are in bold)
## Details

The user starts the program and is prompted with a screen asking them what they would like to do:

- Create a New Profile

    ![welcomePage](assets/welcomePage.gif)
    * Farmer OR Distributor
        + Name
        + Address
        + Preferences
- Login to Profile (Farmer)
    * Modify Profile
        * **Undo Changes (Memento Design Pattern)**
    * Create New Request

    ![requrest](assets/request.gif)
    * View Existing Request
        + Accept/Decline Offer
            + Make Counteroffer
        + Edit Request
    * View Others’ Requests
- Login to Profile (Distributor)
    * Modify Profile
        * **Undo Changes (Memento Design Pattern)**

    ![modify](assets/modify.gif)
    * Create New Request
    * View Existing Request
        + Accept/Decline Offer
            + Make Counteroffer
    * View Others’ Requests
        + Make Offer
        + Make Counteroffer


The controller (ServiceController) takes in the inputs of the UI and does one of two things:
- Accept the input
    * Makes the correct variable for the use case classes to use
- Decline the input
    * Prompt the user to input again with an error message stating why the input was not accepted

## Classes Specification
The UI classes are (new classes added in Phase 2 are emboldened):
- CounterOfferPage
- DetailsPage
- DistributorPage
- FarmerPage
- HistoryPage
- MessagePage
- ModifyPage
- OthersExistingRequests


The Database Class is:
- **JsonProvider**


The Controller classes are:
- ServiceController
- **Controller Interface**
- **DataPresenter**
- **IFetch**


The Use Case classes are:
- **DataAccessInterface**
- **ProfileInterface**
- ProfileManager
- RankingManager
- **RankInterface**
- **RequestInterface**
- **RequestManager**


The Entity classes are:
- User
   - Farmer
   - Distributor
- Request
- **IUser**
   - **IFarmer**
   - **IDistributor**
- **IRequest**