package UseCases;

import Entities.Farmer;
import Entities.Distributor;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.round;

public class RankingManager {

    private static final double priceCoefficient = 0.05;
    private static final double priceIntercept = 0.5;
    private static final double singleRanking = 2.5;

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
        ArrayList<Distributor> rankList = allDistributors;

        for (Distributor dist: rankList){
            double priceRanking = calcPriceRanking(dist);
            double exposureRanking = calcRanking(dist, rankList, "exposure");
            double speedRanking = calcRanking(dist, rankList, "speed");
            double carbonRanking = calcRanking(dist, rankList, "carbon");
            dist.setRanking(priceRanking + exposureRanking + speedRanking + carbonRanking);
        }
        Collections.sort(rankList);
        return rankList;
    }

    public double calcPriceRanking(Distributor input_dist) {
        double distPrice = input_dist.getProdMap().get(product);
        if (distPrice < ((priceIntercept + (farmer.getPrefPrice() * priceCoefficient)) * farmerPrice)){
            return 0.0;
        }
        else {
            return singleRanking;
        }
    }

    public double calcRanking(Distributor input_dist, ArrayList<Distributor> rankList, String crit) {
        ArrayList<Integer> critList = new ArrayList<>();
        for (Distributor dist : rankList) { critList.add(getCriterion(dist, crit)); }
        Collections.sort(critList);
        int ref = critList.get((int) round((critList.size() - 1) * (1 - (getPrefCriterion(farmer, crit) / 10.0))));
        double ratio = (double) ref / getCriterion(input_dist, crit);
        if (ratio >= 1) {
            return singleRanking;
        } else {
            return singleRanking * ratio;
        }
    }

    public int getCriterion(Distributor dist, String criterion){
        if (criterion.equals("exposure")){
            return dist.getExposure();
        } else if (criterion.equals("speed")){
            return dist.getSpeed();
        } else {
            return dist.getCarbon();
        }
    }

    public int getPrefCriterion(Farmer farmer, String criterion){
        if (criterion.equals("exposure")){
            return farmer.getPrefExposure();
        } else if (criterion.equals("speed")){
            return farmer.getPrefSpeed();
        } else {
            return farmer.getPrefCarbon();
        }
    }

    public ArrayList<Distributor> getAllDistributors(){
        return this.allDistributors;
    }

    public Farmer getFarmer(){
        return this.farmer;
    }

}
