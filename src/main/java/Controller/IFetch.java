package Controller;

import java.util.ArrayList;

public interface IFetch {
    String fetchUserAddress(String name);

    String fetchUserID(String name);

    // TODO: 2021/11/19 I think this one would be tricky because we have to know who the current user is, so work in pm?
    String fetchUserName();

    ArrayList<String> fetchAllFarmerNames();

    ArrayList<String> fetchAllDistNames();

    String fetchRequestUserName(String requestID);

    String fetchRequestProduct(String requestID);

    String fetchRequestQuantity(String requestID);

    String fetchRequestPrice(String requestID);

    ArrayList<String> fetchCounteroffers(String requestID);

    String fetchPreviousRequestID(String requestID);


}
