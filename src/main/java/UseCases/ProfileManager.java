package UseCases;

import Entities.Distributor;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * UseCases.ProfileManager
 * Responsibilities
 *
 * * Take variables from Controller.ServiceController
 * * Create Entities.Farmer/Entities.Distributor based on the given variables
 * * Modify Entities.Farmer/Entities.Distributor based on the given variables
 *
 * Collaborators:
 * * Controller.ServiceController
 * * Entities.Farmer
 * * Entities.Distributor
 *
 */

public class ProfileManager {
    //public static ArrayList<Entities.User> farmerList = new ArrayList<>();
    public static ArrayList<Distributor> distributorList = new ArrayList<>();

    public static void createDistributor(String name, String address, HashMap<String, Double> prodMap){
        Distributor dist = new Distributor(name, address, prodMap);
        distributorList.add(dist);

    }

}