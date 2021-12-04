package UseCases;

import Entities.*;

import java.util.ArrayList;

public class ProfileManager implements ProfileInterface{
    private static final ArrayList<IFarmer> farmerList = new ArrayList<>();
    private static final ArrayList<IDistributor> distributorList = new ArrayList<>();

    /**
     * Creates a Farmer profile.
     * @param name The farmer's username.
     * @param address The farmer's address.
     * @param id The farmer's ID.
     */
    @Override
    public void createFarmer(String name, String address, int id){
        IFarmer farmer = new Farmer(name, address, id);
        ProfileManager.farmerList.add(farmer);
    }

    /**
     * Creates a Distributor profile.
     * @param name The distributor's username.
     * @param address The distributor's address.
     * @param id The distributor's ID.
     */
    @Override
    public void createDistributor(String name, String address, int id){
        IDistributor dist = new Distributor(name, address, id);
        ProfileManager.distributorList.add(dist);
    }

    /**
     * Modifies user attributes.
     * @param id The ID of the user to be modified.
     * @param newName The new name of the user.
     * @param address The new address of the user.
     */
    @Override
    public void modifyUser(String id, String newName, String address){
        IUser user = getUserFromId(id);
        user.setUserName(newName);
        user.setUserAddress(address);
    }

    /**
     * Modifies farmer attributes.
     * @param id The ID of the farmer to be modified.
     * @param slider1 The new price preference of the farmer.
     * @param slider2 The new exposure preference of the farmer.
     * @param slider3 The new speed preference of the farmer.
     * @param slider4 The new carbon preference of the farmer.
     */
    @Override
    public void modifyFarmer(String id, double slider1, double slider2, double slider3, double slider4){
        IFarmer farmer = (IFarmer) getUserFromId(id);
        farmer.setPrefPrice(slider1);
        farmer.setPrefExposure(slider2);
        farmer.setPrefSpeed(slider3);
        farmer.setPrefCarbon(slider4);
    }

    /**
     * Modifies distributor attributes.
     * @param id The ID of the distributor to be modified.
     * @param slider2 The new exposure attribute of the distributor.
     * @param slider3 The new speed attribute of the distributor.
     * @param slider4 The new carbon attribute of the distributor.
     */
    @Override
    public void modifyDistributor(String id, double slider2, double slider3, double slider4){
        IDistributor dist = (IDistributor) getUserFromId(id);
        dist.setExposure(slider2);
        dist.setSpeed(slider3);
        dist.setCarbon(slider4);
    }

    /**
     * Gets all farmer names.
     * @return All farmer names.
     */
    @Override
    public ArrayList<String> getAllFarmerNames(){
        ArrayList<String> names = new ArrayList<>();
        for (IUser user: farmerList){
            names.add(user.getUserName());
        }
        return names;
    }

    /**
     * Gets all distributor names.
     * @return All distributor names.
     */
    @Override
    public ArrayList<String> getAllDistNames(){
        ArrayList<String> names = new ArrayList<>();
        for (IUser user: distributorList){
            names.add(user.getUserName());
        }
        return names;
    }

    /**
     * Gets all user IDs.
     * @return All user IDs.
     */
    @Override
    public ArrayList<Integer> getAllIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<IUser> users = new ArrayList<>();
        users.addAll(farmerList);
        users.addAll(distributorList);
        for (IUser user: users){
            ids.add(user.getUserId());
        }
        return ids;
    }

    /**
     * Gets the list of all farmers.
     * @return farmerList.
     */
    @Override
    public ArrayList<IFarmer> getFarmerList() {
        return farmerList;
    }

    /**
     * Gets the list of all distributors.
     * @return distributorList.
     */
    @Override
    public ArrayList<IDistributor> getDistributorList() {
        return distributorList;
    }

    /**
     * Gets a user's address based on ID.
     * @param id ID of the user whose address must be found.
     * @return The user's address.
     */
    @Override
    public String addressFromId(String id) {
        IUser user = getUserFromId(id);
        return user.getUserAddress();
    }

    /**
     * Gets a user's name based on ID.
     * @param id ID of the user whose name must be found.
     * @return The user's name.
     */
    @Override
    public String nameFromId(String id) {
        IUser user = getUserFromId(id);
        return user.getUserName();
    }

    /**
     * Gets a user's ID based on name.
     * @param name Name of the user whose ID must be found.
     * @return The user's ID.
     */
    @Override
    public String idFromName(String name) {
        IUser user = getUserFromName(name);
        return String.valueOf(user.getUserId());
    }

    /**
     * Gets a user's current requests based on ID.
     * @param id ID of the user whose current requests must be found.
     * @return The user's current requests.
     */
    @Override
    public ArrayList<String> requestsFromId(String id) {
        RequestManager rm = new RequestManager();
        IUser user = getUserFromId(id);
        return rm.requestToId(user.getCurrentRequests());
    }

    /**
     * Gets a user's offer history based on ID.
     * @param id ID of the user whose offer history must be found.
     * @return The user's offer history.
     */
    @Override
    public ArrayList<String> historyFromId(String id) {
        RequestManager rm = new RequestManager();
        IUser user = getUserFromId(id);
        return rm.requestToId(user.getOfferHistory());
    }

    /**
     * Gets a user based on ID.
     * @param id ID of the user who must be found.
     * @return The user.
     */
    @Override
    public IUser getUserFromId(String id){
        ArrayList<IUser> userList = new ArrayList<>(ProfileManager.farmerList);
        userList.addAll(ProfileManager.distributorList);
        for (IUser user : userList) {
            if (String.valueOf(user.getUserId()).equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Gets a user based on name.
     * @param name Name of the user who must be found.
     * @return The user.
     */
    @Override
    public IUser getUserFromName(String name){
        ArrayList<IUser> userList = new ArrayList<>(ProfileManager.farmerList);
        userList.addAll(ProfileManager.distributorList);
        for (IUser user : userList) {
            if (String.valueOf(user.getUserName()).equals(name)) {
                return user;
            }
        }
        return null;
    }
}
