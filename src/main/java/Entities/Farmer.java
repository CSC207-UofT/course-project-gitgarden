package Entities;

public class Farmer extends User implements IFarmer{

    private double prefPrice;
    private double prefExposure;
    private double prefSpeed;
    private double prefCarbon;

    public Farmer(String farmer_name, String farmer_address, int id){
        super(farmer_name, farmer_address, id);
        this.prefPrice = 5;
        this.prefExposure = 5;
        this.prefSpeed = 5;
        this.prefCarbon = 5;
    }

    /**
     * Sets the price preference of this farmer.
     * @param prefPrice The price preference.
     */
    public void setPrefPrice(double prefPrice) {
        this.prefPrice = prefPrice;
    }

    /**
     * Sets the exposure preference of this farmer.
     * @param prefExposure The exposure preference.
     */
    public void setPrefExposure(double prefExposure) {
        this.prefExposure = prefExposure;
    }

    /**
     * Sets the speed preference of this farmer.
     * @param prefSpeed The speed preference.
     */
    public void setPrefSpeed(double prefSpeed) {
        this.prefSpeed = prefSpeed;
    }

    /**
     * Sets the carbon preference of this farmer.
     * @param prefCarbon The carbon preference.
     */
    public void setPrefCarbon(double prefCarbon) {
        this.prefCarbon = prefCarbon;
    }

    /**
     * Gets the price preference of this farmer.
     * @return The price preference.
     */
    public double getPrefPrice(){
        return prefPrice;
    }

    /**
     * Gets the exposure preference of this farmer.
     * @return The exposure preference.
     */
    public double getPrefExposure(){
        return prefExposure;
    }

    /**
     * Gets the speed preference of this farmer.
     * @return The speed preference.
     */
    public double getPrefSpeed(){
        return prefSpeed;
    }

    /**
     * Gets the carbon preference of this farmer.
     * @return The carbon preference.
     */
    public double getPrefCarbon(){
        return prefCarbon;
    }

    public static class Momento {

        private String name;
        private String address;
        private double prefPrice;

        private double prefExposure;
        private double prefSpeed;
        private double prefCarbon;

        public Momento(String name, String address, double prefPrice, double prefExposure, double prefSpeed,
                       double prefCarbon) {
            this.name = name;
            this.address = address;
            this.prefCarbon = prefCarbon;
            this.prefPrice = prefPrice;
            this.prefExposure = prefExposure;
            this.prefSpeed = prefSpeed;
        }

        public Momento getState() {
            return this;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public double getCarbon() {
            return prefCarbon;
        }

        public double getPrice() {
            return prefPrice;
        }

        public double getExposure() {
            return prefExposure;
        }

        public double getSpeed() {
            return prefSpeed;
        }
    }
  
}
