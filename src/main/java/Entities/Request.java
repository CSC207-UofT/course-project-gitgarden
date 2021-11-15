package Entities;

import java.util.ArrayList;

public class Request {

    private final int requestId;
    private final User user;
    private final String prodName;
    private final int prodQuantity;
    private final double prodPricePerKg;
    private ArrayList<Request> counteroffers;

    public Request(User user, String pName, int pQuantity, double pPricePerKg) {
        this.requestId = (int) (Math.random()*(90000000)+10000000);
        this.user = user;
        this.prodName = pName;
        this.prodQuantity = pQuantity;
        this.prodPricePerKg = pPricePerKg;
        this.counteroffers = new ArrayList<>();
    }

    /**
     * Adds a counteroffer to the request.
     * @param co The counteroffer to be added.
     */
    public void add(Request co){
        this.counteroffers.add(co);
    }

    /**
     * Removes a counteroffer from the request.
     * @param co The counteroffer to be removed.
     */
    public void remove(Request co){
        this.counteroffers.remove(co);
    }

    /**
     * @return the current counteroffers to the request.
     */
    public ArrayList<Request> getCounteroffers(){
        return this.counteroffers;
    }

    /**
     * @return the current value of request id. (int)
     */
    public int getRequestId(){
        return this.requestId;
    }

    /**
     * @return the current farmer of this request. (Farmer)
     */
    public User getUser(){
        return this.user;
    }

    /**
     * @return the current value of product's name. (String)
     */
    public String getProdName(){
        return this.prodName;
    }

    /**
     * @return the current value of product's quantity. (int)
     */
    public int getProdQuantity(){
        return this.prodQuantity;
    }

    /**
     * @return the current value of product's price per unit. (float)
     */
    public double getProdPricePerKg(){
        return this.prodPricePerKg;
    }

    /**
     * @return The String Representation of the request.
     */
    public String toString(){
        return "Name: " + this.user.getUserName() + "\n" +
                "Product: " + this.prodName + "\n" +
                "Quantity: " + this.prodQuantity + "\n" +
                "Price: " + this.prodPricePerKg;
    }
}