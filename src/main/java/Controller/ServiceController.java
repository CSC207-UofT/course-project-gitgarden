package Controller;

import Entities.Distributor;
import UseCases.MatchManager;
import UseCases.ProfileManager;

import java.util.ArrayList;
import java.util.HashMap;

/* Controller.ServiceController
 * Responsibilities:
 *      Accept or decline inputs from UI.UserInterface
 *      Make variables for UseCases.ProfileManager and MatchSystem if the input is acceptable
 *      Report exception if the input is unacceptable
 *
 * Collaborators:
 *      UI.UserInterface
 *      UseCases.ProfileManager
 *      MatchSystem
 *
 */

public class ServiceController {

    /**
     * Method for UI.UserInterface, pass parameters to UseCases.ProfileManager if the input is valid
     * @param name  Name of the user
     * @param address   Address of the user
     */
    public static void createProfile(String name, String address, HashMap<String, Double> prodMap) throws Exception{
        if (isAlphanumeric(name)){
            ProfileManager.createDistributor(name, address, prodMap);
        } else {
            throw new Exception("Your input is not valid!");
        }
    }


    /**
     * Method for UI.UserInterface, pass parameters to UseCases.ProfileManager if the input is valid
     * @param product   Name of the product
     * @param quantity  Quantity of the product
     * @param price     Price of the product per kilogram
     */
    public static ArrayList<Distributor> createRequest(String product, String quantity, String price)
            throws Exception{
        if (isAlphanumeric(product) && isNumeric(quantity) && isNumeric(price)){
            ArrayList<Distributor> distributors = ProfileManager.distributorList;
            return MatchManager.match(distributors, product, price);
        } else {
            throw new Exception("Your input is not valid!");
        }
    }


    /**
     * Checks if the input is alphanumeric.
     * @param input     Input to the program
     * @return boolean that indicates if the input is alphanumeric.
     */
    public static boolean isAlphanumeric(String input){
        return input.matches("^[a-zA-Z0-9]*$");
    }


    /**
     * Checks if the input is numeric
     * @param input     Input from the user
     * @return boolean that indicates if the input is numeric. Exception if the
     *         string is empty or blank.
     */
    public static boolean isNumeric(String input){
        return !input.isEmpty() && !input.isBlank();
    }

}