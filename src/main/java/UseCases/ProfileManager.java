package UseCases;

import Entities.*;

import java.util.ArrayList;

public class ProfileManager implements ProfileInterface{
    public static ArrayList<IFarmer> farmerList = new ArrayList<>();
    public static ArrayList<IDistributor> distributorList = new ArrayList<>();

    @Override
    public void createFarmer(String name, String address, int id){
        IFarmer farmer = new Farmer(name, address, id);
        ProfileManager.farmerList.add(farmer);
    }

    @Override
    public void createDistributor(String name, String address, int id){
        IDistributor dist = new Distributor(name, address, id);
        ProfileManager.distributorList.add(dist);
    }

    @Override
    public void modifyUser(String id, String newName, String address){
        IUser user = getUserFromId(id);
        user.setUserName(newName);
        user.setUserAddress(address);
    }

    @Override
    public void modifyFarmer(String id, double slider1, double slider2, double slider3, double slider4){
        IFarmer farmer = (IFarmer) getUserFromId(id);
        farmer.setPrefPrice(slider1);
        farmer.setPrefExposure(slider2);
        farmer.setPrefSpeed(slider3);
        farmer.setPrefCarbon(slider4);
    }

    @Override
    public void modifyDistributor(String id, double slider2, double slider3, double slider4){
        IDistributor dist = (IDistributor) getUserFromId(id);
        dist.setExposure(slider2);
        dist.setSpeed(slider3);
        dist.setCarbon(slider4);
    }

    @Override
    public ArrayList<String> getAllFarmerNames(){
        ArrayList<String> names = new ArrayList<>();
        for (IUser user: farmerList){
            names.add(user.getUserName());
        }
        return names;
    }

    @Override
    public ArrayList<String> getAllDistNames(){
        ArrayList<String> names = new ArrayList<>();
        for (IUser user: farmerList){
            names.add(user.getUserName());
        }
        return names;
    }

    @Override
    public ArrayList<Integer> getAllIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<IUser> users = new ArrayList<>();
        users.addAll(farmerList);
        users.addAll(distributorList);
        for (IUser user: users){
            ids.add(user.getUserId());
        }
        return ids;
    }

    @Override
    public String addressFromId(String id) {
        IUser user = getUserFromId(id);
        return user.getUserAddress();
    }

    @Override
    public String nameFromId(String id) {
        IUser user = getUserFromId(id);
        return user.getUserName();
    }

    @Override
    public String idFromName(String name) {
        IUser user = getUserFromName(name);
        return String.valueOf(user.getUserId());
    }

    @Override
    public ArrayList<String> requestsFromId(String id) {
        RequestManager rm = new RequestManager();
        IUser user = getUserFromId(id);
        return rm.requestToId(user.getCurrentRequests());
    }

    @Override
    public ArrayList<String> historyFromId(String id) {
        RequestManager rm = new RequestManager();
        IUser user = getUserFromId(id);
        return rm.requestToId(user.getOfferHistory());
    }


    @Override
    public IUser getUserFromId(String id){
        ArrayList<IUser> userList = new ArrayList<>(ProfileManager.farmerList);
        userList.addAll(ProfileManager.distributorList);
        for (IUser user : userList) {
            if (String.valueOf(user.getUserId()).equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public IUser getUserFromName(String name){
        ArrayList<IUser> userList = new ArrayList<>(ProfileManager.farmerList);
        userList.addAll(ProfileManager.distributorList);
        for (IUser user : userList) {
            if (String.valueOf(user.getUserName()).equals(name)) {
                return user;
            }
        }
        return null;
    }

// Old persistence code
//    public static void loadFarmer(String name, String address, double slider1, double slider2, double slider3,
//                                  double slider4, boolean flag, ArrayList<Request> current_requests,
//                                  ArrayList<Request> offer_history){
//
//        Farmer farmer = new Farmer(name, address, current_requests, offer_history);
//        modifyPreference(farmer, slider1, slider2, slider3, slider4);
//        farmerList.add(farmer);
//        currentUser = farmerList.get(farmerList.indexOf(farmer));
//    }
//
//    public static void loadDistributor(String name, String address, double slider1, double slider2, double slider3,
//                                       double slider4, boolean flag, ArrayList<Request> current_requests,
//                                       ArrayList<Offer> offer_history){
//
//        Distributor distributor = new Distributor(name, address, current_requests, offer_history);
//        modifyPreference(distributor, slider1, slider2, slider3, slider4);
//        distributorList.add(distributor);
//        currentUser = distributorList.get(distributorList.indexOf(distributor));
//    }
}
