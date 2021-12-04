package UseCases;

import Entities.*;

import java.io.FileNotFoundException;

public interface DataAccessInterface {

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
     * Create Farmers based on the json file read
     * @param fileName the file name of the json file that stores farmer information
     */
    void loadFarmer(String fileName) throws FileNotFoundException;

    /**
     * Create Distributors based on the json file read
      * @param fileName the file name of the json file that stores distributor information
     */
    void loadDistributor(String fileName) throws FileNotFoundException;

}
