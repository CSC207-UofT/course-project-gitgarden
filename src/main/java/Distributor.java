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
import java.util.ArrayList;

public class Distributor extends User {

    //Initialize list of requests
    private ArrayList<Request> requests;

    //Initialize prodMap
    private HashMap<String, Double> prodMap;


    public Distributor(String distributor_name, String distributor_address, HashMap<String, Double> hashmap){
        super(distributor_name, distributor_address);
        this.requests = null;
        this.prodMap = hashmap;
    }

    public ArrayList<Request> getRequests(){
        return this.requests;
    }

    public HashMap<String, Double> getprodMap(){
        return this.prodMap;
    }
}
