package UseCases;

import Entities.*;

import java.util.ArrayList;

public class ProfileManager implements ProfileInterface{
    public static ArrayList<IFarmer> farmerList = new ArrayList<>();
    public static ArrayList<IDistributor> distributorList = new ArrayList<>();

    public static void createFarmer(String name, String address){
        IFarmer farmer = new Farmer(name, address);
        farmerList.add(farmer);
    }

    public static void createDistributor(String name, String address){
        IDistributor dist = new Distributor(name, address);
        distributorList.add(dist);
    }



    public static void modifyFarmer(IFarmer farmer, double slider1, double slider2, double slider3, double slider4){
        farmer.setPrefPrice(slider1);
        farmer.setPrefExposure(slider2);
        farmer.setPrefSpeed(slider3);
        farmer.setPrefCarbon(slider4);
    }

    public static void modifyDistributor(IDistributor dist, double slider2, double slider3, double slider4){
        dist.setExposure(slider2);
        dist.setSpeed(slider3);
        dist.setCarbon(slider4);
    }

}
