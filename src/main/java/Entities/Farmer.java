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

    private int pref_price; // Int from 0-10 detailing preference for exact or better price (10 is rigid price)
    private int pref_exposure; // Int from 0-10 detailing preference for high exposure (10 is maximum exposure)
    private int pref_speed; // Int from 0-10 detailing preference for fast pickup (10 is fastest pickup)
    private int pref_carbon; // Int from 0-10 detailing preference for low-carbon distribution (10 is lowest emissions)

    public Farmer(String farmer_name, String farmer_address){
        super(farmer_name, farmer_address);
        this.requests = null;
    }

    public void setPref_price(int pref_price) {
        this.pref_price = pref_price;
    }

    public void setPref_exposure(int pref_exposure) {
        this.pref_exposure = pref_exposure;
    }

    public void setPref_speed(int pref_speed) {
        this.pref_speed = pref_speed;
    }

    public void setPref_carbon(int pref_carbon) {
        this.pref_carbon = pref_carbon;
    }

    public ArrayList<Request> getRequests(){
        return requests;
    }

    public int getPref_price(){
        return pref_price;
    }

    public int getPref_exposure(){
        return pref_exposure;
    }

    public int getPref_speed(){
        return pref_speed;
    }

    public int getPref_carbon(){
        return pref_carbon;
    }

}
