package UseCases;

import Entities.Farmer;
import Entities.Distributor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.Math.round;

public class RankingManager {

    // Constants involved in the calculation, subject to tweaking
    private static final double priceCoefficient = 0.05;
    private static final double priceIntercept = 0.5;
    private static final double singleRanking = 2.5;

    private final Distributor[] allDistributors;
    private final Farmer farmer;
    private final String product;
    private final double farmerPrice;

    public RankingManager(Distributor[] allDistributors, Farmer farmer, String product, double farmerPrice) {
        this.allDistributors = allDistributors;
        this.farmer = farmer;
        this.product = product;
        this.farmerPrice = farmerPrice;
    }

    public Distributor[] rank(){
        Distributor[] rankList = allDistributors.clone(); // Create list which will be returned after sorting

        for (Distributor dist: rankList){ // Assign each distributor a ranking from four ranking components
            double priceRanking = calcPriceRanking(dist);
            double exposureRanking = calcExposureRanking(dist, rankList);
            double speedRanking = calcSpeedRanking(dist, rankList);
            double carbonRanking = calcCarbonRanking(dist, rankList);
            dist.setRanking(priceRanking + exposureRanking + speedRanking + carbonRanking);
        }
        Arrays.sort(rankList); // Sort based on ranking
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

    // get one of the three criteria from all distributors and form it into a list, sort the list, then pick a place
    // in the list (based on the farmer's preferences) and rank everything in relation to it

    public double calcExposureRanking(Distributor input_dist, Distributor[] rankList) {
        ArrayList<Integer> exposureList = new ArrayList<>();
        for (Distributor dist : rankList) {
            exposureList.add(dist.getExposure());
        }
        Collections.sort(exposureList);
        int ref_exp = exposureList.get((int) round(exposureList.size() * (farmer.getPrefExposure() / 10.0)));
        double ratio = (double) ref_exp / input_dist.getExposure();
        if (ratio >= 1) {
            return singleRanking;
        } else {
            return singleRanking * ratio;
        }
    }

    public double calcSpeedRanking(Distributor input_dist, Distributor[] rankList) {
        ArrayList<Integer> speedList = new ArrayList<>();
        for (Distributor dist : rankList) {
            speedList.add(dist.getSpeed());
        }
        Collections.sort(speedList);
        int ref_exp = speedList.get((int) round(speedList.size() * (farmer.getPrefSpeed() / 10.0)));
        double ratio = (double) ref_exp / input_dist.getSpeed();
        if (ratio >= 1) {
            return singleRanking;
        } else {
            return singleRanking * ratio;
        }
    }

    public double calcCarbonRanking(Distributor input_dist, Distributor[] rankList) {
        ArrayList<Integer> carbonList = new ArrayList<>();
        for (Distributor dist : rankList) {
            carbonList.add(dist.getCarbon());
        }
        Collections.sort(carbonList);
        int ref_exp = carbonList.get((int) round(carbonList.size() * (farmer.getPrefCarbon() / 10.0)));
        double ratio = (double) ref_exp / input_dist.getCarbon();
        if (ratio >= 1) {
            return singleRanking;
        } else {
            return singleRanking * ratio;
        }
    }
}
