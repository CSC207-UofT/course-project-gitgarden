import java.util.Scanner;

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
 */
public class ServiceController {


    /**
     * Checks if the input is alphanumeric.
     * @param input     Input to the program
     * @return boolean that indicates if the input is alphanumeric.
     * TODO: maybe an exception class for all the exceptions in the program
     */
    public static boolean isAlphanumeric(String input) throws Exception{
        if (!input.matches("^[a-zA-Z0-9]*$")){
            throw new Exception("Your input is invalid");
        } else {
            return true;
        }
    }


    /**
     * Checks if the input is binary(yes or no)
     * @param input     Input from the user
     * @return boolean that indicates if the input is indicating yes/no. Exception
     *         if the string is empty or blank.
     */
    public static boolean isBinary(String input) throws Exception{
        String convertedInput = input.toLowerCase();
        if (input.isEmpty() || input.isBlank()){
            throw new Exception("Your input is invalid");
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
    public static boolean isNumeric(String input) throws Exception{
        if (input.isEmpty() || input.isBlank()){
            throw new Exception("Your input is invalid");
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
