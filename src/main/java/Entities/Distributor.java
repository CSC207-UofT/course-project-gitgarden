package Entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Distributor extends User implements IDistributor {

    private double exposure;
    private double speed;
    private double carbon;

    private double ranking;

    public Distributor(String distributor_name, String distributor_address, int id){
        super(distributor_name, distributor_address, id);
        this.exposure = 10;
        this.speed = 10;
        this.carbon = 10;
    }

    /**
     * Returns the product map of the distributor: the average price of each product they sell.
     * @return The product map.
     */
    public HashMap<String, Double> prodMap(){
        HashMap<String, ArrayList<Double>> allPrices = new HashMap<>();
        for (IRequest item: this.offerHistory) {
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
            average = average / allPrices.get(prodName).size();
            prodMap.put(prodName, average);
        }
        return prodMap;
    }

    /**
     * Compares two distributors based on ranking.
     * @param other The distributor to be compared with.
     * @return -1 if other is greater, 0 if equal, 1 if other is lesser.
     */
    public int compareTo(Distributor other){
        return Double.compare(this.ranking, other.ranking);
    }

    /**
     * Sets the exposure attribute of this distributor.
     * @param exposure The exposure setting.
     */
    public void setExposure(double exposure) {
        this.exposure = exposure;
    }

    /**
     * Gets the exposure attribute of this distributor.
     * @return The exposure setting.
     */
    public double getExposure() {
        return this.exposure;
    }

    /**
     * Sets the speed attribute of this distributor.
     * @param speed The speed setting.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Gets the speed attribute of this distributor.
     * @return The speed setting.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the carbon attribute of this distributor.
     * @param carbon The carbon setting.
     */
    public void setCarbon(double carbon) {
        this.carbon = carbon;
    }

    /**
     * Gets the carbon attribute of this distributor.
     * @return The carbon setting.
     */
    public double getCarbon() {
        return carbon;
    }

    /**
     * Sets the ranking of this distributor.
     * @param ranking The ranking.
     */
    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

}
