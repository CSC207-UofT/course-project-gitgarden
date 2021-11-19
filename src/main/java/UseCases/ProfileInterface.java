package UseCases;

import Entities.*;

import java.util.ArrayList;

public interface ProfileInterface {
    void createFarmer(String name, String address);

    void createDistributor(String name, String address);

    void modifyUser(IUser user, String newName, String address);

    void modifyFarmer(IFarmer farmer, double slider1, double slider2, double slider3, double slider4);

    void modifyDistributor(IDistributor dist, double slider2, double slider3, double slider4);

    ArrayList<String> getAllNames();

    ArrayList<IFarmer> getFarmerList();

    ArrayList<IDistributor> getDistributorList();
}
