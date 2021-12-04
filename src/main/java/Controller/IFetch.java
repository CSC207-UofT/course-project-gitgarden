package Controller;

import java.util.ArrayList;

public interface IFetch {
    String fetchUserAddress(String id);

    String fetchUserName(String id);

    String fetchUserId(String UserName);

    ArrayList<String> fetchAllFarmerNames();

    ArrayList<String> fetchAllDistNames();

    ArrayList<String> fetchCurrentUserRequests(String id);

    ArrayList<String> fetchRequestHistory(String id);

    String[] fetchRequestInformation(String requestId);

    ArrayList<String> fetchCounteroffers(String requestId);

}
