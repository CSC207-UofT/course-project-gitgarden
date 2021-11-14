package Entities;

import java.util.ArrayList;

public class User implements IUser{
    private String userName;
    private final int userId;
    private String userAddress;
    protected ArrayList<Request> currentRequests;
    protected ArrayList<Request> offerHistory;

     /**
     * Construct a User, giving them the name and address
     *
     * @param userName String for name
     * @param userAddress  String for address
     */
    public User(String userName, String userAddress){
        this.userName = userName;
        this.userId = (int) (Math.random()*(90000000)+10000000);
        this.userAddress = userAddress;
    }

    public void addRequest(Request request){
        this.currentRequests.add(request);
    }

    public void removeRequest(Request request) {
        this.currentRequests.remove(request);
    }

    public ArrayList<Request> getCurrentRequests(){
        return this.currentRequests;
    }

    public void addOffer(Request offer){
        this.offerHistory.add(offer);
    }

    public void removeOffer(Request offer) {
        this.offerHistory.remove(offer);
    }

    public ArrayList<Request> getOfferHistory() {
        return this.offerHistory;
    }

    /**
     * Set the username to the given name.
     * @param name String for user's new name.
     */
    public void setUserName(String name){
        this.userName = name;
    }

     /**
      * @return the current value of user_name (String)
      */
    public String getUserName(){
        return this.userName;
    }

    /**
     * @return the user's ID.
     */
    public int getUserId(){
        return this.userId;
    }

    /**
     * Set user's address.
     * @param address String for user's new address.
     */
    public void setUserAddress(String address){
        this.userAddress = address;
    }

     /**
     * @return the current value of user's address (String)
     */
    public String getUserAddress(){
        return this.userAddress;
    }

     /**
     * @return the String representation of the user
     */
    public String toString(){
        return "Name: " + userName + "\n" +
                "Address: " + userAddress + "\n";
    }

}