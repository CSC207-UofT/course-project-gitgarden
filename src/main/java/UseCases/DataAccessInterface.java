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
     * Load the Farmer from previously saved files
     * @param farmers list of Farmers that needs to be converted to IFarmer and add to farmerList.
     */
    void loadFarmer(Farmer[] farmers);

    /**
     * Load the Distributor from previously saved files
     * @param distributors list of Distributors that needs to be converted to IDistributor and add to
     *                     distributorList.
     */
    void loadDistributor(Distributor[] distributors);

}
