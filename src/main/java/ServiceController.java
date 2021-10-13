

/** ServiceController
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
 * TODO: maybe an exception class for all the exceptions in the program
 */

public class ServiceController {


    /**
     * Method for UserInterface, check if the input is a binary answer
     * @param ans   Input from the user
     * @return      Boolean indicating if the user has the correct binary input
     */
    public static boolean isYesNoAnswer(String ans) throws Exception{
        if (isBinary(ans)){
            return true;
        } else {
            throw new Exception("Your input is not valid!");
        }
    }


    /**
     * Method for UserInterface, pass parameters to ProfileManager if the input is valid
     * @param name  Name of the user
     * @param address   Address of the user
     * TODO: return type based on the method in Profile Manager
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
     * @param price     Price of the product
     * TODO: return type based on the method in Profile Manager
     */
    public static void createRequest(String product, String quantity, String price)
            throws Exception{
        if (isAlphanumeric(product) && isNumeric(quantity) && isNumeric(price)){
            //TODO: Call the method in MatchSystem
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
     * Checks if the input is binary(yes or no)
     * @param input     Input from the user
     * @return boolean that indicates if the input is indicating yes/no. Exception
     *         if the string is empty or blank.
     */
    public static boolean isBinary(String input){
        String convertedInput = input.toLowerCase();
        if (input.isEmpty() || input.isBlank()){
            return false;
        } else {
            return convertedInput.contains("yes") || convertedInput.contains("no");
        }
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
