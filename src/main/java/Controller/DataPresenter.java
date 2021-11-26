package Controller;

import UseCases.ProfileInterface;
import UseCases.ProfileManager;
import UseCases.RequestInterface;
import UseCases.RequestManager;

import java.util.ArrayList;

public class DataPresenter implements IFetch{
    public String fetchUserAddress(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.addressFromId(id);
    }

    public String fetchUserName(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.nameFromId(id);
    }

    public String fetchUserId(String userName){
        ProfileInterface pm = new ProfileManager();
        return pm.idFromName(userName);
    }

    public ArrayList<String> fetchAllFarmerNames(){
        ProfileInterface pm = new ProfileManager();
        return pm.getAllFarmerNames();
    }

    public ArrayList<String> fetchAllDistNames(){
        ProfileInterface pm = new ProfileManager();
        return pm.getAllDistNames();
    }

    public ArrayList<String> fetchCurrentUserRequests(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.requestsFromId(id);
    }

    public String[] fetchRequestInformation(String requestID){
        RequestInterface rm = new RequestManager();
        String[] data = rm.dataFromId(requestID);
        if (data[2].matches("\\.[0-9]$")){ data[2] = data[2] + "0";}
        return data;
    }

    public ArrayList<String> fetchRequestHistory(String id){
        ProfileInterface pm = new ProfileManager();
        return pm.historyFromId(id);
    }

    public ArrayList<String> fetchCounteroffers(String requestID){
        RequestInterface rm = new RequestManager();
        return rm.coFromId(requestID);
    }

}
