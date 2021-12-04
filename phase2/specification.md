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
        + Preferences
    * Distributor
        + Name
        + Address
        + Preferences (Expansion 2)
- Login to Profile (Farmer)
    * Modify Profile
        * **Undo Changes (Memento Design Pattern)**
    * Create New Request
    * View Existing Request
        + Accept/Decline Offer
            + Make Counteroffer
        + Edit Request
    * View Others’ Requests
- Login to Profile (User)
    * Modify Profile
        * **Undo Changes (Memento Design Pattern)**
    * Create New Request
    * View Existing Request
        + Accept/Decline Offer
            + Make Counteroffer
    * View Others’ Requests
        + Make Offer
        + Make Counteroffer