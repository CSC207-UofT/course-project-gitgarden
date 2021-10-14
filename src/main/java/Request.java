import java.util.ArrayList;

class Request {

    private String FarmerName;
    private String FarmerAddress;
    private String ProductName;
    private int ProductQuantity;
    private float ProductPrice;
    // private ArrayList<Offer> Offer;

    public Request(String FName, String FAddress, String PName, int PQuantity,
                   float PPrice) {

        FarmerName = FName;
        FarmerAddress = FAddress;
        ProductName = PName;
        ProductQuantity = PQuantity;
        ProductPrice = PPrice;
        // Offer = Offers;
    }

}