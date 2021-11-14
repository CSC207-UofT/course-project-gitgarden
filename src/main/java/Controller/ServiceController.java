package Controller;

import Entities.IFarmer;
import Entities.IDistributor;
import Entities.IUser;
import UI.ErrorThrower;
import UseCases.ProfileInterface;
import UseCases.RankInterface;
import UseCases.RankingManager;
import UseCases.RequestManager;

import java.util.ArrayList;

public class ServiceController {

    /**
     * Method for UserInterface, pass parameters to ProfileManager if the input is valid
     * @param name  Name of the user
     * @param address   Address of the user
     */
    public static void createProfileCheck(String name, String address, boolean flag) {
        if (isAlphanumeric(name) && isAlphanumeric(address)){
            if (isUniqueName(name)){
                if (flag){
                    ProfileInterface.createFarmer(name, address);
                } else {
                    ProfileInterface.createDistributor(name, address);
                }
            } else {
                ErrorThrower.message("That name has been taken.");
            }

        } else {
            ErrorThrower.message("Your input must be alphanumeric.");
        }
    }

    public static void modifyUserCheck(IUser user, String newName, String address) {
        if (isAlphanumeric(newName) && isAlphanumeric(address)){
            if (isUniqueName(newName)){
                ProfileInterface.modifyUser(user, newName, address);
            } else {
                ErrorThrower.message("That name has been taken.");
            }
        } else {
            ErrorThrower.message("Your input must be alphanumeric.");
        }
    }

    public static void modifyFarmerCheck(IFarmer farmer, double slider1, double slider2, double slider3, double slider4){
        ProfileInterface.modifyFarmer(farmer, slider1, slider2, slider3, slider4);
    } // Nothing to check, but there may be in future

    public static void modifyDistributorCheck(IDistributor dist, double slider2, double slider3, double slider4){
        ProfileInterface.modifyDistributor(dist, slider2, slider3, slider4);
    } // Nothing to check, but there may be in future

    public static void createRequestCheck(String product, String quantity, String price){
        if (isAlphanumeric(product)){
            if (isValidQuantity(quantity)){
                if (isValidPrice(price)){
                    RequestManager.createRequest(product, Double.parseDouble(quantity), Double.parseDouble(price));
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

    public static ArrayList<IDistributor> rank(ArrayList<IDistributor> distributors, IFarmer farmer, String product){
        RankInterface rm = new RankingManager(distributors, farmer, product);
        return rm.rankDistributors();

    }

    /**
     * Checks if the input is alphanumeric.
     * @param input Input from the user.
     * @return boolean that indicates if the input is alphanumeric.
     */
    public static boolean isAlphanumeric(String input){
        return input.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Checks if the input is a valid quantity.
     * @param input Input from the user.
     * @return boolean that indicates if the input is valid. Exception if the string is empty or blank.
     */
    public static boolean isValidQuantity(String input){
        return input.matches("^[0-9]+(\\.[0-9])?[0-9]*$");
    }

    /**
     * Checks if the input is a valid price.
     * @param input Input from the user
     * @return boolean that indicates if the input is valid. Exception if the string is empty or blank.
     */
    public static boolean isValidPrice(String input){
        return input.matches("^[0-9]+\\.[0-9]{2}$");
    }

    public static boolean isUniqueName(String input){
        for (String name: ProfileInterface.getAllNames()){
            if (input.equals(name)){
                return false;
            }
        }
        return true;
    }

}
