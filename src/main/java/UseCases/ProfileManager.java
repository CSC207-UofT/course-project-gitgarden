package UseCases;

import Entities.Distributor;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileManager {
    //public static ArrayList<User> farmerList = new ArrayList<>();
    public static ArrayList<Distributor> distributorList = new ArrayList<>();

    public static void createDistributor(String name, String address, HashMap<String, Double> prodMap){
        Distributor dist = new Distributor(name, address, prodMap);
        distributorList.add(dist);
    }

    public static void main(String[] args) throws IOException {
        //Created these two distributors for testing purposes.
        createDistributor("Mark","Toronto", null);
        createDistributor("Divit","Toronto", null);

        //This will convert distributorList to a json format.
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter("dists.json")){
            writer.write(gson.toJson(distributorList));
            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
