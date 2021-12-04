package UseCases;

import Entities.*;

import java.util.ArrayList;

public class JsonAdapter {

    /**
     * Convert the Farmer to a ArrayList of Array of Strings for saving/reading
     * @return An ArrayList of String arrays containing farmer information
     */
    public ArrayList<String[]> farmerAdapter(){
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> farmArray = new ArrayList<>();
        for (IFarmer f : pm.getFarmerList()){
            String[] farmers = new String[3];
            farmers[0] = f.getUserName();
            farmers[1] = f.getUserAddress();
            farmers[2] = String.valueOf(f.getUserId());
            farmArray.add(farmers);
        }
        return farmArray;
    }


    /**
     * Convert the Distributor to a ArrayList of Array of Strings for saving/reading
     * @return An ArrayList of String arrays containing farmer information
     */
    public ArrayList<String[]> distAdapter(){
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> distArray = new ArrayList<>();
        for (IDistributor d : pm.getDistributorList()){
            String[] dists = new String[3];
            dists[0] = d.getUserName();
            dists[1] = d.getUserAddress();
            dists[2] = String.valueOf(d.getUserId());
            distArray.add(dists);
        }
        return distArray;
    }
}
