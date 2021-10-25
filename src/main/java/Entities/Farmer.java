package Entities;

import Entities.Request;

import java.util.ArrayList;

public class Farmer extends User {

    //Initialize list of requests

    /**
     Modification methods of request will be added later, set to be final for now.
     */

    private final ArrayList<Request> requests;
    //I am using array to show list of request for now, but depending on request's structure, it could be changed later

    public Farmer(String farmer_name, String farmer_address){
        super(farmer_name, farmer_address);
        this.requests = null;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

}
