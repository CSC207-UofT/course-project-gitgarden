package Controller;

import UseCases.ProfileInterface;
import UseCases.ProfileManager;
import UseCases.RequestInterface;
import UseCases.RequestManager;

import java.util.ArrayList;

public class DataPresenter implements IFetch{
    private final ProfileInterface profileManager;
    private final RequestInterface requestManager;

    public DataPresenter(ProfileInterface pm, RequestInterface rm){
        profileManager = pm;
        requestManager = rm;
    }
    /**
     * Fetches user's address based on ID.
     * @param id The ID of the user whose address must be found.
     * @return The address of the user.
     */
    public String fetchUserAddress(String id){
        return profileManager.addressFromId(id);
    }

    /**
     * Fetches user's name based on ID.
     * @param id The ID of the user whose name must be found.
     * @return The name of the user.
     */
    public String fetchUserName(String id){
        return profileManager.nameFromId(id);
    }

    /**
     * Fetches user's ID based on name.
     * @param userName The name of the user whose ID must be found.
     * @return The ID of the user.
     */
    public String fetchUserId(String userName){
        return profileManager.idFromName(userName);
    }

    /**
     * Fetches all farmer names.
     * @return The list of all farmer names.
     */
    public ArrayList<String> fetchAllFarmerNames(){
        return profileManager.getAllFarmerNames();
    }

    /**
     * Fetches all distributor names.
     * @return The list of all distributor names.
     */
    public ArrayList<String> fetchAllDistNames(){
        return profileManager.getAllDistNames();
    }

    /**
     * Fetches all user's current requests based on ID.
     * @param id The ID of the user whose current requests must be found
     * @return The list of all of user's current requests.
     */
    public ArrayList<String> fetchCurrentUserRequests(String id){
        return profileManager.requestsFromId(id);
    }

    /**
     * Fetches a user's offer history based on ID.
     * @param id The ID of the user whose offer history must be found.
     * @return The offer history of the user.
     */
    public ArrayList<String> fetchRequestHistory(String id){
        return profileManager.historyFromId(id);
    }

    /**
     * Fetches request information based on requestID.
     * @param requestID The ID of the request whose information must be found.
     * @return The request's information.
     */
    public String[] fetchRequestInformation(String requestID){
        String[] data = requestManager.dataFromId(requestID);
        if (data[2].matches("^[0-9]+\\.[0-9]$")){ data[2] = data[2] + "0";}
        return data;
    }

    /**
     * Fetches a request's counteroffers based on requestID.
     * @param requestID The ID of the request whose counteroffers must be found.
     * @return The counteroffers of the request.
     */
    public ArrayList<String> fetchCounteroffers(String requestID){
        return requestManager.coFromId(requestID);
    }

}
