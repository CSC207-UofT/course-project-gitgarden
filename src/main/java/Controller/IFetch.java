package Controller;

import java.util.ArrayList;

public interface IFetch {
    String fetchUserAddress();

    String fetchUserID();

    ArrayList<String> fetchAllFarmerNames();

    ArrayList<String> fetchAllDistNames();

    String fetchRequestUserName();

    String fetchRequestProduct();

    String fetchRequestQuantity();

    String fetchRequestPrice();

    ArrayList<String> fetchCounteroffers();

    String fetchPreviousRequestID();


}
