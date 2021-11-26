package UseCases;

import Entities.*;
import UseCases.ProfileManager;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataAccessInterface {

    /*
    Read the saved farmer files.
     */
    Farmer[] readFarmer(String fileName) throws FileNotFoundException;

    /*
    Read the saved distributor files.
     */
    Distributor[] readDistributor(String fileName) throws FileNotFoundException;

    /*
    Write the current java variables to another file type
     */
    void write();

    /*
    Load the Farmer from previously saved files
     */
    void loadFarmer(Farmer[] farmers);

    /*
    Load the Distributor from previously saved files
     */
    void loadDistributor(Distributor[] distributors);

}
