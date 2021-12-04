package UseCases;

import Entities.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface DataAccessInterface {

    /**
     * Read the saved files from the given fileName.
     * @param fileName The file name of the saved json file containing farmers/distributors
     * @return list of users
     */
    ArrayList<String> readUser(String fileName) throws FileNotFoundException;

    /**
     * Read the saved farmer files from given fileName.
     * @param fileName The file name of the saved json file containing farmers
     * @return list of farmers
     */
    ArrayList<String> readFarmer(String fileName) throws FileNotFoundException;

    /**
     * Read the saved distributor files.
     * @param fileName The file name of the saved json file containing distributors.
     * @return list of distributors
     */
    ArrayList<String> readDistributor(String fileName) throws FileNotFoundException;

    /**
     * Write the current java variables to another file type
     */
    void write();

    /**
     * Load the Farmer from previously saved files
     * @param farmers list of Farmers that needs to be converted to IFarmer and add to farmerList.
     */
    void loadFarmer(ArrayList<String> farmers);

//    /**
//     * Load the Farmer from previously saved files
//     * @param users list of Users that needs to be converted to IFarmer and add to farmerList.
//     */
//    void userLoadFarmer(String[] users);

    /**
     * Load the Distributor from previously saved files
     * @param distributors list of Distributors that needs to be converted to IDistributor and add to
     *                     distributorList.
     */
    void loadDistributor(ArrayList<String> distributors);

//    /**
//     * Load the Distributor from previously saved files
//     * @param users list of Users that needs to be converted to IDistributor and add to distributorList.
//     */
//    void userLoadDistributor(String[] users);

}
