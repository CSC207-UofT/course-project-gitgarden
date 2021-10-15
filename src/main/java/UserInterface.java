/* UserInterface
 * Responsibilities:
 *      Display an interface to interact with the program
 *      Display results if valid information is entered
 *      Display exception if invalid information is entered
 *      Pass inputs to ServiceController
 *
 * Collaborators:
 *      ServiceController
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface
{
    String name = "";
    String address = "";
    String productName = "";
    String productQuantity = "";
    String productPrice = "";

    public static void main(String[] args) throws Exception {
        UserInterface ui = new UserInterface();

        // Sample data used for phase 0
        HashMap<String, Double> h1 = new HashMap<>();
        h1.put("Orange", 3.19);
        h1.put("Lemon", 0.89);
        ServiceController.createProfile("Onyx", "A", h1);

        HashMap<String, Double> h2 = new HashMap<>();
        h2.put("Orange", 2.15);
        h2.put("Lemon", 1.00);
        ServiceController.createProfile("Mark", "B", h2);

        HashMap<String, Double> h3 = new HashMap<>();
        h3.put("Orange", 3.00);
        h3.put("Lemon", 0.99);
        ServiceController.createProfile("Patrick", "C", h3);

        HashMap<String, Double> h4 = new HashMap<>();
        h4.put("Orange", 3.09);
        h4.put("Lemon", 1.19);
        ServiceController.createProfile("Andy", "D", h4);

        ui.GetUserInfo();
    }

    public void GetUserInfo() throws Exception {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Create a new profile (Type 'Yes' to continue)");
        String input = reader.nextLine(); // Scans the next token of the input as a string.

        if (input.equals("Yes"))
        {
            System.out.println("Enter name.");
            name = reader.nextLine();
            System.out.println("Enter address.");
            address = reader.nextLine();
            //ServiceController.createProfile(name, address, new HashMap<String, Double>());
            System.out.println("Account Created. Create a new request? (Type 'Yes' to continue)");
            input = reader.nextLine();

            if (input.equals("Yes"))
            {
                System.out.println("Enter product name.");
                productName = reader.nextLine();

                while(!(productQuantity.matches("[0123456789.]+") && !productQuantity.equals("") &&
                        !productQuantity.contains(".")))
                {
                    System.out.println("Enter product quantity in kilograms.");
                    productQuantity = reader.nextLine();
                }

                while(!(productPrice.matches("[0123456789.]+") && !productPrice.equals("") &
                        (productPrice.length() - productPrice.replace(".", "").length() == 1 ||
                                !productPrice.contains("."))))
                {
                    System.out.println("Enter product price per kilograms.");
                    productPrice = reader.nextLine();
                }

                ArrayList<Distributor> matchList = ServiceController.createRequest(productName, productQuantity, productPrice);

                if (matchList.size() != 0) {
                    System.out.println("Request created and processed. The list of available distributors is as follows: ");

                    for (int i = 0; i < matchList.size(); i++) {
                        int num = i + 1;
                        System.out.println(num + ") " + matchList.get(i));
                    }

                    System.out.println("Pick a distributor. (Type the number corresponding to the position in the list)");
                    int distributorNumber = reader.nextInt();

                    if (1 <= distributorNumber &  distributorNumber <= matchList.size())
                    {
                        System.out.println("You picked: " + matchList.get(distributorNumber - 1) + ". Request complete.");
                    }
                }
                else
                {
                    System.out.println("Sorry, there are no distributors available to take your request.");
                }
            }
        }
    }
}