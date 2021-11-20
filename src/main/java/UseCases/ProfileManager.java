package UseCases;

import Entities.*;

import java.util.ArrayList;

public class ProfileManager implements ProfileInterface{
    public static ArrayList<IFarmer> farmerList = new ArrayList<>();
    public static ArrayList<IDistributor> distributorList = new ArrayList<>();

    @Override
    public void createFarmer(String name, String address){
        IFarmer farmer = new Farmer(name, address);
        ProfileManager.farmerList.add(farmer);
    }

    @Override
    public void createDistributor(String name, String address){
        IDistributor dist = new Distributor(name, address);
        ProfileManager.distributorList.add(dist);
    }

    @Override
    public void modifyUser(IUser user, String newName, String address){
        user.setUserName(newName);
        user.setUserAddress(address);
    }

    @Override
    public void modifyFarmer(IFarmer farmer, double slider1, double slider2, double slider3, double slider4){
        farmer.setPrefPrice(slider1);
        farmer.setPrefExposure(slider2);
        farmer.setPrefSpeed(slider3);
        farmer.setPrefCarbon(slider4);
    }

    @Override
    public void modifyDistributor(IDistributor dist, double slider2, double slider3, double slider4){
        dist.setExposure(slider2);
        dist.setSpeed(slider3);
        dist.setCarbon(slider4);
    }

    @Override
    public IUser getUserFromName(String name){
        ArrayList<IUser> userList = new ArrayList<>(ProfileManager.farmerList);
        userList.addAll(ProfileManager.distributorList);
        for (IUser user : userList) {
            if (user.getUserName().equals(name)) {
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
    public ArrayList<IFarmer> getFarmerList(){
        return farmerList;
    }

    @Override
    public ArrayList<IDistributor> getDistributorList(){
        return distributorList;
    }

    @Override
    public String addressFromName(String name) {
        return null;
    }

    @Override
    public String IDFromName(String name) {
        return null;
    }

}
