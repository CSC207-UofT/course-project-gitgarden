package UseCases;

import Entities.Distributor;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileManager {
    //public static ArrayList<User> farmerList = new ArrayList<>();
    Gson gson = new Gson();
    public static ArrayList<Distributor> distributorList = new ArrayList<>();

    public static void createDistributor(String name, String address, HashMap<String, Double> prodMap){
        Distributor dist = new Distributor(name, address, prodMap);
        distributorList.add(dist);
    }
}
