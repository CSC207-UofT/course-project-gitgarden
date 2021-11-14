package Entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Distributor extends User implements IDistributor {

    private double exposure;
    private double speed; // Average number of hours in which transactions are completed after being finalized
    private double carbon; // Number of grams CO2eq emitted per transaction

    private double ranking; // Comparable object

    public Distributor(String distributor_name, String distributor_address){
        super(distributor_name, distributor_address);
        this.exposure = 10;
        this.speed = 10;
        this.carbon = 10;
    }

    public HashMap<String, Double> prodMap(){
        HashMap<String, ArrayList<Double>> allPrices = new HashMap<>();
        for (Request item: this.offerHistory) {
            if (!allPrices.containsKey(item.getProdName())) {
                ArrayList<Double> prices = new ArrayList<>();
                prices.add(item.getProdPricePerKg());
                allPrices.put(item.getProdName(), prices);
            } else {
                allPrices.get(item.getProdName()).add(item.getProdPricePerKg());
            }
        }
        return prodAverages(allPrices);
    }

    private HashMap<String, Double> prodAverages(HashMap<String, ArrayList<Double>> allPrices) {
        HashMap<String, Double> prodMap = new HashMap<>();
        for (String prodName : allPrices.keySet()){
            double average = 0;
            for (Double price : allPrices.get(prodName)){
                average += price;
            }
            average = average / allPrices.size();
            prodMap.put(prodName, average);
        }
        return prodMap;
    }

    public int compareTo(Distributor other){
        return Double.compare(this.ranking, other.ranking);
    }

    public void setExposure(double exposure) {
        this.exposure = exposure;
    }

    public double getExposure() {
        return this.exposure;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setCarbon(double carbon) {
        this.carbon = carbon;
    }

    public double getCarbon() {
        return carbon;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

}
