package Entities;

import java.util.ArrayList;

public interface IUser {

    /**
     * Adds a request to this user's current requests.
     *
     * @param request The request to be added.
     */
    void addRequest(IRequest request);

    /**
     * Removes a request from this user's current requests.
     *
     * @param request The request to be removed.
     */
    void removeRequest(IRequest request);

    /**
     * Gets all current requests of this user.
     *
     * @return currentRequests
     */
    ArrayList<IRequest> getCurrentRequests();

    /**
     * Adds a request to this user's offer history.
     *
     * @param offer The request which was accepted.
     */
    void addOffer(IRequest offer);

    /**
     * Gets the offer history of this user.
     *
     * @return offerHistory
     */
    ArrayList<IRequest> getOfferHistory();

    /**
     * Set the username to the given name.
     *
     * @param name String for user's new name.
     */
    void setUserName(String name);

    /**
     * Gets the user's current name.
     *
     * @return the current value of userName.
     */
    String getUserName();

    /**
     * Gets the user's ID.
     *
     * @return the user's ID.
     */
    int getUserId();

    /**
     * Set user's address.
     *
     * @param address String for user's new address.
     */
    void setUserAddress(String address);

    /**
     * Gets the user's address.
     *
     * @return the current address of the user.
     */
    String getUserAddress();
}
