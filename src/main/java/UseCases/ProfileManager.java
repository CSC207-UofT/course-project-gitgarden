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
    public ArrayList<String> getAllNames(){
        ArrayList<String> names = new ArrayList<>();
        ArrayList<IUser> userList = new ArrayList<>(ProfileManager.farmerList);
        userList.addAll(ProfileManager.distributorList);
        for (IUser user : userList) {
            names.add(user.getUserName());
        }
        return names;
    }

}
