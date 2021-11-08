package Entities;

import java.util.ArrayList;

public class Request implements RequestStructure{

    private int request_id;
    private Farmer farmer;
    private String product_name;
    private int product_quantity;
    private float product_price_per_unit;
    private ArrayList<RequestStructure> counteroffer;

    public Request(int id, Farmer Farmer, String p_name, int p_quantity,
                   float p_price_per_unit) {
        request_id = id;
        farmer = Farmer;
        product_name = p_name;
        product_quantity = p_quantity;
        product_price_per_unit = p_price_per_unit;
        counteroffer = new ArrayList<>();
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
        return "Name: " + this.farmer.getUser_name() + "\n" +
                "Product: " + this.product_name + "\n" +
                "Quantity: " + this.product_quantity + "\n" +
                "Price: " + this.product_price_per_unit;
    }

    @Override
    public void add(RequestStructure request) {
        this.counteroffer.add(request);
    }

    @Override
    public void remove(RequestStructure request) {
        this.counteroffer.remove(request);
    }

    @Override
    public ArrayList<RequestStructure> counteroffers() {
        return this.counteroffer;
    }

    @Override
    public ArrayList<Offer> offers(){
        ArrayList<Offer> temp = new ArrayList<Offer>();
        for(RequestStructure item: this.counteroffer){
            if (item instanceof Request){
                item.offers();
            }
            else{
                temp.addAll(item.offers());
            }
        }
        return temp;
    }

    @Override
    public ArrayList<RequestStructure> search(Offer offer){
        ArrayList<ArrayList<RequestStructure>> paths = new ArrayList<>();

        for(RequestStructure item: this.counteroffer){

            ArrayList<RequestStructure> temp = new ArrayList<>();
            temp.add(this);

            if (item instanceof Offer){
                temp.add(this);
                paths.add(temp);
            }
            else {
                item.search(offer);
            }

        }

        for (ArrayList<RequestStructure> path: paths) {
            if (path.get(-1) == offer) {
                return path;
            }
        }
        return new ArrayList<>();
    }

    @Override
    public void show(){
        System.out.println(this);
        for(RequestStructure item: this.counteroffer){
            System.out.println("======");
            item.show();
            System.out.println("======");
            }
        }
    }