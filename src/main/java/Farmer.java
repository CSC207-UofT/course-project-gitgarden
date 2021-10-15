/* CRC Class Information -------

Class name: Farmer
Parent Class: User

Responsibilities:
* Stores farmer’s list of requests
* Store farmer's preferences [expansion]

Collaborators:
* MatchSystem
* ProfileManager

------------------------------*/

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Farmer extends User {

    //Initialize list of requests
    private Request[] requests;
    //I am using array to show list of request for now, but depending on request's structure, it could be changed later

    public Farmer(String farmer_name, String farmer_address){
        super(farmer_name, farmer_address);
        this.requests = null;
    }

    public Request[] getRequests() {
        return requests;
    }

}
