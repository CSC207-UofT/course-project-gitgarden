package Controller;

import java.util.ArrayList;

public interface IFetch {
    String fetchUserAddress();

    String fetchUserID();

    // TODO: 2021/11/19 I think this one would be tricky because we have to know who the current user is, so work in pm?
    String fetchUserName();

    ArrayList<String> fetchAllFarmerNames();

    ArrayList<String> fetchAllDistNames();

    String fetchRequestUserName();

    String fetchRequestProduct();

    String fetchRequestQuantity();

    String fetchRequestPrice();

    ArrayList<String> fetchCounteroffers();

    String fetchPreviousRequestID();


}
