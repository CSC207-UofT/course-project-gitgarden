package Controller;

import UseCases.*;

import java.util.ArrayList;
import java.util.Random;

public class ServiceController implements ControllerInterface{
    private static final int LOWER_BOUND = 100000000;
    private static final int UPPER_BOUND = 800000000;
    private static final ProfileInterface profileManager = new ProfileManager();
    private static final RequestInterface requestManager = new RequestManager();

    /**
     * Creates a profile if inputs are valid.
     * @param name Name of the user.
     * @param address Address of the user.
     * @param flag Boolean representing farmer/distributor
     */
    @Override
    public String createProfileCheck(String name, String address, boolean flag) throws Exception{
        int id = uniqueUserId();
        if (isValidName(name)){
            if (isValidAddress(address)){
                if (isUniqueName(name)){
                    if (flag) { profileManager.createFarmer(name, address, id); }
                    else { profileManager.createDistributor(name, address, id); }
                } else { throw new Exception("That name has been taken."); }
            } else { throw new Exception("Please enter an alphanumeric address."); }
        } else { throw new Exception("Please enter an alphanumeric name containing at least one letter."); }
        return String.valueOf(id);
    }

    /**
     * Modifies a user's profile if inputs are valid.
     * @param id ID of User to be modified.
     * @param newName User's new name.
     * @param address User's new address.
     */
    @Override
    public void modifyUserCheck(String id, String newName, String address) throws Exception {
        IFetch dp = new DataPresenter();
        String oldName = dp.fetchUserName(id);
        if (isValidName(newName)){
            if (isValidAddress(address)){
                if (isUniqueName(newName) || oldName.equals(newName)){
                    profileManager.modifyUser(id, newName, address);
                } else { throw new Exception("That name has been taken."); }
            } else { throw new Exception("Please enter an alphanumeric address."); }
        } else { throw new Exception("Please enter an alphanumeric name containing at least one letter."); }
    }

    /**
     * Modifies a farmer's preferences if inputs are valid.
     * @param id ID of farmer to be modified.
     * @param slider1 Farmer's new price preference.
     * @param slider2 Farmer's new exposure preference.
     * @param slider3 Farmer's new speed preference.
     * @param slider4 Farmer's new carbon preference.
     */
    @Override
    public void modifyFarmerCheck(String id, double slider1, double slider2, double slider3, double slider4){
        profileManager.modifyFarmer(id, slider1, slider2, slider3, slider4);
    } // Nothing to check, but there may be in future

    /**
     * Modifies a distributor's criteria if inputs are valid.
     * @param id ID of distributor to be modified.
     * @param slider2 Distributor's new exposure preference.
     * @param slider3 Distributor's new speed preference.
     * @param slider4 Distributor's new carbon preference.
     */
    @Override
    public void modifyDistributorCheck(String id, double slider2, double slider3, double slider4){
        profileManager.modifyDistributor(id, slider2, slider3, slider4);
    } // Nothing to check, but there may be in future

    /**
     * Creates a request if inputs are valid.
     * @param id ID of user creating the request.
     * @param product Product which is being sold.
     * @param quantity Quantity in kg of product being sold.
     * @param price Price per kg of product being sold.
     */
    @Override
    public void createRequestCheck(String id, String product, String quantity, String price) throws Exception{
        if (isAlphabetic(product)){
            if (isValidQuantity(quantity)){
                if (isValidPrice(price)){
                    requestManager.createRequest(uniqueRequestId(), id, product, Double.parseDouble(quantity), Double.parseDouble(price));
                } else {
                    throw new Exception("Your price input must have two decimal places.");
                }
            } else {
                throw new Exception("Your quantity input must be numeric.");
            }
        } else {
            throw new Exception("Your product input must be alphabetic.");
        }
    }

    /**
     * Creates a counteroffer if inputs are valid.
     * @param id ID of user creating counteroffer.
     * @param requestID ID of request which is being countered.
     * @param quantity New quantity in kg of product.
     * @param price New price per kg of product.
     */
    @Override
    public void createCounterOfferCheck(String id, String requestID, String quantity, String price) throws Exception{
        if (isValidQuantity(quantity)){
            if (isValidPrice(price)){
                requestManager.createCounterOffer(uniqueRequestId(), id, requestID, Double.parseDouble(quantity), Double.parseDouble(price));
            } else {
                throw new Exception("Your price input must have two decimal places.");
            }
        } else {
            throw new Exception("Your quantity input must be numeric.");
        }
    }

    /**
     * Accepts a request if inputs are valid.
     * @param requestID ID of request to be accepted.
     */
    @Override
    public void acceptRequestCheck(String requestID, String userID){
        requestManager.acceptRequest(requestID);
    } // Nothing to check for now, but there may be in future

    /**
     * Declines a request if inputs are valid.
     * @param requestID ID of request to be declined.
     */
    @Override
    public void declineRequestCheck(String requestID, String userId){
        requestManager.declineRequest(requestID);
    } // Nothing to check for now, but there may be in future

    /**
     * Trashes a request if inputs are valid.
     * @param requestID ID of request to be trashed.
     */
    @Override
    public void trashRequestCheck(String requestID){
        requestManager.trashRequest(requestID);
    } // Nothing to check for now, but there may be in future

    /**
     * Ranks distributors according to farmer preferences.
     * @param requestID Request whose counteroffers are to be ranked.
     * @param farmerID ID of farmer whose preferences must be known.
     * @return A list of distributors sorted by ranking.
     */
    @Override
    public ArrayList<String> rank(String requestID, String farmerID){
        RankInterface rankInterface = new RankingManager(requestID, farmerID);
        return rankInterface.rankDistributors();

    }

    /**
     * Checks if the input is a valid name.
     * @param input Input from the user.
     * @return boolean that indicates if the name is valid.
     */
    public boolean isValidName(String input){
        return input.matches("^\\d*[a-zA-Z][a-zA-Z0-9]*$");
    }

    /**
     * Checks if the input is a valid address.
     * @param input Input from the user.
     * @return boolean that indicates if the input is valid.
     */
    public boolean isValidAddress(String input){
        return input.matches("^[\\sa-zA-Z0-9]+$");
    }

    /**
     * Checks if the input is alphabetic.
     * @param input Input from the user.
     * @return boolean that indicates if the input is alphabetic.
     */
    public boolean isAlphabetic(String input){
        return input.matches("^[a-zA-Z]+$");
    }

    /**
     * Checks if the input is a valid quantity.
     * @param input Input from the user.
     * @return boolean that indicates if the input is valid.
     */
    public boolean isValidQuantity(String input){
        return input.matches("^[0-9]+(\\.[0-9])?[0-9]*$");
    }

    /**
     * Checks if the input is a valid price.
     * @param input Input from the user.
     * @return boolean that indicates if the input is valid.
     */
    public boolean isValidPrice(String input){
        return input.matches("^[0-9]+\\.[0-9]{2}$");
    }

    /**
     * Checks if name is unique.
     * @param input Input from the user.
     * @return boolean that indicates if the name is unique.
     */
    public boolean isUniqueName(String input){
        ProfileInterface pm = new ProfileManager();
        ArrayList<String> names = new ArrayList<>();
        names.addAll(pm.getAllFarmerNames());
        names.addAll(pm.getAllDistNames());
        for (String name: names){
            if (input.equals(name)){
                return false;
            }
        }
        return true;
    }

    private int uniqueUserId(){
        ProfileInterface pm = new ProfileManager();
        ArrayList<Integer> ids = pm.getAllIds();
        Random random = new Random();
        int id = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
        while (ids.contains(id)){
            id = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
        }
        return id;
    }

    private int uniqueRequestId(){
        RequestInterface requestManager = new RequestManager();
        ArrayList<Integer> ids = requestManager.getAllRequestIds();
        Random random = new Random();
        int id = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
        while (ids.contains(id)){
            id = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
        }
        return id;
    }
}
