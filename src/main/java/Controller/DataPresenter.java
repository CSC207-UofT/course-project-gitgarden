package Controller;

import UseCases.ProfileInterface;
import UseCases.ProfileManager;
import UseCases.RequestInterface;
import UseCases.RequestManager;

import java.util.ArrayList;

public class DataPresenter implements IFetch{
    /**
     * Fetches user's address based on ID.
     * @param id The ID of the user whose address must be found.
     * @return The address of the user.
     */
    public String fetchUserAddress(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.addressFromId(id);
    }

    /**
     * Fetches user's name based on ID.
     * @param id The ID of the user whose name must be found.
     * @return The name of the user.
     */
    public String fetchUserName(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.nameFromId(id);
    }

    /**
     * Fetches user's ID based on name.
     * @param userName The name of the user whose ID must be found.
     * @return The ID of the user.
     */
    public String fetchUserId(String userName){
        ProfileInterface pm = new ProfileManager();
        return pm.idFromName(userName);
    }

    /**
     * Fetches all farmer names.
     * @return The list of all farmer names.
     */
    public ArrayList<String> fetchAllFarmerNames(){
        ProfileInterface pm = new ProfileManager();
        return pm.getAllFarmerNames();
    }

    /**
     * Fetches all distributor names.
     * @return The list of all distributor names.
     */
    public ArrayList<String> fetchAllDistNames(){
        ProfileInterface pm = new ProfileManager();
        return pm.getAllDistNames();
    }

    /**
     * Fetches all user's current requests based on ID.
     * @param id The ID of the user whose current requests must be found
     * @return The list of all of user's current requests.
     */
    public ArrayList<String> fetchCurrentUserRequests(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.requestsFromId(id);
    }

    /**
     * Fetches a user's offer history based on ID.
     * @param id The ID of the user whose offer history must be found.
     * @return The offer history of the user.
     */
    public ArrayList<String> fetchRequestHistory(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.historyFromId(id);
    }

    /**
     * Fetches request information based on requestID.
     * @param requestID The ID of the request whose information must be found.
     * @return The request's information.
     */
    public String[] fetchRequestInformation(String requestID){
        RequestInterface rm = new RequestManager();
        String[] data = rm.dataFromId(requestID);
        if (data[2].matches("^[0-9]+\\.[0-9]$")){ data[2] = data[2] + "0";}
        return data;
    }

    /**
     * Fetches a request's counteroffers based on requestID.
     * @param requestID The ID of the request whose counteroffers must be found.
     * @return The counteroffers of the request.
     */
    public ArrayList<String> fetchCounteroffers(String requestID){
        RequestInterface rm = new RequestManager();
        return rm.coFromId(requestID);
    }

}
