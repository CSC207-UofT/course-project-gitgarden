/* CRC Class Information -------

Class name: Distributor
Parent class: User

Responsibilities:
* Store distributor’s list of offers
* Store distributor’s preferences
 [expansion]

Collaborators:
* MatchSystem
* ProfileManager

------------------------------*/

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Distributor extends User {
    private HashMap<String, Double> prodMap = new HashMap<>();

    //Initialize list of requests
    private Request[] requests;
    //I am using array to show list of request for now, but depending on request's structure, it could be changed later

    public Distributor(String distributor_name, String distributor_address, HashMap<String, Double> hashmap){
        super(distributor_name, distributor_address);
        this.requests = null;
        this.prodMap = hashmap;
    }

    public Request[] getRequests() {
        return requests;
    }

    public HashMap<String, Double> getprodMap(){
        return this.prodMap;
    }
}
