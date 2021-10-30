package Entities;

import java.util.ArrayList;

public class Farmer extends User {

    //Initialize list of requests

    /**
     Modification methods of request will be added later, set to be final for now.
     */

    private final ArrayList<Request> requests;
    //I am using array to show list of request for now, but depending on request's structure, it could be changed later

    private int prefPrice; // Int from 0-10 detailing preference for exact or better price (10 is rigid price)
    private int prefExposure; // Int from 0-10 detailing preference for high exposure (10 is maximum exposure)
    private int prefSpeed; // Int from 0-10 detailing preference for fast pickup (10 is fastest pickup)
    private int prefCarbon; // Int from 0-10 detailing preference for low-carbon distribution (10 is lowest emissions)

    public Farmer(String farmer_name, String farmer_address){
        super(farmer_name, farmer_address);
        this.requests = null;
    }

    public void setPrefPrice(int prefPrice) {
        this.prefPrice = prefPrice;
    }

    public void setPrefExposure(int prefExposure) {
        this.prefExposure = prefExposure;
    }

    public void setPrefSpeed(int prefSpeed) {
        this.prefSpeed = prefSpeed;
    }

    public void setPrefCarbon(int prefCarbon) {
        this.prefCarbon = prefCarbon;
    }

    public ArrayList<Request> getRequests(){
        return requests;
    }

    public int getPrefPrice(){
        return prefPrice;
    }

    public int getPrefExposure(){
        return prefExposure;
    }

    public int getPrefSpeed(){
        return prefSpeed;
    }

    public int getPrefCarbon(){
        return prefCarbon;
    }

}
