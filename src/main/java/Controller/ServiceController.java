package Controller;

import Entities.*;
import UI.ErrorThrower;
import UseCases.*;

import java.util.ArrayList;

public class ServiceController implements ControllerInterface{

    /**
     * Creates a profile if inputs are valid.
     * @param name Name of the user.
     * @param address Address of the user.
     * @param flag Boolean representing farmer/distributor
     */
    @Override
    public void createProfileCheck(String name, String address, boolean flag) {
        ProfileInterface pm = new ProfileManager();
        if (isAlphanumeric(name) && isAlphanumeric(address)){
            if (isUniqueName(name)){
                if (flag){
                    pm.createFarmer(name, address);
                } else {
                    pm.createDistributor(name, address);
                }
            } else {
                ErrorThrower.message("That name has been taken.");
            }

        } else {
            ErrorThrower.message("Your input must be alphanumeric.");
        }
    }

    /**
     * Modifies a user's profile if inputs are valid.
     * @param user User to be modified.
     * @param newName User's new name.
     * @param address User's new address.
     */
    @Override
    public void modifyUserCheck(IUser user, String newName, String address) {
        ProfileInterface pm = new ProfileManager();
        if (isAlphanumeric(newName) && isAlphanumeric(address)){
            if (isUniqueName(newName)){
                pm.modifyUser(user, newName, address);
            } else {
                ErrorThrower.message("That name has been taken.");
            }
        } else {
            ErrorThrower.message("Your input must be alphanumeric.");
        }
    }

    /**
     * Modifies a farmer's preferences if inputs are valid.
     * @param farmer Farmer to be modified.
     * @param slider1 Farmer's new price preference.
     * @param slider2 Farmer's new exposure preference.
     * @param slider3 Farmer's new speed preference.
     * @param slider4 Farmer's new carbon preference.
     */
    @Override
    public void modifyFarmerCheck(IFarmer farmer, double slider1, double slider2, double slider3, double slider4){
        ProfileInterface pm = new ProfileManager();
        pm.modifyFarmer(farmer, slider1, slider2, slider3, slider4);
    } // Nothing to check, but there may be in future

    /**
     * Modifies a distributor's criteria if inputs are valid.
     * @param dist Distributor to be modified.
     * @param slider2 Distributor's new exposure preference.
     * @param slider3 Distributor's new speed preference.
     * @param slider4 Distributor's new carbon preference.
     */
    @Override
    public void modifyDistributorCheck(IDistributor dist, double slider2, double slider3, double slider4){
        ProfileInterface pm = new ProfileManager();
        pm.modifyDistributor(dist, slider2, slider3, slider4);
    } // Nothing to check, but there may be in future

    /**
     * Creates a request if inputs are valid.
     * @param user User creating the request.
     * @param product Product which is being sold.
     * @param quantity Quantity in kg of product being sold.
     * @param price Price per kg of product being sold.
     */
    @Override
    public void createRequestCheck(IUser user, String product, String quantity, String price){
        RequestInterface rm = new RequestManager();
        if (isAlphanumeric(product)){
            if (isValidQuantity(quantity)){
                if (isValidPrice(price)){
                    rm.createRequest(user, product, Double.parseDouble(quantity), Double.parseDouble(price));
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
     * @param user User creating counteroffer.
     * @param request Request which is being countered.
     * @param quantity New quantity in kg of product.
     * @param price New price per kg of product.
     */
    @Override
    public void createCounterOfferCheck(IUser user, IRequest request, String quantity, String price){
        RequestInterface rm = new RequestManager();
        if (isValidQuantity(quantity)){
            if (isValidPrice(price)){
                rm.createCounterOffer(user, request, Double.parseDouble(quantity), Double.parseDouble(price));
            }
        }
    }

    /**
     * Accepts a request if inputs are valid.
     * @param request Request to be accepted.
     */
    @Override
    public void acceptRequestCheck(IRequest request){
        RequestInterface rm = new RequestManager();
        rm.acceptRequest(request);
    } // Nothing to check for now, but there may be in future

    /**
     * Declines a request if inputs are valid.
     * @param request Request to be declined.
     */
    @Override
    public void declineRequestCheck(IRequest request){
        RequestInterface rm = new RequestManager();
        rm.declineRequest(request);
    } // Nothing to check for now, but there may be in future

    /**
     * Trashes a request if inputs are valid.
     * @param request Request to be trashed.
     */
    @Override
    public void trashRequestCheck(IRequest request){
        RequestInterface rm = new RequestManager();
        rm.trashRequest(request);
    } // Nothing to check for now, but there may be in future

    /**
     * Ranks distributors according to farmer preferences.
     * @param distributors Distributors to be ranked.
     * @param farmer Farmer whose preferences must be known.
     * @param product Product being sold.
     * @return A list of distributors sorted by ranking.
     */
    @Override
    public ArrayList<IDistributor> rank(ArrayList<IDistributor> distributors, IFarmer farmer, String product){
        RankInterface rm = new RankingManager(distributors, farmer, product);
        return rm.rankDistributors();

    }

    /**
     * Placeholder fetch method.
     * @param obj Object to be fetched.
     * @return Object fetched.
     */
    @Override
    public Object fetch(Object obj){
        return null;
    } // For now, link to this method if you can't fetch an object without violating Clean Architecture.

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
        for (String name: pm.getAllNames()){
            if (input.equals(name)){
                return false;
            }
        }
        return true;
    }

}
