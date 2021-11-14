package UseCases;

import Entities.*;

import java.util.ArrayList;

public interface ProfileInterface {
    static void createFarmer(String name, String address){
        Farmer farmer = new Farmer(name, address);
        ProfileManager.farmerList.add(farmer);
    }

    static void createDistributor(String name, String address){
        Distributor dist = new Distributor(name, address);
        ProfileManager.distributorList.add(dist);
    }

    static void modifyUser(IUser user, String newName, String address){
        user.setUserName(newName);
        user.setUserAddress(address);
    }

    static void modifyFarmer(IFarmer farmer, double slider1, double slider2, double slider3, double slider4){
        farmer.setPrefPrice(slider1);
        farmer.setPrefExposure(slider2);
        farmer.setPrefSpeed(slider3);
        farmer.setPrefCarbon(slider4);
    }

    static void modifyDistributor(IDistributor dist, double slider2, double slider3, double slider4){
        dist.setExposure(slider2);
        dist.setSpeed(slider3);
        dist.setCarbon(slider4);
    }

    static ArrayList<String> getAllNames(){
        ArrayList<String> names = new ArrayList<>();
        ArrayList<IUser> userList = new ArrayList<>(ProfileManager.farmerList);
        userList.addAll(ProfileManager.distributorList);
        for (IUser user : userList) {
            names.add(user.getUserName());
        }
        return names;
    }
}
