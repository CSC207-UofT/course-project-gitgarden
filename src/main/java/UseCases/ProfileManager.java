package UseCases;

import Entities.Distributor;
import Entities.Farmer;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileManager implements ProfileInterface{
    public static ArrayList<Farmer> farmerList;
    public static ArrayList<Distributor> distributorList;

    public static void createFarmer(String name, String address){
        Farmer farmer = new Farmer(name, address);
        farmerList.add(farmer);
    }

    public static void createDistributor(String name, String address){
        Distributor dist = new Distributor(name, address);
        distributorList.add(dist);
    }

    public static void modifyUser(User user, String name, String address, String summary){
        user.setUser_name(name);
        user.setUser_address(address);
        user.setSummary(summary);
    }

}
