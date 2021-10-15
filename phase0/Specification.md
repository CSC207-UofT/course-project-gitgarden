# Specification

## Introduction

Project is an interface to connect produce farmers to distribution of their products. The target audience are farmers and distributors looking to expand their network. The farmers and distributors indicate the produce they are willing to sell and buy, respectively, and their prices.

While running, the user is prompted to either login to an existing profile, or create a new profile. Then, the user can make a request or view others' requests. They can accept/decline others' offers and make offers to others.

## Details

The users starts the program and is prompted with a screen asking them what they would like to do:
- Create a New Profile 
    * Farmer
        + Name
        + Address
        + Preferences (Expansion 1)
    * Distributor
        + Name
        + Address
        + Preferences (Expansion 2)
- Login to Profile
    * Modify Profile
    * Create New Request
    * View Existing Request
        + Accept/Decline Offer
            + Make Counter Offer (Expansion 2)
        + View Rating (Expansion 2)
    * View Others’ Requests
        + Make Offer
        + Make Counter Offer (Expansion 2)
    * Transaction History (Expansion 3)

The controller (ServiceController) takes in the inputs of the CLI and does one of two things:
- Accept the input
    * Makes the correct variable for the use case classes to use
- Decline the input
    * Prompt the user to input again with an error message stating why the input was not accepted

## Classes Specification

The **use case** classes are:
- ProfileManager
- MatchManager
- RatingManager (Expansion 2)

The **entity** classes:
- Farmer
- Distirbutor
- Request
- Offer
    * Counter Offer (Expansion 2)

