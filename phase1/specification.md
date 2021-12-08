# Specification

## Introduction

Our project is a medium for connecting produce farmers to distributors of their products. The target audiences are farmers and distributors looking to expand their network. The farmers and distributors indicate the produce they are willing to sell and buy, respectively and their prices.

While running, the user (a farmer or distributor) is prompted to either log in to an existing profile or create a new profile. In the case of farmers, the user can make/edit a request or view others’ requests. They can accept/decline the offers and/or counteroffers made by distributors. Distributors, on the other hand, can respond to farmers’ requests by making offers or counteroffers, and also edit existing ones they have already made.

## Details

(changes are in bold)
The users starts the program and is prompted with a screen asking them what they would like to do:

- Create a New Profile
    * Farmer
        + Name
        + Address
        + **Preferences**
    * Distributor
        + Name
        + Address
        + Preferences (Expansion 2)
- Login to Profile (Farmer)
    * **Modify Profile**
    * Create New Request
    * **View Existing Request**
        + **Accept/Decline Offer**
            + **Make Counteroffer**
        + **Edit Request**
    * **View Others’ Requests**
    * View Other’s Ratings (Expansion 2)
    * Transaction History (Expansion 2)
- Login to Profile (User)
    * **Modify Profile**
    * Create New Request
    * **View Existing Request**
        + **Accept/Decline Offer**
            + **Make Counteroffer**
        + View Rating (Expansion 2)
    * **View Others’ Requests**
        + **Make Offer**
        + **Make Counteroffer**
    * View Other’s Ratings (Expansion 2)
    * Transaction History (Expansion 2)


The controller (ServiceController) takes in the inputs of the Client.UI and does one of two things:
- Accept the input
    * Makes the correct variable for the use case classes to use
- Decline the input
    * Prompt the user to input again with an error message stating why the input was not accepted

## Classes Specification

The Use Case classes are:
- ProfileManager
- MatchManager
- RankingManager (Expansion 2)

The Entity classes are:
- User
    - Farmer
    - Distributor
- RequestStructure
    - Request
    - Offer
