package Entities;

import java.util.ArrayList;

public class Offer implements RequestStructure{
    private int request_id;
    private Farmer farmer;
    private Distributor distributor;
    private String product_name;
    private int product_quantity;
    private float product_price_per_unit;

    public Offer(int id, Farmer Farmer, Distributor Distributor, String p_name, int p_quantity,
                 float p_price_per_unit) {
        request_id = id;
        farmer = Farmer;
        distributor = Distributor;
        product_name = p_name;
        product_quantity = p_quantity;
        product_price_per_unit = p_price_per_unit;
    }

    /**
     * Set the request_id to given id
     *
     * @param id Int for new id
     */
    public void setRequest_id(int id){
        this.request_id = id;
    }

    /**
     * @return the current value of request id (int)
     */
    public int getRequest_id(){
        return this.request_id;
    }

    /**
     * Set the farmer to the given farmer
     *
     * @param new_farmer Tne new Farmer to be set
     */
    public void setFarmer(Farmer new_farmer){
        this.farmer = new_farmer;
    }

    /**
     * @return the current value of farmer's user_name (String)
     */
    public String getFarmerName(){
        return this.farmer.getUser_name();
    }

    /**
     * @return the current value of farmer's address (String)
     */
    public String getFarmerAddress(){
        return this.farmer.getUser_address();
    }

    public void setDistributor(Distributor new_distributor){
        this.distributor = new_distributor;
    }

    public String getDistributorName(){
        return this.distributor.getUser_name();
    }

    public void setProduct_name(String ProductName){
        this.product_name = ProductName;
    }

    public String getProduct_name(){
        return this.product_name;
    }

    public void setProduct_quantity(int ProductQuantity){
        this.product_quantity = ProductQuantity;
    }

    public int getProduct_quantity(){
        return this.product_quantity;
    }

    public void setProduct_price_per_unit(float ProductPrice){
        this.product_price_per_unit = ProductPrice;
    }

    public float getProduct_price_per_unit(){
        return this.product_price_per_unit;
    }

    public String toString(){
        return "Farmer: " + this.farmer.getUser_name() + "\n" +
                "Distributor: " + this.distributor.getUser_name() + "\n" +
                "Product: " + this.product_name + "\n" +
                "Quantity: " + this.product_quantity + "\n" +
                "Price: " + this.product_price_per_unit;
    }

    @Override
    public void add(RequestStructure request) {
    }

    @Override
    public void remove(RequestStructure request) {
    }

    @Override
    public ArrayList<RequestStructure> counteroffers() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Offer> offers() {
        ArrayList<Offer> temp = new ArrayList<>();
        temp.add(this);
        return temp;
    }

    @Override
    public ArrayList<RequestStructure> search(Offer offer){
        if (this == offer){
            ArrayList<RequestStructure> temp = new ArrayList<>();
            temp.add(this);
            return temp;
        }
        else{
            return new ArrayList<>();
        }
    }

    @Override
    public void show(){
        System.out.println(this);
    }

}
