package Entities;

import Entities.Request;

import java.util.HashMap;
import java.util.ArrayList;

public class Distributor extends User implements Comparable<Distributor>{

    //Initialize list of requests

    private ArrayList<Request> requests;

    //Initialize prodMap
    private HashMap<String, Double> prodMap;

    private int exposure; // TODO: what is the hard metric
    private int speed; // Average number of hours in which transactions are completed after being finalized
    private int carbon; // Number of grams CO2eq emitted per transaction

    private double ranking; // Comparable object


    public Distributor(String distributor_name, String distributor_address, HashMap<String, Double> hashmap){
        super(distributor_name, distributor_address);
        this.requests = null;
        this.prodMap = hashmap;
    }

    public int compareTo(Distributor other){
        return Double.compare(this.ranking, other.ranking);
    }

    public void setProdMap(HashMap<String, Double> prodMap){
        this.prodMap = prodMap;
    }

    public void setExposure(int exposure) {
        this.exposure = exposure;
    }

    public int getExposure() {
        return exposure;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCarbon(int carbon) {
        this.carbon = carbon;
    }

    public int getCarbon() {
        return carbon;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public void addRequest(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public ArrayList<Request> getRequests(){
        return this.requests;
    }

    public HashMap<String, Double> getProdMap(){
        return this.prodMap;
    }
}
