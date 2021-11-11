package Entities;

import java.util.HashMap;
import java.util.ArrayList;

public class Distributor extends User{

    private final ArrayList<RequestStructure> current_requests;
    private final ArrayList<Offer> offer_history;

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

    public ArrayList<Offer> getOffer_history(){
        return this.offer_history;
    }

    public HashMap<String, Float> prodmap(){
        HashMap<String, Float> temp = new HashMap<>();
        for (Offer item: this.offer_history){
            temp.put(item.getProduct_name(), item.getProduct_price_per_unit());
        }
        return temp;
    }
}
