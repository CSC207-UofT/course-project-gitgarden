package Entities;

import java.util.HashMap;

public interface IDistributor extends Comparable<Distributor>, IUser {

    /**
     * Returns the product map of the distributor: the average price of each product they sell.
     *
     * @return The product map.
     */
    HashMap<String, Double> prodMap();

    /**
     * Compares two distributors based on ranking.
     *
     * @param other The distributor to be compared with.
     * @return -1 if other is greater, 0 if equal, 1 if other is lesser.
     */
    int compareTo(Distributor other);

    /**
     * Sets the exposure attribute of this distributor.
     *
     * @param exposure The exposure setting.
     */
    void setExposure(double exposure);

    /**
     * Gets the exposure attribute of this distributor.
     *
     * @return The exposure setting.
     */
    double getExposure();

    /**
     * Sets the speed attribute of this distributor.
     *
     * @param speed The speed setting.
     */
    void setSpeed(double speed);

    /**
     * Gets the speed attribute of this distributor.
     *
     * @return The speed setting.
     */
    double getSpeed();

    /**
     * Sets the carbon attribute of this distributor.
     *
     * @param carbon The carbon setting.
     */
    void setCarbon(double carbon);

    /**
     * Gets the carbon attribute of this distributor.
     *
     * @return The carbon setting.
     */
    double getCarbon();

    /**
     * Sets the ranking of this distributor.
     *
     * @param ranking The ranking.
     */
    void setRanking(double ranking);
}
