package UseCases;

import Entities.*;

import java.util.ArrayList;

public class RequestManager implements RequestInterface{
    public static ArrayList<IRequest> allActiveRequests = new ArrayList<>();
    public static ArrayList<IRequest> allOffers = new ArrayList<>(); // May be removed if it turns out to be unneeded

    /**
     * Creates a request.
     * @param requestID The ID of the new request.
     * @param id ID of the user creating the request.
     * @param product The product being sold.
     * @param quantity The quantity in kilograms of product to be sold.
     * @param price The price per kilogram of the product.
     */
    @Override
    public void createRequest(int requestID, String id, String product, Double quantity, Double price) {
        ProfileInterface pm = new ProfileManager();
        IUser user = pm.getUserFromId(id);
        IRequest request = new Request(requestID, user, product, quantity, price, null);
        user.addRequest(request);
        allActiveRequests.add(request);
    }

    /**
     * Creates a counteroffer.
     * @param requestID The ID of the new counteroffer.
     * @param id The ID of the user making the counteroffer.
     * @param counteredRequestID The ID of the request upon which the counteroffer is made.
     * @param quantity The new quantity in kilograms of product to be sold.
     * @param price The new price per kilogram of the product.
     */
    @Override
    public void createCounterOffer(int requestID, String id, String counteredRequestID, Double quantity, Double price){
        ProfileInterface pm = new ProfileManager();
        IUser user = pm.getUserFromId(id);
        IRequest request = getRequestFromId(counteredRequestID);
        IRequest co = new Request(requestID, user, request.getProdName(), quantity, price, request);
        request.add(co);
        if (request.getPrevious() != null){
            deleteCurrent(request);
        }
        addCurrent(co);
    }

    /**
     * Accepts a request, removing it from both users' current requests, and adding it to their offer history.
     * @param requestID The ID of the request to be accepted.
     */
    @Override
    public void acceptRequest(String requestID){
        IRequest request = getRequestFromId(requestID);
        IUser previousUser = request.getPrevious().getUser();

        //Call Rating System for current user
        request.getUser().addOffer(request);
        //call Rating System for previous user
        previousUser.addOffer(request);

        deleteCurrent(request);
        IRequest root = requestRoot(request);
        root.getUser().removeRequest(root);
        allActiveRequests.remove(root);
        allOffers.add(request);
    }

    /**
     * Declines a request, removing it from both users' current requests.
     * @param requestID The ID of the request to be declined.
     */
    @Override
    public void declineRequest(String requestID){
        IRequest request = getRequestFromId(requestID);
        deleteCurrent(request);
    }

    /**
     * Removes a request from the list of active requests permanently.
     * @param requestID The ID of the request to be removed.
     */
    @Override
    public void trashRequest(String requestID){
        IRequest request = getRequestFromId(requestID);
        allActiveRequests.remove(request);
    }

    /**
     * Gets request data based on ID.
     * @param requestID The ID of the request whose data must be found.
     * @return A string array with request data as [product name, quantity, price/kg, username, previous requestID]
     */
    @Override
    public String[] dataFromId(String requestID) {
        IRequest request = getRequestFromId(requestID);
        String[] data = new String[6];
        data[0] = request.getProdName();
        data[1] = String.valueOf(request.getProdQuantity());
        data[2] = String.valueOf(request.getProdPricePerKg());
        data[3] = request.getUser().getUserName();
        if (request.getPrevious() == null){
            data[4] = null;
        } else {
            data[4] = String.valueOf(request.getPrevious().getRequestId());
        }

        if (request.getUser() instanceof Distributor) {
            data[5] = String.valueOf(RankingManager.getHistoryAvg((Distributor)request.getUser()));
        }
        else if (request.getUser() instanceof Farmer) {
            if (request.getPrevious() != null) {
                data[5] = String.valueOf(RankingManager.getHistoryAvg((Distributor)request.getPrevious().getUser()));
            }
            else {
                data[5] = null;
            }
        }

        return data;
    }

    /**
     * Gets the counteroffers of a request based on ID.
     * @param requestID The ID of the request whose counteroffers must be found.
     * @return The counteroffers of the request.
     */
    @Override
    public ArrayList<String> coFromId(String requestID) {
        IRequest request = getRequestFromId(requestID);
        ArrayList<IRequest> counteroffers = new ArrayList<>(request.getCounteroffers());
        return requestToId(counteroffers);
    }

    @Override
    public ArrayList<String> requestToId(ArrayList<IRequest> requests){
        ArrayList<String> ids = new ArrayList<>();
        for (IRequest request : requests){
            ids.add(String.valueOf(request.getRequestId()));
        }
        return ids;
    }

    /**
     * Finds the parent of this counteroffer chain.
     * @param request The request whose root needs to be found.
     * @return The request root.
     */
    private IRequest requestRoot(IRequest request){
        IRequest previous = request.getPrevious();
        if (previous == null){
            return request;
        } else {
            return requestRoot(previous);
        }
    }

    /**
     * Deletes this request from the farmer and distributor's current requests.
     * @param request The request to be deleted.
     */
    private void addCurrent(IRequest request){
        allActiveRequests.add(request);
        IUser previousUser = request.getPrevious().getUser();
        request.getUser().addRequest(request);
        previousUser.addRequest(request);
    }
    /**
     * Deletes this request from the farmer and distributor's current requests.
     * @param request The request to be deleted.
     */
    private void deleteCurrent(IRequest request){
        allActiveRequests.remove(request);
        IUser previousUser = request.getPrevious().getUser();
        request.getUser().removeRequest(request);
        previousUser.removeRequest(request);
    }

    /**
     * Gets an active request from its ID.
     * @param requestID The ID of the request.
     * @return The request matching the ID.
     */
    public IRequest getRequestFromId(String requestID){
        ArrayList<IRequest> allRequests = new ArrayList<>(allActiveRequests);
        for (IRequest request : allRequests){
            if (String.valueOf(request.getRequestId()).equals(requestID)){
                return request;
            }
        }
        return new Request(0, null, null, 0, 0, null);
    }

    /**
     * Gets all request IDs.
     * @return All request IDs.
     */
    @Override
    public ArrayList<Integer> getAllRequestIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<IRequest> allRequests = new ArrayList<>(allActiveRequests);
        allRequests.addAll(allOffers);
        for (IRequest request: allRequests){
            ids.add(request.getRequestId());
        }
        return ids;
    }

}
