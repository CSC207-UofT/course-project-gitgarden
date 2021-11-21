package Controller;

import java.util.ArrayList;

public interface IFetch {
    String fetchUserAddress(String id);

    // TODO: 2021/11/19 I think this one would be tricky because we have to know who the current user is, so work in pm?
    String fetchUserName(String id);

    // TODO: 2021/11/20 find the user id based on the input user name for existing username
    String fetchUserId(String UserName);

    String[] fetchRequestHistory(String id);

    ArrayList<String> fetchAllFarmerNames();

    ArrayList<String> fetchAllDistNames();

    ArrayList<String> fetchCurrentUserRequests(String id);

    // TODO: 2021/11/20 return [name, quantity, price, User name, prevRequestId],I think array is easier to work with
    String[] fetchRequestInformation(String requestId);

    ArrayList<String> fetchCounteroffers(String requestId);

}
