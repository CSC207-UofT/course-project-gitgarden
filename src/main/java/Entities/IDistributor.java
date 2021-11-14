package Entities;

import java.util.HashMap;

public interface IDistributor extends Comparable<Distributor>{

    HashMap<String, Double> prodMap();

    int compareTo(Distributor other);

    void setExposure(double exposure);

    void setSpeed(double speed);

    void setCarbon(double carbon);

    double getSpeed();

    double getExposure();

    double getCarbon();

    void setRanking(double ranking);
}
