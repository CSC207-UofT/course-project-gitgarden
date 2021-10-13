import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Distributor extends User {

    //Initialize list of requests
    private Request[] requests;
    //I am using array to show list of request for now, but depending on request's structure, it could be changed later

    public Distributor(String distributor_name, String distributor_address){
        super(distributor_name, distributor_address);
        this.requests = null;
    }

    public Request[] getRequests() {
        return requests;
    }

}
