package UseCases;

import Entities.*;

public interface ProfileInterface {
    static void createFarmer(String name, String address){
        Farmer farmer = new Farmer(name, address);
        ProfileManager.farmerList.add(farmer);
    }

    static void createDistributor(String name, String address){
        Distributor dist = new Distributor(name, address);
        ProfileManager.distributorList.add(dist);
    }

    static void modifyUser(IUser user, String name, String address, String summary){
        user.setUser_name(name);
        user.setUser_address(address);
        user.setSummary(summary);
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

}
