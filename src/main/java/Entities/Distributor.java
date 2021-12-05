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

    public static class Momento {

        private String name;
        private String address;
        private double exposure;
        private double speed;
        private double carbon;
        // private double ranking;

        public Momento(String name, String address, double prefExposure, double prefSpeed, double prefCarbon) {

            this.name = name;
            this.address = address;
            this.exposure = prefExposure;
            this.speed = prefSpeed;
            this.carbon = prefCarbon;
            // this.ranking = ranking;
        }

        public Distributor.Momento getState() {
            return this;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public double getExposure() {
            return exposure;
        }

        public double getSpeed() {
            return speed;
        }

        public double getCarbon() {
            return carbon;
        }
    }

}

