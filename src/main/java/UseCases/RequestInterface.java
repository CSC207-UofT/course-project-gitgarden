package UseCases;

import Entities.IRequest;

import java.util.ArrayList;

public interface RequestInterface {
    /**
     * Creates a request.
     *
     * @param requestID The ID of the new request.
     * @param id        ID of the user creating the request.
     * @param product   The product being sold.
     * @param quantity  The quantity in kilograms of product to be sold.
     * @param price     The price per kilogram of the product.
     */
    void createRequest(int requestID, String id, String product, Double quantity, Double price);

    /**
     * Creates a counteroffer.
     *
     * @param requestID          The ID of the new counteroffer.
     * @param id                 The ID of the user making the counteroffer.
     * @param counteredRequestID The ID of the request upon which the counteroffer is made.
     * @param quantity           The new quantity in kilograms of product to be sold.
     * @param price              The new price per kilogram of the product.
     */
    void createCounterOffer(int requestID, String id, String counteredRequestID, Double quantity, Double price);

    /**
     * Accepts a request, removing it from both users' current requests, and adding it to their offer history.
     *
     * @param requestID The ID of the request to be accepted.
     */
    void acceptRequest(String requestID, String userID);

    /**
     * Declines a request, removing it from both users' current requests.
     *
     * @param requestID The ID of the request to be declined.
     */
    void declineRequest(String requestID);

    /**
     * Removes a request from the list of active requests permanently.
     *
     * @param requestID The ID of the request to be removed.
     */
    void trashRequest(String requestID);

    /**
     * Gets request data based on ID.
     *
     * @param requestID The ID of the request whose data must be found.
     * @return A string array with request data as [product name, quantity, price/kg, username, previous requestID]
     */
    String[] dataFromId(String requestID);

    /**
     * Gets the counteroffers of a request based on ID.
     *
     * @param requestID The ID of the request whose counteroffers must be found.
     * @return The counteroffers of the request.
     */
    ArrayList<String> coFromId(String requestID);

    /**
     * Converts a list of IRequests into their corresponding IDs.
     *
     * @param requests The list to be converted.
     * @return The corresponding list of IDs.
     */
    ArrayList<String> requestToId(ArrayList<IRequest> requests);

    /**
     * Gets an active request from its ID.
     *
     * @param requestID The ID of the request.
     * @return The request matching the ID.
     */
    IRequest getRequestFromId(String requestID);

    /**
     * Gets all request IDs.
     *
     * @return All request IDs.
     */
    ArrayList<Integer> getAllRequestIds();
}
