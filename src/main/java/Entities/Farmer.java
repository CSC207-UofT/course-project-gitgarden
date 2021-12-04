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

    public void setPrefPrice(double prefPrice) {
        this.prefPrice = prefPrice;
    }

    public void setPrefExposure(double prefExposure) {
        this.prefExposure = prefExposure;
    }

    public void setPrefSpeed(double prefSpeed) {
        this.prefSpeed = prefSpeed;
    }

    public void setPrefCarbon(double prefCarbon) {
        this.prefCarbon = prefCarbon;
    }

    public double getPrefPrice(){
        return prefPrice;
    }

    public double getPrefExposure(){
        return prefExposure;
    }

    public double getPrefSpeed(){
        return prefSpeed;
    }

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
