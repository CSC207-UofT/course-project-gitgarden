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
  
}
