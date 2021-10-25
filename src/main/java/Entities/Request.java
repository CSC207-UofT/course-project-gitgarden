package Entities;

public class Request {

    private String FarmerName;
    private String FarmerAddress;
    private String ProductName;
    private int ProductQuantity;
    private float ProductPrice;
    //private ArrayList<Offer> Offer;

    public Request(String FName, String FAddress, String PName, int PQuantity,
                   float PPrice) {

        FarmerName = FName;
        FarmerAddress = FAddress;
        ProductName = PName;
        ProductQuantity = PQuantity;
        ProductPrice = PPrice;
        //Offer = Offers;
    }

    /**
     *
     */
    public void setFarmerName(String FarmerName){
        this.FarmerName = FarmerName;
    }

    public String getFarmerName(){
        return this.FarmerName;
    }

    /**
     *
     */
    public void setFarmerAddress(String FarmerAddress){
        this.FarmerAddress = FarmerAddress;
    }

    public String getFarmerAddress(){
        return this.FarmerAddress;
    }

    /**
     *
     */
    public void setProductName(String ProductName){
        this.ProductName = ProductName;
    }

    public String getProductName(){
        return this.ProductName;
    }

    /**
     *
     */
    public void setProductQuantity(int ProductQuantity){
        this.ProductQuantity = ProductQuantity;
    }

    public int getProductQuantity(){
        return this.ProductQuantity;
    }

    /**
     *
     */
    public void setProductPrice(float ProductPrice){
        this.ProductPrice = ProductPrice;
    }

    public float getProductPrice(){
        return this.ProductPrice;
    }

    public String toString(){
        return "Name: " + this.FarmerName + "\n" +
                "Address: " + this.FarmerAddress + "\n" +
                "Product: " + this.ProductName + "\n" +
                "Quantity: " + this.ProductQuantity + "\n" +
                "Price: " + this.ProductPrice;
    }

}