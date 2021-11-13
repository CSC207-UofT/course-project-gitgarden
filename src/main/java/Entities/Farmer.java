package Entities;

import java.util.ArrayList;

public class Farmer extends User implements IFarmer{

    private final ArrayList<RequestStructure> current_requests;
    private final ArrayList<Offer> offer_history;

    private double prefPrice; // Int from 0-10 detailing preference for exact or better price (10 is rigid price)
    private double prefExposure; // Int from 0-10 detailing preference for high exposure (10 is maximum exposure)
    private double prefSpeed; // Int from 0-10 detailing preference for fast pickup (10 is fastest pickup)
    private double prefCarbon; // Int from 0-10 detailing preference for low-carbon distribution (10 is lowest emissions)

    public Farmer(String farmer_name, String farmer_address){
        super(farmer_name, farmer_address);
        this.current_requests = new ArrayList<>();
        this.offer_history = new ArrayList<>();
        this.prefPrice = 5;
        this.prefExposure = 5;
        this.prefSpeed = 5;
        this.prefCarbon = 5;
    }

    public void add_request(Request request){
        this.current_requests.add(request);
    }

    public void remove_request(Request request) {
        this.current_requests.remove(request);
    }

    public ArrayList<RequestStructure> getCurrent_requests(){
        return this.current_requests;
    }

    public void add_offer(Offer offer){
        this.offer_history.add(offer);
    }

    public void remove_offer(Offer offer) {
        this.offer_history.remove(offer);
    }

    public ArrayList<Offer> getOffer_history(){
        return this.offer_history;
    }

    //=========================================================================

    public void setPrefPrice(double prefPrice) {
        this.prefPrice = prefPrice;
    }

    public void setPrefExposure(double prefExposure) {
        this.prefExposure = prefExposure;
    }

    public void setPrefSpeed(double prefSpeed) {
        this.prefSpeed = prefSpeed;
    }

    public void setPrefCarbon(double prefCarbon) {
        this.prefCarbon = prefCarbon;
    }

    public double getPrefPrice(){
        return prefPrice;
    }

    public double getPrefExposure(){
        return prefExposure;
    }

    public double getPrefSpeed(){
        return prefSpeed;
    }

    public double getPrefCarbon(){
        return prefCarbon;
    }
  
}
