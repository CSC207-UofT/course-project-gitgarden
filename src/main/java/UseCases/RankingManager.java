package UseCases;

import Entities.IDistributor;
import Entities.IFarmer;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.round;

public class RankingManager implements RankInterface {

    private static final double SINGLE_RANKING = 2.5;

    private final ArrayList<String> allDistributorIDs;
    private final String farmerID;
    private final String product;

    public RankingManager(ArrayList<String> allDistributorIDs, String farmerID, String product) {
        this.allDistributorIDs = allDistributorIDs;
        this.farmerID = farmerID;
        this.product = product;
    }

    @Override
    public ArrayList<String> rankDistributors(){
        ArrayList<IDistributor> rankList = new ArrayList<>(idToDist(allDistributorIDs));

        for (IDistributor dist: rankList){
            double priceRanking = calcRanking(dist, rankList, "price");
            double exposureRanking = calcRanking(dist, rankList, "exposure");
            double speedRanking = calcRanking(dist, rankList, "speed");
            double carbonRanking = calcRanking(dist, rankList, "carbon");
            double distRanking = priceRanking + exposureRanking + speedRanking + carbonRanking;
            dist.setRanking(distRanking);
        }
        rankList.sort(Collections.reverseOrder());
        return distToId(rankList);
    }

    public double calcRanking(IDistributor input_dist, ArrayList<IDistributor> rankList, String crit) {
        ProfileInterface pm = new ProfileManager();
        ArrayList<Double> critList = new ArrayList<>();
        for (IDistributor dist : rankList) { critList.add(getCriterion(dist, crit)); }
        Collections.sort(critList);
        IFarmer farmer = (IFarmer) pm.getUserFromId(farmerID);
        Double ref = critList.get((int) round((critList.size() - 1) * (1 - (getPrefCriterion(farmer, crit) / 10.0))));
        double ratio = ref / (getCriterion(input_dist, crit) + 0.01);
        if (ratio >= 1) {
            return SINGLE_RANKING;
        } else {
            return SINGLE_RANKING * ratio;
        }
    }

    public double getCriterion(IDistributor dist, String criterion){
        switch (criterion) {
            case "exposure":
                return dist.getExposure();
            case "speed":
                return dist.getSpeed();
            case "carbon":
                return dist.getCarbon();
            default:
                return dist.prodMap().getOrDefault(product, 0.01);

        }
    }

    public double getPrefCriterion(IFarmer farmer, String criterion) {
        switch (criterion) {
            case "exposure":
                return farmer.getPrefExposure();
            case "speed":
                return farmer.getPrefSpeed();
            case "carbon":
                return farmer.getPrefCarbon();
            default:
                return farmer.getPrefPrice();
        }
    }

    public ArrayList<IDistributor> idToDist(ArrayList<String> allDistributors){
        ProfileInterface pm = new ProfileManager();
        ArrayList<IDistributor> returned = new ArrayList<>();
        for (String distID: allDistributors){
            returned.add((IDistributor) pm.getUserFromId(distID));
        }
        return returned;
    }

    public ArrayList<String> distToId(ArrayList<IDistributor> rankList){
        ArrayList<String> returned = new ArrayList<>();
        for (IDistributor dist: rankList){
            returned.add(String.valueOf(dist.getUserId()));
        }
        return returned;
    }

    public String getProduct(){
        return this.product;
    }

}
