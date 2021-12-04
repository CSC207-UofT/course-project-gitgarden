package UseCases;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface DataAccessInterface {

    /**
     * Read the saved farmer files from given fileName.
     * @param fileName The file name of the saved json file containing farmers
     * @return list of farmers
     */
    ArrayList<String[]> readFile(String fileName) throws FileNotFoundException;


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


    /**
     * Modify Farmers based on the json file read
     * @param fileName the file name of the json file that stores modify farmer information
     */
    void modifyFarmer(String fileName) throws FileNotFoundException;


    /**
     * Modify Distributors based on the json file read
     * @param fileName the file name of the json file that stores modify distributor information
     */
    void modifyDistributor(String fileName) throws FileNotFoundException;


    /**
     * Crete Requests based on the json file read
     * @param fileName the file name of the json file that stores requests information
     */
    void loadRequests(String fileName) throws FileNotFoundException;
}
