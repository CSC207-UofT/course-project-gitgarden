package Entities;/* CRC Class Information -------

Class name: Entities.Distributor
Parent class: Entities.User

Responsibilities:
* Store distributor’s list of offers
* Store distributor’s preferences
 [expansion]

Collaborators:
* MatchSystem
* UseCases.ProfileManager

------------------------------*/

import Entities.Request;

import java.util.HashMap;
import java.util.ArrayList;

public class Distributor extends User {

    //Initialize list of requests
    /**
    Modification methods of request and proMap will be added later, set to be final for now.
     */
    private final ArrayList<Request> requests;

    //Initialize prodMap
    private final HashMap<String, Double> prodMap;


    public Distributor(String distributor_name, String distributor_address, HashMap<String, Double> hashmap){
        super(distributor_name, distributor_address);
        this.requests = null;
        this.prodMap = hashmap;
    }

    public ArrayList<Request> getRequests(){
        return this.requests;
    }

    public HashMap<String, Double> getProdMap(){
        return this.prodMap;
    }
}
