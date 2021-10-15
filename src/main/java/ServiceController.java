import java.util.ArrayList;

/* ServiceController
 * Responsibilities:
 *      Accept or decline inputs from UserInterface
 *      Make variables for ProfileManager and MatchSystem if the input is acceptable
 *      Report exception if the input is unacceptable
 *
 * Collaborators:
 *      UserInterface
 *      ProfileManager
 *      MatchSystem
 *
 * TODO: Finalize the throw exception. Now UserInterface is fulfilling
 *       this task for ServiceController.
 */

public class ServiceController {

    /**
     * Method for UserInterface, pass parameters to ProfileManager if the input is valid
     * @param name  Name of the user
     * @param address   Address of the user
     * TODO: suppose that createProfile won't return anything to the user for now.
     *                  It could be a string containing feedback.
     * TODO: add another parameter to determine if the user is a farmer or distributor
     *                  (pass it to ProfileManager)
     */
    public static void createProfile(String name, String address) throws Exception{
        if (isAlphanumeric(name)){
            //TODO: Call the method in ProfileManager
        } else {
            throw new Exception("Your input is not valid!");
        }
    }


    /**
     * Method for UserInterface, pass parameters to ProfileManager if the input is valid
     * @param product   Name of the product
     * @param quantity  Quantity of the product
     * @param price     Price of the product per kilogram
     */
    public static ArrayList<Distributor> createRequest(String product, String quantity, String price)
            throws Exception{
        if (isAlphanumeric(product) && isNumeric(quantity) && isNumeric(price)){
            ArrayList<Distributor> distributors = ProfileManager.distributorList;
            return MatchSystem.match(distributors, product, price);
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
        if (input.isEmpty() || input.isBlank()){
            return false;
        } else {
            try {
                double d = Double.parseDouble(input);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }

}
