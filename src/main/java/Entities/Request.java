package Entities;

import java.util.ArrayList;

public class Request implements RequestStructure{

    public int request_id;
    private String farmer_name;
    private String farmer_address;
    private String product_name;
    private int product_quantity;
    private float product_price_per_unit;
    private ArrayList<RequestStructure> subtrees;

    public Request(int id, String name, String address, String PName, int PQuantity,
                   float PPrice) {

        request_id = id;
        farmer_name = name;
        farmer_address = address;
        product_name = PName;
        product_quantity = PQuantity;
        product_price_per_unit = PPrice;
        subtrees = new ArrayList<RequestStructure>();
    }

    /**
     *
     */
    public void setFarmerName(String name){
        this.farmer_name = name;
    }
    
    /**
     * @return the current value of farmer_name (String)
     */
    public String getFarmerName(){
        return this.farmer_name;
    }

    /**
     *
     */
    public void setFarmerAddress(String FarmerAddress){
        this.farmer_address = FarmerAddress;
    }

    /**
     * @return the current value of farmer_address (String)
     */
    public String getFarmerAddress(){
        return this.farmer_address;
    }

    /**
     *
     */
    public void setProduct_name(String ProductName){
        this.product_name = ProductName;
    }

    public String getProduct_name(){
        return this.product_name;
    }

    /**
     *
     */
    public void setProduct_quantity(int ProductQuantity){
        this.product_quantity = ProductQuantity;
    }

    public int getProduct_quantity(){
        return this.product_quantity;
    }

    /**
     *
     */
    public void setProduct_price_per_unit(float ProductPrice){
        this.product_price_per_unit = ProductPrice;
    }

    public float getProduct_price_per_unit(){
        return this.product_price_per_unit;
    }

    public String toString(){
        return "Name: " + this.farmer_name + "\n" +
                "Product: " + this.product_name + "\n" +
                "Quantity: " + this.product_quantity + "\n" +
                "Price: " + this.product_price_per_unit;
    }

    @Override
    public void add(RequestStructure request) {
        this.subtrees.add(request);
    }

    @Override
    public void remove(RequestStructure request) {
        this.subtrees.remove(request);
    }

    @Override
    public ArrayList<Request> temp() {
        return null;
    }

    @Override
    public void show(){
        for(RequestStructure item : subtrees) {
            System.out.println("========");
            item.show();
            System.out.println("========");
        }
    }

    @Override
    public void search(Offer offer){
        int id = offer.getRequest_id;
    }

}