package Controller;

import java.util.ArrayList;

public interface IFetch {
    /**
     * Fetches user's address based on ID.
     * @param id The ID of the user whose address must be found.
     * @return The address of the user.
     */
    String fetchUserAddress(String id);

    /**
     * Fetches user's name based on ID.
     * @param id The ID of the user whose name must be found.
     * @return The name of the user.
     */
    String fetchUserName(String id);

    /**
     * Fetches user's ID based on name.
     * @param userName The name of the user whose ID must be found.
     * @return The ID of the user.
     */
    String fetchUserId(String userName);

    /**
     * Fetches all farmer names.
     * @return The list of all farmer names.
     */
    ArrayList<String> fetchAllFarmerNames();

    /**
     * Fetches all distributor names.
     * @return The list of all distributor names.
     */
    ArrayList<String> fetchAllDistNames();

    /**
     * Fetches all user's current requests based on ID.
     * @param id The ID of the user whose current requests must be found
     * @return The list of all of user's current requests.
     */
    ArrayList<String> fetchCurrentUserRequests(String id);

    /**
     * Fetches a user's offer history based on ID.
     * @param id The ID of the user whose offer history must be found.
     * @return The offer history of the user.
     */
    ArrayList<String> fetchRequestHistory(String id);

    /**
     * Fetches request information based on requestID.
     * @param requestID The ID of the request whose information must be found.
     * @return The request's information.
     */
    String[] fetchRequestInformation(String requestID);

    /**
     * Fetches a request's counteroffers based on requestID.
     * @param requestID The ID of the request whose counteroffers must be found.
     * @return The counteroffers of the request.
     */
    ArrayList<String> fetchCounteroffers(String requestID);

}
