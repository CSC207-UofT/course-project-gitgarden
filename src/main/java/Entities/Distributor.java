package Entities;

import java.util.HashMap;
import java.util.ArrayList;

public class Distributor extends User implements Comparable<Distributor> {

    private final ArrayList<RequestStructure> current_requests;
    private final ArrayList<Offer> offer_history;

    private double exposure;
    private double speed; // Average number of hours in which transactions are completed after being finalized
    private double carbon; // Number of grams CO2eq emitted per transaction
    private double ranking; // Comparable object

    public Distributor(String distributor_name, String distributor_address){
        super(distributor_name, distributor_address);
        this.current_requests = new ArrayList<>();
        this.offer_history = new ArrayList<>();
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

    public ArrayList<Offer> getOffer_history() {
        return this.offer_history;
    }

    public HashMap<String, Float> prodMap(){
        HashMap<String, Float> temp = new HashMap<>();
        for (Offer item: this.offer_history){
            temp.put(item.getProduct_name(), item.getProduct_price_per_unit());
        }
        return temp;
    }

    //=========================================================================

    public int compareTo(Distributor other){
        return Double.compare(this.ranking, other.ranking);
    }

    public void setExposure(double exposure) {
        this.exposure = exposure;
    }

    public double getExposure() {
        return this.exposure;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setCarbon(double carbon) {
        this.carbon = carbon;
    }

    public double getCarbon() {
        return carbon;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

}
