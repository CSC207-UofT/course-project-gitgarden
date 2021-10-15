import java.util.HashMap;

public class Distributor extends User {
    private HashMap<String, Double> prodMap;

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
