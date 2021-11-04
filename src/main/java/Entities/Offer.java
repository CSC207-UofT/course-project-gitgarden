package Entities;

import java.util.ArrayList;

public class Offer implements RequestStructure{
    public int request_id;
    public int getRequest_id;
    private String farmer_name;
    private String distributor_name;
    private String farmer_address;
    private String product_name;
    private int product_quantity;
    private float product_price_per_unit;

    public Offer(int id, String name, String address, String PName, int PQuantity,
                   float PPrice) {
        request_id = id;
        farmer_name = name;
        farmer_address = address;
        product_name = PName;
        product_quantity = PQuantity;
        product_price_per_unit = PPrice;
    }
    
    public int getRequest_id(){
        return this.request_id;
    }

    @Override
    public void add(RequestStructure request) {
    }

    @Override
    public void remove(RequestStructure request) {
    }

    @Override
    public ArrayList<Request> temp() {
        return null;
    }

    @Override
    public void show(){
        System.out.println(this.request_id);
    }

    @Override
    public void search(Offer offer){
    }
}
