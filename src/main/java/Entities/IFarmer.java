package Entities;

public interface IFarmer extends IUser {

    /**
     * Sets the price preference of this farmer.
     *
     * @param prefPrice The price preference.
     */
    void setPrefPrice(double prefPrice);

    /**
     * Sets the exposure preference of this farmer.
     *
     * @param prefExposure The exposure preference.
     */
    void setPrefExposure(double prefExposure);

    /**
     * Sets the speed preference of this farmer.
     *
     * @param prefSpeed The speed preference.
     */
    void setPrefSpeed(double prefSpeed);

    /**
     * Sets the carbon preference of this farmer.
     *
     * @param prefCarbon The carbon preference.
     */
    void setPrefCarbon(double prefCarbon);

    /**
     * Gets the price preference of this farmer.
     *
     * @return The price preference.
     */
    double getPrefPrice();

    /**
     * Gets the exposure preference of this farmer.
     *
     * @return The exposure preference.
     */
    double getPrefExposure();

    /**
     * Gets the speed preference of this farmer.
     *
     * @return The speed preference.
     */
    double getPrefSpeed();

    /**
     * Gets the carbon preference of this farmer.
     *
     * @return The carbon preference.
     */
    double getPrefCarbon();
}
