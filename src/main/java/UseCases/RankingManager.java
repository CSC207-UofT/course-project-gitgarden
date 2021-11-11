package UseCases;

import Entities.Farmer;
import Entities.Distributor;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.round;

public class RankingManager {

    private static final double PRICE_COEFFICIENT = 0.05;
    private static final double PRICE_INTERCEPT = 0.5;
    private static final double SINGLE_RANKING = 2.5;

    private final ArrayList<Distributor> allDistributors;
    private final Farmer farmer;
    private final String product;
    private final double farmerPrice;

    public RankingManager(ArrayList<Distributor> allDistributors, Farmer farmer, String product, double farmerPrice) {
        this.allDistributors = allDistributors;
        this.farmer = farmer;
        this.product = product;
        this.farmerPrice = farmerPrice;
    }

    public ArrayList<Distributor> rankDistributors(){
        ArrayList<Distributor> rankList = new ArrayList<>(allDistributors);

        for (Distributor dist: rankList){
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

    public double calcRanking(Distributor input_dist, ArrayList<Distributor> rankList, String crit) {
        ArrayList<Double> critList = new ArrayList<>();
        for (Distributor dist : rankList) { critList.add(getCriterion(dist, crit)); }
        Collections.sort(critList);
        Double ref = critList.get((int) round((critList.size() - 1) * (1 - (getPrefCriterion(farmer, crit) / 10.0))));
        double ratio = ref / getCriterion(input_dist, crit);
        if (ratio >= 1) {
            return SINGLE_RANKING;
        } else {
            return SINGLE_RANKING * ratio;
        }
    }

    public double getCriterion(Distributor dist, String criterion){
        switch (criterion) {
            case "exposure":
                return dist.getExposure();
            case "speed":
                return dist.getSpeed();
            case "carbon":
                return dist.getCarbon();
            default:
                return dist.getProdMap().get(product);
        }
    }

    public int getPrefCriterion(Farmer farmer, String criterion) {
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

    public ArrayList<Distributor> getAllDistributors(){
        return this.allDistributors;
    }

    public Farmer getFarmer(){
        return this.farmer;
    }

}
