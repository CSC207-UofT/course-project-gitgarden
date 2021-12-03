package UseCases;

import Entities.*;

import java.io.File;
import java.io.FileNotFoundException;

public interface DataAccessInterface {

    /**
     * Read the saved files from the given fileName.
     * @param fileName The file name of the saved json file containing farmers/distributors
     * @return list of users
     */
    User[] readUser(String fileName) throws FileNotFoundException;

    /**
     * Read the saved farmer files from given fileName.
     * @param fileName The file name of the saved json file containing farmers
     * @return list of farmers
     */
    Farmer[] readFarmer(String fileName) throws FileNotFoundException;

    /**
     * Read the saved distributor files.
     * @param fileName The file name of the saved json file containing distributors.
     * @return list of distributors
     */
    Distributor[] readDistributor(String fileName) throws FileNotFoundException;

    /**
     * Write the current java variables to another file type
     */
    void write();

    /**
     * Load the Farmer from previously saved files
     * @param farmers list of Farmers that needs to be converted to IFarmer and add to farmerList.
     */
    void loadFarmer(Farmer[] farmers);

    /**
     * Load the Farmer from previously saved files
     * @param users list of Users that needs to be converted to IFarmer and add to farmerList.
     */
    void userLoadFarmer(User[] users);

    /**
     * Load the Distributor from previously saved files
     * @param distributors list of Distributors that needs to be converted to IDistributor and add to
     *                     distributorList.
     */
    void loadDistributor(Distributor[] distributors);

    /**
     * Load the Distributor from previously saved files
     * @param users list of Users that needs to be converted to IDistributor and add to distributorList.
     */
    void userLoadDistributor(User[] users);

}
