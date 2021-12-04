package DataBase;

import UseCases.DataAccessInterface;

import UseCases.JsonAdapter;
import UseCases.ProfileManager;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;

public class JsonProvider implements DataAccessInterface {
    Gson gson = new Gson();


    /**
     * Read the saved json files and convert everything into Java
     * @param fileName The file name of the saved json file containing farmers
     * @return list of farmers
     */
    @Override
    public ArrayList<String[]> readFarmer(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        return gson.fromJson(reader, new TypeToken<ArrayList<String[]>>() {}.getType());
    }


    /**
     * Read the saved json files and convert everything into Java
     * @param fileName The file name of the saved json file containing distributors
     * @return list of distributors
     */
    @Override
    public ArrayList<String[]> readDistributor(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        return gson.fromJson(reader, new TypeToken<ArrayList<String[]>>() {}.getType());
    }


    /**
     * Take the farmerList and distributorList, convert them to json format and save them
     * as "distributors.json" and "farmers.json"
     */
    @Override
    public void writeUsers(){


        //This writes distributor names to json
        try(FileWriter writer = new FileWriter("distributors.json")){
            JsonAdapter ja = new JsonAdapter();
            writer.write(gson.toJson(ja.distAdapter()));
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }


        //This writes farmer names to json
        try(FileWriter writer = new FileWriter("farmers.json")){
            JsonAdapter ja = new JsonAdapter();
            writer.write(gson.toJson(ja.farmerAdapter()));
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Create Farmers based on the json file read
     * @param fileName the file name of the json file that stores farmer information
     */
    @Override
    public void loadFarmer(String fileName) throws FileNotFoundException{
        ArrayList<String[]> farmers = readFarmer(fileName);
        if (farmers != null){
            ProfileManager pm = new ProfileManager();
            for (String[] f : farmers){
                pm.createFarmer(f[0], f[1], Integer.parseInt(f[2]));
            }
        }
    }


    /**
     * Create Distributors based on the json file read
     * @param fileName the file name of the json file that stores distributor information
     */
    @Override
    public void loadDistributor(String fileName) throws FileNotFoundException{
        ArrayList<String[]> dists = readDistributor(fileName);
        if (dists != null){
            ProfileManager pm = new ProfileManager();
            for (String[] f : dists){
                pm.createFarmer(f[0], f[1], Integer.parseInt(f[2]));
            }
        }
    }

}
