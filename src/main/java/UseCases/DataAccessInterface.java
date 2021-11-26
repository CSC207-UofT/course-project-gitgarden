package UseCases;

import Entities.*;
import UseCases.ProfileManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataAccessInterface {

    /*
    Read the saved files.
     */
    void read();

    /*
    Write the current java variables to another file type
     */
    void write();

    /*
    Load the Farmer from previously saved files
     */
    void loadFarmer();

    /*
    Load the Distributor from previously saved files
     */
    void loadDistributor();

}
