package Entities;

import java.util.ArrayList;

public class Request implements IRequest{

    private final int requestId;
    private final IUser user;
    private final String prodName;
    private final double prodQuantity;
    private final double prodPricePerKg;
    private final ArrayList<IRequest> counteroffers;
    private final IRequest previous;
    private boolean accepted;

    public Request(int id, IUser user, String pName, double pQuantity, double pPricePerKg, IRequest previous) {
        this.requestId = id;
        this.user = user;
        this.prodName = pName;
        this.prodQuantity = pQuantity;
        this.prodPricePerKg = pPricePerKg;
        this.counteroffers = new ArrayList<>();
        this.previous = previous;
        accepted = false;
    }

    /**
     * Adds a counteroffer to the request.
     * @param co The counteroffer to be added.
     */
    public void add(IRequest co){
        this.counteroffers.add(co);
    }

    /**
     * Adds a counteroffer to the request.
     *
     * @return accepted the state of this request
     */
    public boolean getAccepted(){
        return accepted;
    }

    /**
     * Set accepted to true
     *
     */
    public void setAccepted(){
        accepted = true;
    }

    /**
     * Gets this request's counteroffers.
     * @return the current counteroffers to the request.
     */
    public ArrayList<IRequest> getCounteroffers(){
        return this.counteroffers;
    }

    /**
     * Gets this request's ID.
     * @return the current value of requestID.
     */
    public int getRequestId(){
        return this.requestId;
    }

    /**
     * Gets this request's user.
     * @return The user making this request.
     */
    public IUser getUser(){
        return this.user;
    }

    /**
     * Gets this request's product name.
     * @return The product name.
     */
    public String getProdName(){
        return this.prodName;
    }

    /**
     * Gets this request's product quantity.
     * @return The product quantity.
     */
    public double getProdQuantity(){
        return this.prodQuantity;
    }

    /**
     * Gets this request's product price per kilogram.
     * @return The product price per kilogram.
     */
    public double getProdPricePerKg(){
        return this.prodPricePerKg;
    }

    /**
     * Gets this request's previous request.
     * @return The request to which this was a counteroffer, null if none.
     */
    public IRequest getPrevious(){
        return this.previous;
    }

    /**
     * Converts this request into String format.
     * @return The String Representation of the request.
     */
    public String toString(){
        return "Name: " + this.user.getUserName() + "\n" +
                "Product: " + this.prodName + "\n" +
                "Quantity: " + this.prodQuantity + "\n" +
                "Price: " + this.prodPricePerKg;
    }
}