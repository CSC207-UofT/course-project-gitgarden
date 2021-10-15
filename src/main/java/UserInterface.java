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
import java.util.Scanner;

public class UserInterface
{
    String name;
    String address;
    String productName;
    String productQuantity;
    String productPrice;

    public void GetUserInfo(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Create a new profile (Type 'Yes' to continue)");
        String input = reader.nextLine(); // Scans the next token of the input as a string.

        if (input == "Yes")
        {
            System.out.println("Enter name.");
            name = reader.nextLine();
            System.out.println("Enter address.");
            address = reader.nextLine();
            ServiceController.createProfile(name, address);
            System.out.println("Account Created. Create a new request? (Type 'Yes' to continue)");

            if (input == "Yes")
            {
                System.out.println("Enter product name.");
                productName = reader.nextLine();

                while(!productQuantity.matches("[0123456789.]+") &
                        productQuantity.length() - productQuantity.replace(".", "").length() == 1)
                {
                    System.out.println("Enter product quantity in kilograms.");
                    productQuantity = reader.nextLine();
                }

                while(!productPrice.matches("[0123456789.]+") &
                        productPrice.length() - productPrice.replace(".", "").length() == 1)
                {
                    System.out.println("Enter product price per kilograms.");
                    productPrice = reader.nextLine();
                }

                ArrayList<Distributor> matchList = ServiceController.createRequest(productName, productQuantity, productPrice);
                System.out.println("Request created and processed. The list of available distributors is as follows: ");

                for (int i = 0; i < matchList.size(); i++) {
                    int num = i + 1;
                    System.out.println(num + ") " + matchList.get(i));
                }

                System.out.println("Pick a distributor. (Type the number corresponding to the position in the list)");
                int distributorNumber = reader.nextInt();

                if (1 <= distributorNumber &  distributorNumber < matchList.size())
                {
                    System.out.println("You picked: " + matchList.get(distributorNumber - 1) + ". Request complete.");
                }

            }
        }
    }
}
