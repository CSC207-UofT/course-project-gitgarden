package Controller;

import java.util.ArrayList;

public interface ControllerInterface {

    /**
     * Creates a profile if inputs are valid.
     * @param name Name of the user.
     * @param address Address of the user.
     * @param flag Boolean representing farmer/distributor.
     * @return ID of user created.
     * @throws Exception Indication if one of the inputs fails.
     */
    String createProfileCheck(String name, String address, boolean flag) throws Exception;

    /**
     * Modifies a user's profile if inputs are valid.
     * @param id ID of User to be modified.
     * @param newName User's new name.
     * @param address User's new address.
     */
    void modifyUserCheck(String id, String newName, String address) throws Exception;

    /**
     * Modifies a farmer's preferences if inputs are valid.
     * @param id ID of farmer to be modified.
     * @param slider1 Farmer's new price preference.
     * @param slider2 Farmer's new exposure preference.
     * @param slider3 Farmer's new speed preference.
     * @param slider4 Farmer's new carbon preference.
     */
    void modifyFarmerCheck(String id, double slider1, double slider2, double slider3, double slider4);

    /**
     * Modifies a distributor's criteria if inputs are valid.
     * @param id ID of distributor to be modified.
     * @param slider2 Distributor's new exposure preference.
     * @param slider3 Distributor's new speed preference.
     * @param slider4 Distributor's new carbon preference.
     */
    void modifyDistributorCheck(String id, double slider2, double slider3, double slider4);

    /**
     * Creates a request if inputs are valid.
     * @param id ID of user creating the request.
     * @param product Product which is being sold.
     * @param quantity Quantity in kg of product being sold.
     * @param price Price per kg of product being sold.
     */
    void createRequestCheck(String id, String product, String quantity, String price) throws Exception;

    /**
     * Creates a counteroffer if inputs are valid.
     * @param id ID of user creating counteroffer.
     * @param counteredRequestID ID of request which is being countered.
     * @param quantity New quantity in kg of product.
     * @param price New price per kg of product.
     */
    void createCounterOfferCheck(String id, String counteredRequestID, String quantity, String price) throws Exception;

    /**
     * Accepts a request if inputs are valid.
     * @param requestID ID of request to be accepted.
     * @param userID ID of user accepting request.
     */
    void acceptRequestCheck(String requestID, String userID);

    /**
     * Declines a request if inputs are valid.
     * @param requestID ID of request to be declined.
     */
    void declineRequestCheck(String requestID);

    /**
     * Trashes a request if inputs are valid.
     * @param requestID ID of request to be trashed.
     */
    void trashRequestCheck(String requestID);

    /**
     * Ranks distributors according to farmer preferences.
     * @param requestID Request whose counteroffers are to be ranked.
     * @param farmerID ID of farmer whose preferences must be known.
     * @return A list of distributors sorted by ranking.
     */
    ArrayList<String> rank(String requestID, String farmerID);

}
