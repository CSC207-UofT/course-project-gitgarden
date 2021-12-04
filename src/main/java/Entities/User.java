package Entities;

import java.util.ArrayList;

public class User implements IUser{
    private String userName;
    private final int userId;
    private String userAddress;

//    @Expose(serialize = false)
    protected ArrayList<IRequest> currentRequests = new ArrayList<>();

//    @Expose(serialize = false)
    protected ArrayList<IRequest> offerHistory = new ArrayList<>();

    /**
     * Construct a User with a name, address, and ID.
     * @param userName String for name
     * @param userAddress String for address
     * @param userId String for ID
     */
    public User(String userName, String userAddress, int userId){
        this.userName = userName;
        this.userId = userId;
        this.userAddress = userAddress;
    }

    /**
     * Adds a request to this user's current requests.
     * @param request The request to be added.
     */
    public void addRequest(IRequest request){
        this.currentRequests.add(request);
    }

    /**
     * Removes a request from this user's current requests.
     * @param request The request to be removed.
     */
    public void removeRequest(IRequest request) {
        this.currentRequests.remove(request);
    }

    /**
     * Gets all current requests of this user.
     * @return currentRequests
     */
    public ArrayList<IRequest> getCurrentRequests(){
        return this.currentRequests;
    }

    /**
     * Adds a request to this user's offer history.
     * @param offer The request which was accepted.
     */
    public void addOffer(IRequest offer){
        this.offerHistory.add(offer);
    }

    /**
     * Gets the offer history of this user.
     * @return offerHistory
     */
    public ArrayList<IRequest> getOfferHistory() {
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
     * Gets the user's current name.
     * @return the current value of userName.
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * Gets the user's ID.
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
     * Gets the user's address.
     * @return the current address of the user.
     */
    public String getUserAddress(){
        return this.userAddress;
    }

    /**
     * Gets a string representation of the user.
     * @return the String representation of the user
     */
    public String toString(){
        return "Name: " + userName + "\n" +
                "Address: " + userAddress;
    }

}