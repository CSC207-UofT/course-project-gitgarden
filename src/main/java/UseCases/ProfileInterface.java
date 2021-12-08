package UseCases;

import Entities.*;

import java.util.ArrayList;

public interface ProfileInterface {

    /**
     * Creates a Farmer profile.
     * @param name The farmer's username.
     * @param address The farmer's address.
     * @param id The farmer's ID.
     */
    void createFarmer(String name, String address, int id);

    /**
     * Creates a Distributor profile.
     * @param name The distributor's username.
     * @param address The distributor's address.
     * @param id The distributor's ID.
     */
    void createDistributor(String name, String address, int id);

    /**
     * Modifies user attributes.
     * @param id The ID of the user to be modified.
     * @param newName The new name of the user.
     * @param address The new address of the user.
     */
    void modifyUser(String id, String newName, String address);

    /**
     * Modifies farmer attributes.
     * @param id The ID of the farmer to be modified.
     * @param slider1 The new price preference of the farmer.
     * @param slider2 The new exposure preference of the farmer.
     * @param slider3 The new speed preference of the farmer.
     * @param slider4 The new carbon preference of the farmer.
     */
    void modifyFarmer(String id, double slider1, double slider2, double slider3, double slider4);

    /**
     * Modifies distributor attributes.
     * @param id The ID of the distributor to be modified.
     * @param slider2 The new exposure attribute of the distributor.
     * @param slider3 The new speed attribute of the distributor.
     * @param slider4 The new carbon attribute of the distributor.
     */
    void modifyDistributor(String id, double slider2, double slider3, double slider4);

    /**
     * Gets all farmer names.
     * @return All farmer names.
     */
    ArrayList<String> getAllFarmerNames();

    /**
     * Gets all distributor names.
     * @return All distributor names.
     */
    ArrayList<String> getAllDistNames();

    /**
     * Gets all user IDs.
     * @return All user IDs.
     */
    ArrayList<Integer> getAllIds();

    /**
     * Gets the list of all farmers.
     * @return farmerList.
     */
    ArrayList<IFarmer> getFarmerList();

    /**
     * Gets the list of all distributors.
     * @return distributorList.
     */
    ArrayList<IDistributor> getDistributorList();

    /**
     * Gets a user's address based on ID.
     * @param id ID of the user whose address must be found.
     * @return The user's address.
     */
    String addressFromId(String id);

    /**
     * Gets a user's name based on ID.
     * @param id ID of the user whose name must be found.
     * @return The user's name.
     */
    String nameFromId(String id);

    /**
     * Gets a user's ID based on name.
     * @param name Name of the user whose ID must be found.
     * @return The user's ID.
     */
    String idFromName(String name);

    /**
     * Gets a user's current requests based on ID.
     * @param id ID of the user whose current requests must be found.
     * @return The user's current requests.
     */
    ArrayList<String> requestsFromId(String id);

    /**
     * Gets a user's offer history based on ID.
     * @param id ID of the user whose offer history must be found.
     * @return The user's offer history.
     */
    ArrayList<String> historyFromId(String id);

    /**
     * Gets a user based on ID.
     * @param id ID of the user who must be found.
     * @return The user.
     */
    IUser getUserFromId(String id);

    /**
     * Gets a user based on name.
     * @param name Name of the user who must be found.
     * @return The user.
     */
    IUser getUserFromName(String name);
}
