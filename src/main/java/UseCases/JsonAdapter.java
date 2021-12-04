package UseCases;

import Entities.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JsonAdapter {

    /**
     * Convert the Farmer to an ArrayList of Array of Strings for saving/reading
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
     * Convert the Distributor to an ArrayList of Array of Strings for saving/reading
     * @return An ArrayList of String arrays containing distributor information
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


    /**
     * Convert the id and slider values of Farmer to an ArrayList for saving/reading
     * @return An ArrayList of String arrays containing information needed for
     *         modifying farmer
     */
    public ArrayList<String[]> modFarmerAdapter(){
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> modFarm = new ArrayList<>();
        for (IFarmer f : pm.getFarmerList()){
            String[] farms = new String[5];
            farms[0] = String.valueOf(f.getUserId());
            farms[1] = String.valueOf(f.getPrefPrice());
            farms[2] = String.valueOf(f.getPrefExposure());
            farms[3] = String.valueOf(f.getPrefSpeed());
            farms[4] = String.valueOf(f.getPrefCarbon());
            modFarm.add(farms);
        }
        return modFarm;
    }


    /**
     * Convert the id and slider values of Distributor to an ArrayList for saving/reading
     * @return An ArrayList of String arrays containing information needed for
     *         modifying distributor
     */
    public ArrayList<String[]> modDistAdapter(){
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> modDist = new ArrayList<>();
        for (IDistributor d : pm.getDistributorList()){
            String[] dists = new String[4];
            dists[0] = String.valueOf(d.getUserId());
            dists[1] = String.valueOf(d.getExposure());
            dists[2] = String.valueOf(d.getSpeed());
            dists[3] = String.valueOf(d.getCarbon());
            modDist.add(dists);
        }
        return modDist;
    }
}
