package Controller;

import Entities.IDistributor;
import Entities.IFarmer;
import Entities.IRequest;
import Entities.IUser;

import java.util.ArrayList;

public interface ControllerInterface {

    // TODO: 2021/11/20  return ID
    String createProfileCheck(String name, String address, boolean flag);

    void modifyUserCheck(String Userid, String newName, String address);

    void modifyFarmerCheck(String FarmerId, double slider1, double slider2, double slider3, double slider4);

    void modifyDistributorCheck(String distId, double slider2, double slider3, double slider4);

    void createRequestCheck(String userId, String product, String quantity, String price);

    void createCounterOfferCheck(String userId, String requestId, String quantity, String price);

    void acceptRequestCheck(String requestId);

    void declineRequestCheck(String requestId);

    void trashRequestCheck(String requestId);

    Object fetch(Object obj);

    // TODO: 2021/11/20 change this parameter, this still has instances of Iuser
    ArrayList<IDistributor> rank(ArrayList<IDistributor> distributors, IFarmer farmer, String product);

}
