package UseCases;

import Entities.*;

import java.util.ArrayList;

public interface ProfileInterface {

    void createFarmer(String name, String address, int id);

    void createDistributor(String name, String address, int id);

    void modifyUser(String id, String newName, String address);

    void modifyFarmer(String id, double slider1, double slider2, double slider3, double slider4);

    void modifyDistributor(String id, double slider2, double slider3, double slider4);

    ArrayList<String> getAllFarmerNames();

    ArrayList<String> getAllDistNames();

    ArrayList<Integer> getAllIds();

    String addressFromId(String id);

    String nameFromId(String id_);

    String idFromName(String name);

    ArrayList<String> requestsFromId(String id);

    ArrayList<String> historyFromId(String id);

    IUser getUserFromId(String id);

    IUser getUserFromName(String name);
}
