package UseCases;

import Entities.Distributor;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public static void main(String[] args) throws FileNotFoundException {
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

        //Read json file and create distributors based on the json file.
        //Assuming that distributorList will be cleared when the program ends, thus
        //  simply calling createDistributors to add them to distributorList

        //Note that when run this code now, it will print distributorList twice since the
        // distributors from the saving as json part is still in distributorList.
        JsonReader reader = new JsonReader(new FileReader("dists.json"));
        Distributor[] distributors = gson.fromJson(reader, Distributor[].class);
        for (Distributor d : distributors) {
            createDistributor(d.getUser_name(), d.getUser_address(), null);
        }
        System.out.println(distributorList);
    }
}
