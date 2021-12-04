package UseCases;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface DataAccessInterface {

    /**
     * Read the saved farmer files from given fileName.
     * @param fileName The file name of the saved json file containing farmers
     * @return list of farmers
     */
    ArrayList<String[]> readFarmer(String fileName) throws FileNotFoundException;

    /**
     * Read the saved distributor files.
     * @param fileName The file name of the saved json file containing distributors.
     * @return list of distributors
     */
    ArrayList<String[]> readDistributor(String fileName) throws FileNotFoundException;

    /**
     * Write the names of current farmers and distributors to another file type
     */
    void writeUsers();

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
