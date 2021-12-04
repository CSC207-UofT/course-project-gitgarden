package Entities;

import java.util.ArrayList;

public class Request implements IRequest{

    private final int requestId;
    private transient IUser user;
    private final String prodName;
    private final double prodQuantity;
    private final double prodPricePerKg;
    private final ArrayList<IRequest> counteroffers;
    private final IRequest previous;
    private double rating;

    public Request(IUser user, String pName, double pQuantity, double pPricePerKg, IRequest previous) {
        this.requestId = (int) (Math.random()*(90000000)+10000000);
        this.user = user;
        this.prodName = pName;
        this.prodQuantity = pQuantity;
        this.prodPricePerKg = pPricePerKg;
        this.counteroffers = new ArrayList<>();
        this.previous = previous;
        this.rating = -1;
    }

    public Request(String pName, double pQuantity, double pPricePerKg, IRequest previous) {
        this.requestId = (int) (Math.random()*(90000000)+10000000);
        this.prodName = pName;
        this.prodQuantity = pQuantity;
        this.prodPricePerKg = pPricePerKg;
        this.counteroffers = new ArrayList<>();
        this.previous = previous;
    }

    /**
     * Adds a counteroffer to the request.
     * @param co The counteroffer to be added.
     */
    public void add(IRequest co){
        this.counteroffers.add(co);
    }

    /**
     * Removes a counteroffer from the request.
     * @param co The counteroffer to be removed.
     */
    public void remove(IRequest co){
        this.counteroffers.remove(co);
    }

    /**
     * @return the current counteroffers to the request.
     */
    public ArrayList<IRequest> getCounteroffers(){
        return this.counteroffers;
    }

    /**
     * @return the current value of request id. (int)
     */
    public int getRequestId(){
        return this.requestId;
    }

    /**
     * @return the user making this request.
     */
    public IUser getUser(){
        return this.user;
    }

    /**
     * @return the value of product's name. (String)
     */
    public String getProdName(){
        return this.prodName;
    }

    /**
     * @return the value of product's quantity. (double)
     */
    public double getProdQuantity(){
        return this.prodQuantity;
    }

    /**
     * @return the value of product's price per unit. (double)
     */
    public double getProdPricePerKg(){
        return this.prodPricePerKg;
    }

    /**
     * @return the request to which this was a counteroffer, null if none.
     */
    public IRequest getPrevious(){
        return this.previous;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    public double getRating(){
        return this.rating;
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