package Controller;

import java.util.ArrayList;

public interface IFetch {
    String fetchUserAddress(String id);

    // TODO: 2021/11/19 I think this one would be tricky because we have to know who the current user is, so work in pm?
    String fetchUserName(String id);

    // TODO: 2021/11/20 find the user id based on the input user name for existing username
    String fetchUserId(String Name);

    ArrayList<String> fetchAllFarmerNames();

    ArrayList<String> fetchAllDistNames();

    ArrayList<String> fetchCurrentUserRequests(String id);

    String fetchRequestUserName(String requestId);

    String fetchRequestProduct(String requestId);

    String fetchRequestQuantity(String requestId);

    String fetchRequestPrice(String requestId);

    ArrayList<String> fetchCounteroffers(String requestId);

    String fetchPreviousRequestID(String requestId);


}
