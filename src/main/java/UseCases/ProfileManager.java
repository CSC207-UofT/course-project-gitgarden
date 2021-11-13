package UseCases;

import Entities.Distributor;
import Entities.Farmer;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileManager implements ProfileInterface{
    public static ArrayList<Farmer> farmerList = new ArrayList<>();
    public static ArrayList<Distributor> distributorList = new ArrayList<>();

    public static void createFarmer(String name, String address, double slider1, double slider2, double slider3,
                                    double slider4){
        Farmer farmer = new Farmer(name, address);
        farmer.setPrefPrice(slider1);
        farmer.setPrefExposure(slider2);
        farmer.setPrefSpeed(slider3);
        farmer.setPrefCarbon(slider4);
        farmerList.add(farmer);
    }

    public static void createDistributor(String name, String address, double slider2, double slider3,
                                         double slider4){
        Distributor dist = new Distributor(name, address);
        dist.setExposure(slider2);
        dist.setSpeed(slider3);
        dist.setCarbon(slider4);
        distributorList.add(dist);
    }

    public static void modifyUser(User user, String name, String address, String summary){
        user.setUser_name(name);
        user.setUser_address(address);
        user.setSummary(summary);
    }

}
