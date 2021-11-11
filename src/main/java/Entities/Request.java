package Entities;

import java.util.ArrayList;

public class Request implements RequestStructure{

    private final int request_id;
    private Farmer farmer;
    private String product_name;
    private int product_quantity;
    private float product_price_per_unit;
    private final ArrayList<RequestStructure> counteroffer;

    public Request(Farmer Farmer, String p_name, int p_quantity,
                   float p_price_per_unit) {
        request_id = (int) (Math.random()*(900000)+100000);
        farmer = Farmer;
        product_name = p_name;
        product_quantity = p_quantity;
        product_price_per_unit = p_price_per_unit;
        counteroffer = new ArrayList<>();
    }

    /**
     * @return the current value of request id. (int)
     */
    public int getRequest_id(){
        return this.request_id;
    }

    /**
     * Set the farmer to the given farmer.
     *
     * @param new_farmer Tne new Farmer to be set.
     */
    public void setFarmer(Farmer new_farmer){
        this.farmer = new_farmer;
    }

    /**
     * @return the current farmer of this request. (Farmer)
     */
    public Farmer getFarmer(){
        return this.farmer;
    }

    /**
     * @return the current value of farmer's user_name. (String)
     */
    public String getFarmerName(){
        return this.farmer.getUser_name();
    }

    /**
     * @return the current value of farmer's address. (String)
     */
    public String getFarmerAddress(){
        return this.farmer.getUser_address();
    }

    /**
     * Set the product name to the given name.
     *
     * @param ProductName Tne new Product name to be set.
     */
    public void setProduct_name(String ProductName){
        this.product_name = ProductName;
    }

    /**
     * @return the current value of product's name. (String)
     */
    public String getProduct_name(){
        return this.product_name;
    }

    /**
     * Set the product quantity to the given quantity.
     *
     * @param ProductQuantity The new Product quantity to be set.
     */
    public void setProduct_quantity(int ProductQuantity){
        this.product_quantity = ProductQuantity;
    }

    /**
     * @return the current value of product's quantity. (int)
     */
    public int getProduct_quantity(){
        return this.product_quantity;
    }

    /**
     * Set the product price per unit to the given price.
     *
     * @param ProductPrice The new Product price to be set.
     */
    public void setProduct_price_per_unit(float ProductPrice){
        this.product_price_per_unit = ProductPrice;
    }

    /**
     * @return the current value of product's price per unit. (float)
     */
    public float getProduct_price_per_unit(){
        return this.product_price_per_unit;
    }

    /**
     * @return The String Representation of the request.
     */
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
        ArrayList<Offer> temp = new ArrayList<>();
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