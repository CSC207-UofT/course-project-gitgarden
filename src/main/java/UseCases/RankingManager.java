package UseCases;

import Entities.Farmer;
import Entities.IDistributor;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.round;

public class RankingManager implements RankInterface {

    private static final double SINGLE_RANKING = 2.5;

    private final ArrayList<IDistributor> allDistributors;
    private final Farmer farmer;
    private final String product;

    public RankingManager(ArrayList<IDistributor> allDistributors, Farmer farmer, String product) {
        this.allDistributors = allDistributors;
        this.farmer = farmer;
        this.product = product;
    }

    @Override
    public ArrayList<IDistributor> rankDistributors(){
        ArrayList<IDistributor> rankList = new ArrayList<>(allDistributors);

        for (IDistributor dist: rankList){
            double priceRanking = calcRanking(dist, rankList, "price");
            double exposureRanking = calcRanking(dist, rankList, "exposure");
            double speedRanking = calcRanking(dist, rankList, "speed");
            double carbonRanking = calcRanking(dist, rankList, "carbon");
            double distRanking = priceRanking + exposureRanking + speedRanking + carbonRanking;
            dist.setRanking(distRanking);
        }
        rankList.sort(Collections.reverseOrder());
        return rankList;
    }

    public double calcRanking(IDistributor input_dist, ArrayList<IDistributor> rankList, String crit) {
        ArrayList<Double> critList = new ArrayList<>();
        for (IDistributor dist : rankList) { critList.add(getCriterion(dist, crit)); }
        Collections.sort(critList);
        Double ref = critList.get((int) round((critList.size() - 1) * (1 - (getPrefCriterion(farmer, crit) / 10.0))));
        double ratio = ref / getCriterion(input_dist, crit);
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
                return dist.prodMap().get(product);
        }
    }

    public double getPrefCriterion(Farmer farmer, String criterion) {
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

    public ArrayList<IDistributor> getAllDistributors(){
        return this.allDistributors;
    }

    public Farmer getFarmer(){
        return this.farmer;
    }

    public String getProduct(){
        return this.product;
    }

}
