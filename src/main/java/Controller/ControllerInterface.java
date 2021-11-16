package Controller;

import Entities.IDistributor;
import Entities.IFarmer;
import Entities.IRequest;
import Entities.IUser;

import java.util.ArrayList;

public interface ControllerInterface {

    void createProfileCheck(String name, String address, boolean flag);

    void modifyUserCheck(IUser user, String newName, String address);

    void modifyFarmerCheck(IFarmer farmer, double slider1, double slider2, double slider3, double slider4);

    void modifyDistributorCheck(IDistributor dist, double slider2, double slider3, double slider4);

    void createRequestCheck(IUser user, String product, String quantity, String price);

    void createCounterOfferCheck(IUser user, IRequest request, String quantity, String price);

    void acceptRequestCheck(IRequest request);

    void declineRequestCheck(IRequest request);

    void trashRequestCheck(IRequest request);

    Object fetch(Object obj);

    ArrayList<IDistributor> rank(ArrayList<IDistributor> distributors, IFarmer farmer, String product);

}
