package Controller;

import UseCases.ProfileInterface;
import UseCases.ProfileManager;
import UseCases.RequestInterface;
import UseCases.RequestManager;

import java.util.ArrayList;

public class DataPresenter {
    public String fetchUserAddress(String name){
        ProfileInterface pm = new ProfileManager();
        return pm.addressFromName(name);
    }

    public String fetchUserID(String name){
        ProfileInterface pm = new ProfileManager();
        return pm.IDFromName(name);
    }

    public ArrayList<String> fetchAllFarmerNames(){
        ProfileInterface pm = new ProfileManager();
        return pm.getAllFarmerNames();
    }

    public ArrayList<String> fetchAllDistNames(){
        ProfileInterface pm = new ProfileManager();
        return pm.getAllDistNames();
    }

    public String fetchRequestUserName(String requestID, String name){
        RequestInterface rm = new RequestManager();
        return rm.nameFromID(requestID, name);
    }

    public String fetchRequestProduct(String requestID, String name){
        RequestInterface rm = new RequestManager();
        return rm.productFromID(requestID, name);
    }

    public String fetchRequestQuantity(String requestID, String name){
        RequestInterface rm = new RequestManager();
        return rm.quantityFromID(requestID, name);
    }

    public String fetchRequestPrice(String requestID, String name){
        RequestInterface rm = new RequestManager();
        return rm.priceFromID(requestID, name);
    }

    public ArrayList<String> fetchCounteroffers(String requestID, String name){
        RequestInterface rm = new RequestManager();
        return rm.coFromID(requestID, name);
    }

    public String fetchPreviousRequestID(String requestID, String name){
        RequestInterface rm = new RequestManager();
        return rm.previousIDFromID(requestID, name);
    }

}
