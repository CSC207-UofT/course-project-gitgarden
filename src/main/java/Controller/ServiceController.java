package Controller;

import UI.ErrorThrower;
import UseCases.*;

import java.util.ArrayList;
import java.util.Random;

public class ServiceController implements ControllerInterface{
    private static final int LOWER_BOUND = 100000000;
    private static final int UPPER_BOUND = 800000000;

    /**
     * Creates a profile if inputs are valid.
     * @param name Name of the user.
     * @param address Address of the user.
     * @param flag Boolean representing farmer/distributor
     */
    @Override
    public String createProfileCheck(String name, String address, boolean flag) {
        ProfileInterface pm = new ProfileManager();
        int id = uniqueId();
        if (isAlphanumeric(name) && isAlphanumeric(address)){
            if (isUniqueName(name)){
                if (flag){
                    pm.createFarmer(name, address, id);
                } else {
                    pm.createDistributor(name, address, id);
                }
            } else {
                ErrorThrower.message("That name has been taken.");
            }

        } else {
            ErrorThrower.message("Your input must be alphanumeric.");
        }
        return String.valueOf(id);
    }

    /**
     * Modifies a user's profile if inputs are valid.
     * @param id ID of User to be modified.
     * @param newName User's new name.
     * @param address User's new address.
     */
    @Override
    public void modifyUserCheck(String id, String newName, String address) {
        ProfileInterface pm = new ProfileManager();
        if (isAlphanumeric(newName) && isAlphanumeric(address)){
            if (isUniqueName(newName)){
                pm.modifyUser(id, newName, address);
            } else {
                ErrorThrower.message("That name has been taken.");
            }
        } else {
            ErrorThrower.message("Your input must be alphanumeric.");
        }
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
        ProfileInterface pm = new ProfileManager();
        pm.modifyFarmer(id, slider1, slider2, slider3, slider4);
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
        ProfileInterface pm = new ProfileManager();
        pm.modifyDistributor(id, slider2, slider3, slider4);
    } // Nothing to check, but there may be in future

    /**
     * Creates a request if inputs are valid.
     * @param id ID of user creating the request.
     * @param product Product which is being sold.
     * @param quantity Quantity in kg of product being sold.
     * @param price Price per kg of product being sold.
     */
    @Override
    public void createRequestCheck(String id, String product, String quantity, String price){
        RequestInterface rm = new RequestManager();
        if (isAlphanumeric(product)){
            if (isValidQuantity(quantity)){
                if (isValidPrice(price)){
                    rm.createRequest(id, product, Double.parseDouble(quantity), Double.parseDouble(price));
                } else {
                    ErrorThrower.message("Your price input must have two decimal places.");
                }
            } else {
                ErrorThrower.message("Your quantity input must be numeric.");
            }
        } else {
            ErrorThrower.message("Your product input must be alphanumeric.");
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
    public void createCounterOfferCheck(String id, String requestID, String quantity, String price){
        RequestInterface rm = new RequestManager();
        if (isValidQuantity(quantity)){
            if (isValidPrice(price)){
                rm.createCounterOffer(id, requestID, Double.parseDouble(quantity), Double.parseDouble(price));
            }
        }
    }

    /**
     * Accepts a request if inputs are valid.
     * @param requestID ID of request to be accepted.
     */
    @Override
    public void acceptRequestCheck(String requestID, String userID){
        RequestInterface rm = new RequestManager();
        rm.acceptRequest(requestID);
    } // Nothing to check for now, but there may be in future

    /**
     * Declines a request if inputs are valid.
     * @param requestID ID of request to be declined.
     */
    @Override
    public void declineRequestCheck(String requestID, String userId){
        RequestInterface rm = new RequestManager();
        rm.declineRequest(requestID);
    } // Nothing to check for now, but there may be in future

    /**
     * Trashes a request if inputs are valid.
     * @param requestID ID of request to be trashed.
     */
    @Override
    public void trashRequestCheck(String requestID){
        RequestInterface rm = new RequestManager();
        rm.trashRequest(requestID);
    } // Nothing to check for now, but there may be in future

    /**
     * Ranks distributors according to farmer preferences.
     * @param distributors Distributors to be ranked.
     * @param farmerID ID of farmer whose preferences must be known.
     * @param product Product being sold.
     * @return A list of distributors sorted by ranking.
     */
    @Override
    public ArrayList<String> rank(ArrayList<String> distributors, String farmerID, String product){
        RankInterface rm = new RankingManager(distributors, farmerID, product);
        return rm.rankDistributors();

    }

    /**
     * Checks if the input is alphanumeric.
     * @param input Input from the user.
     * @return boolean that indicates if the input is alphanumeric.
     */
    public boolean isAlphanumeric(String input){
        return input.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Checks if the input is a valid quantity.
     * @param input Input from the user.
     * @return boolean that indicates if the input is valid. Exception if the string is empty or blank.
     */
    public boolean isValidQuantity(String input){
        return input.matches("^[0-9]+(\\.[0-9])?[0-9]*$");
    }

    /**
     * Checks if the input is a valid price.
     * @param input Input from the user.
     * @return boolean that indicates if the input is valid. Exception if the string is empty or blank.
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

    private int uniqueId(){
        ProfileInterface pm = new ProfileManager();
        ArrayList<Integer> ids = pm.getAllIds();
        Random random = new Random();
        int id = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
        while (ids.contains(id)){
            id = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
        }
        return id;

    }

}
