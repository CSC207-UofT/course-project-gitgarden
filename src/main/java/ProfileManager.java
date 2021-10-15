import java.util.ArrayList;
import java.util.HashMap;
/**
 * ProfileManager
 * Responsibilities
 *
 * * Take variables from ServiceController
 * * Create Farmer/Distributor based on the given variables
 * * Modify Farmer/Distributor based on the given variables
 *
 * Collaborators:
 * * ServiceController
 * * Farmer
 * * Distributor
 *
 */

public class ProfileManager {
    //public static ArrayList<User> farmerList = new ArrayList<>();
    public static ArrayList<Distributor> distributorList = new ArrayList<>();

    public static void createDistributor(String name, String address, HashMap<String, Double> prodMap){
        Distributor dist = new Distributor(name, address, prodMap);
        distributorList.add(dist);

    }

}
