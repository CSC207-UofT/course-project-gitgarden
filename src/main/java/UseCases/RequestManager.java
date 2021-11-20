package UseCases;

import Entities.IRequest;
import Entities.IUser;
import Entities.Request;

import java.util.ArrayList;

public class RequestManager implements RequestInterface{
    public static ArrayList<IRequest> allActiveRequests = new ArrayList<>();
    public static ArrayList<IRequest> allOffers = new ArrayList<>(); // May be removed if it turns out to be unneeded

    /**
     * Creates a request.
     * @param user The user creating the request.
     * @param product The product being sold.
     * @param quantity The quantity in kilograms of product to be sold.
     * @param price The price per kilogram of the product.
     */
    @Override
    public void createRequest(IUser user, String product, Double quantity, Double price) {
        IRequest request = new Request(user, product, quantity, price, null);
        user.addRequest(request);
        allActiveRequests.add(request);
    }

    /**
     * Creates a counteroffer.
     * @param user The user making the counteroffer.
     * @param request The request upon which the counteroffer is made.
     * @param quantity The new quantity in kilograms of product to be sold.
     * @param price The new price per kilogram of the product.
     */
    @Override
    public void createCounterOffer(IUser user, IRequest request, Double quantity, Double price){
        IRequest co = new Request(user, request.getProdName(), quantity, price, request);
        request.add(co);
        if (request.getPrevious().getPrevious() != null){
            user.removeRequest(request);
            request.getPrevious().getUser().removeRequest(request);
        }
        user.addRequest(co);
        request.getPrevious().getUser().addRequest(co);
    }

    /**
     * Accepts a request, removing it from both users' current requests, and adding it to their offer history.
     * @param request The request to be accepted.
     */
    @Override
    public void acceptRequest(IRequest request){
        IUser previousUser = request.getPrevious().getUser();
        request.getUser().addOffer(request);
        previousUser.addOffer(request);
        deleteCurrent(request);
        IRequest root = requestRoot(request);
        root.getUser().removeRequest(root);
        allOffers.add(request);
    }

    /**
     * Declines a request, removing it from both users' current requests.
     * @param request The request to be declined.
     */
    @Override
    public void declineRequest(IRequest request){
        deleteCurrent(request);
    }

    /**
     * Removes a request from the list of active requests permanently.
     * @param request The request to be removed.
     */
    @Override
    public void trashRequest(IRequest request){
        allActiveRequests.remove(request);
    }

    @Override
    public String nameFromID(String requestID, String userName) {
        ProfileInterface pm = new ProfileManager();
        IUser user = pm.getUserFromName(userName);
        ArrayList<IRequest> allRequests = getAllRequests(user);
        for (IRequest request: allRequests){
            if (String.valueOf(request.getRequestId()).equals(requestID)){
                return request.getUser().getUserName();
            }
        }
        return null;
    }

    @Override
    public String productFromID(String requestID, String userName) {
        ProfileInterface pm = new ProfileManager();
        IUser user = pm.getUserFromName(userName);
        ArrayList<IRequest> allRequests = getAllRequests(user);
        for (IRequest request: allRequests){
            if (String.valueOf(request.getRequestId()).equals(requestID)){
                return request.getProdName();
            }
        }
        return null;
    }

    @Override
    public String quantityFromID(String requestID, String userName) {
        return null;
    }

    @Override
    public String priceFromID(String requestID, String userName) {
        return null;
    }

    @Override
    public ArrayList<String> coFromID(String requestID, String userName) {
        return null;
    }

    @Override
    public String previousIDFromID(String requestID, String userName) {
        return null;
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
    private void deleteCurrent(IRequest request){
        IUser previousUser = request.getPrevious().getUser();
        request.getUser().removeRequest(request);
        previousUser.removeRequest(request);
    }

    public ArrayList<IRequest> getAllActiveRequests(){
        return allActiveRequests;
    }

    private ArrayList<IRequest> getAllRequests(IUser user){
        ArrayList<IRequest> allRequests = new ArrayList<>();
        allRequests.addAll(user.getCurrentRequests());
        allRequests.addAll(user.getOfferHistory());
        return allRequests;
    }


}
