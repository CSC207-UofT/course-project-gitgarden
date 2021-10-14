import java.util.ArrayList;
import java.util.Hashmap;
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
    public static ArrayList <User> users = new ArrayList<User>();
    public static Hashmap<String, User> userIdMap= new Hashmap<>();
    /**
     * Method to create profile from the given strings from ServiceController
     * @param name Name of the user
     * @param id id of the user
     */
    public static createUser(String name, String id)
    {
        //TODO: need to figure out if we create farmer/distributors or Users
        User user = new User(name, id);
        users.add(user);
        userIdMap.put(user.id, user);
    }

    /**
     * Modify users based on input
     * @param id the id of the user we are modifying
     * @param newName new name that the user wants to set
     */
    public static modifyUsername (String id,String newName){
        userIdMap.get(id).setName(newname);
    }
    /**
     *
     * @param id the id of the user we are modifying
     * @param newAddress new address that the user wants to set
     */
    public static modifyaddress(String id, String newAddress){
        userIdMap.get(id).setAddress(newAddress);
    }
}
