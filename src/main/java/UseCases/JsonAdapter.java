package UseCases;

import Entities.IDistributor;
import Entities.IFarmer;
import Entities.IRequest;
import Entities.IUser;

import java.util.ArrayList;

public class JsonAdapter {

    /**
     * Convert the Farmer to an ArrayList of Array of Strings for saving/reading
     *
     * @return An ArrayList of String arrays containing farmer information
     */
    public ArrayList<String[]> farmerAdapter() {
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> farmArray = new ArrayList<>();
        for (IFarmer f : pm.getFarmerList()) {
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
     *
     * @return An ArrayList of String arrays containing distributor information
     */
    public ArrayList<String[]> distAdapter() {
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> distArray = new ArrayList<>();
        for (IDistributor d : pm.getDistributorList()) {
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
     *
     * @return An ArrayList of String arrays containing information needed for
     * modifying farmer
     */
    public ArrayList<String[]> modFarmerAdapter() {
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> modFarm = new ArrayList<>();
        for (IFarmer f : pm.getFarmerList()) {
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
     *
     * @return An ArrayList of String arrays containing information needed for
     * modifying distributor
     */
    public ArrayList<String[]> modDistAdapter() {
        ProfileManager pm = new ProfileManager();
        ArrayList<String[]> modDist = new ArrayList<>();
        for (IDistributor d : pm.getDistributorList()) {
            String[] dists = new String[4];
            dists[0] = String.valueOf(d.getUserId());
            dists[1] = String.valueOf(d.getExposure());
            dists[2] = String.valueOf(d.getSpeed());
            dists[3] = String.valueOf(d.getCarbon());
            modDist.add(dists);
        }
        return modDist;
    }


    /**
     * Convert the requests to an ArrayList for saving/reading
     *
     * @return An ArrayList of String arrays containing information needed for
     * creating requests
     */
    public ArrayList<String[]> requestAdapter() {
        RequestManager rm = new RequestManager();
        ArrayList<String[]> reqArray = new ArrayList<>();
        ArrayList<Integer> ids = rm.getAllRequestIds();
        for (int i : ids) {
            if (rm.dataFromId(String.valueOf(i))[4] == null) {
                IRequest req = rm.getRequestFromId(String.valueOf(i));
                String[] r = new String[6];
                r[0] = String.valueOf(req.getRequestId());
                r[1] = String.valueOf(req.getUser().getUserId());
                r[2] = req.getProdName();
                r[3] = String.valueOf(req.getProdQuantity());
                r[4] = String.valueOf(req.getProdPricePerKg());
                r[5] = String.valueOf(req.getAccepted());
                reqArray.add(r);
            }
        }
        return reqArray;
    }


    /**
     * Convert the counterOffers to an ArrayList for saving/reading
     *
     * @return An ArrayList of String arrays containing information needed for
     * creating counterOffers
     */
    public ArrayList<String[]> coAdapter() {
        RequestManager rm = new RequestManager();
        ArrayList<String[]> coArray = new ArrayList<>();
        ArrayList<Integer> ids = rm.getAllRequestIds();
        for (int id : ids) {
            ArrayList<String> cos = rm.coFromId(String.valueOf(id));
            if (!cos.isEmpty()) {
                String[] c = new String[6];
                for (String co : cos) {
                    c[0] = co;
                    IUser user = rm.getRequestFromId(co).getUser();
                    if (user == null) {
                        int rootId = rm.rootId(co);
                        user = rm.getRequestFromId(String.valueOf(rootId)).getUser();
                    }
                    try {
                        c[1] = String.valueOf(user.getUserId());
                        IRequest prev = rm.getRequestFromId(co).getPrevious();
                        c[2] = String.valueOf(prev.getRequestId());
                        c[3] = String.valueOf(rm.getRequestFromId(co).getProdQuantity());
                        c[4] = String.valueOf(rm.getRequestFromId(co).getProdPricePerKg());
                        c[5] = String.valueOf(rm.getRequestFromId(co).getAccepted());
                    } catch (NullPointerException ignored) {

                    }

                }
                coArray.add(c);
            }
        }
        return coArray;
    }
}
