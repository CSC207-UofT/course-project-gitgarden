import java.util.ArrayList;
import java.util.HashMap;
// import java.util.Hashmap;
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
    public static ArrayList<User> farmerList = new ArrayList<User>();
    public static ArrayList<Distributor> distributorList = new ArrayList<Distributor>();
    public HashMap<String, Double> patrick = new HashMap<>();

    public static void main(String[] args) {
        HashMap<String, Double> patrick = new HashMap<String, Double>();
        patrick.put("apple", 12.00);
        patrick.put("rice", 10.00);
        distributorList.add(new Distributor("Divit", "123 toronto", patrick));
        distributorList.add(new Distributor("Patrick", "234 toronto",patrick));
    }
}
    // public static Hashmap<String, User> userIdMap= new Hashmap<>();
//
//    /**
//     * Method to create profile from the given strings from ServiceController
//     *
//     * @param name Name of the user
//     * @param id   id of the user
//     */
//    public static createFarmer(String name, String id) {
//        //TODO: need to figure out if we create farmer/distributors or Users
//        User user = new User(name, id);
//        farmerList.add(user);
//        // userIdMap.put(user.id, user);
//    }
//
//    public static createDistributor(String name, String id) {
//        User user = new User(name, id);
//        distributorList.add(user);
//    }

//    /**
//     * Modify users based on input
//     * @param id the id of the user we are modifying
//     * @param newName new name that the user wants to set
//     */
////    public static modifyUsername (String id,String newName){
////        userIdMap.get(id).setName(newname);
////    }
//
//    /**
//     *
//     * @param id the id of the user we are modifying
//     * @param newAddress new address that the user wants to set
//     */
//    public static modifyaddress(String id, String newAddress){
//        userIdMap.get(id).setAddress(newAddress);
//    }
//}


