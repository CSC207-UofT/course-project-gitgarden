package Controller;

import java.util.ArrayList;

public interface ControllerInterface {

    // TODO: 2021/11/20  return ID
    String createProfileCheck(String name, String address, boolean flag);

    void modifyUserCheck(String Userid, String newName, String address);

    void modifyFarmerCheck(String FarmerId, double slider1, double slider2, double slider3, double slider4);

    void modifyDistributorCheck(String distId, double slider2, double slider3, double slider4);

    void createRequestCheck(String userId, String product, String quantity, String price);

    void createCounterOfferCheck(String userId, String requestId, String quantity, String price);

    // TODO: 2021/11/21 added userId
    void acceptRequestCheck(String requestId, String userId);

    void declineRequestCheck(String requestId);

    void trashRequestCheck(String requestId);

    // TODO: 2021/11/20 change this parameter, this still has instances of Iuser
    ArrayList<String> rank(ArrayList<String> distributors, String farmer, String product);

}
