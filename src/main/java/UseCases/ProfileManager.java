package UseCases;

import Entities.Distributor;
import Entities.Farmer;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileManager implements ProfileInterface{
    public static ArrayList<Farmer> farmerList = new ArrayList<>();
    public static ArrayList<Distributor> distributorList = new ArrayList<>();

    public static void createUser(String name, String address, double slider1, double slider2, double slider3,
                                  double slider4, boolean flag){
        if(flag){
            Farmer farmer = new Farmer(name, address);
            modifyPreference(farmer, slider1, slider2, slider3, slider4);
            farmerList.add(farmer);
        }
        else{
            Distributor dist = new Distributor(name, address);
            modifyPreference(dist, slider1, slider2, slider3, slider4);
            distributorList.add(dist);
        }
    }

    public static void modifyPreference(User user, double slider1, double slider2, double slider3, double slider4){
        if (user instanceof Farmer){
            ((Farmer)user).setPrefPrice(slider1);
            ((Farmer)user).setPrefExposure(slider2);
            ((Farmer)user).setPrefSpeed(slider3);
            ((Farmer)user).setPrefCarbon(slider4);
        }
        else{
            // slider1 is not used
            ((Distributor)user).setExposure(slider2);
            ((Distributor)user).setSpeed(slider3);
            ((Distributor)user).setCarbon(slider4);
        }
    }

    public static void modifyUser(User user, String name, String address, String summary){
        user.setUser_name(name);
        user.setUser_address(address);
        user.setSummary(summary);
    }

}
