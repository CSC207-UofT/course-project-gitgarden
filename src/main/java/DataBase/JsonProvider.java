package DataBase;

import Entities.*;
import UseCases.DataAccessInterface;

import UseCases.ProfileManager;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class JsonProvider implements DataAccessInterface {
    Gson gson = new Gson();


    /**
     * Read the saved json files and convert everything into Java
     * @param fileName The file name of the saved json file containing farmers
     * @return list of farmers
     */
    @Override
    public Farmer[] readFarmer(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        return gson.fromJson(reader, Farmer[].class);
    }

    /**
     * Read the saved json files and convert everything into Java
     * @param fileName The file name of the saved json file containing distributors
     * @return list of distributors
     */
    @Override
    public Distributor[] readDistributor(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        return gson.fromJson(reader, Distributor[].class);
    }

    /**
     * Take the farmerList and distributorList, convert them to json format and save them
     * as "distributors.json" and "farmers.json"
     */
    @Override
    public void write(){
        try(FileWriter writer = new FileWriter("distributors.json")){
            ProfileManager pm = new ProfileManager();
            writer.write(gson.toJson(pm.getDistributorList()));
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("farmers.json")){
            ProfileManager pm = new ProfileManager();
            writer.write(gson.toJson(pm.getFarmerList()));
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
        Farmer[] farmers = readFarmer(fileName);
        if (farmers != null){
            ProfileManager pm = new ProfileManager();
            for (Farmer f : farmers){
                pm.createFarmer(f.getUserName(), f.getUserAddress(), f.getUserId());
                pm.modifyFarmer(String.valueOf(f.getUserId()), f.getPrefPrice(), f.getPrefExposure(),
                        f.getPrefSpeed(), f.getPrefCarbon());
            }
        }
    }


    /**
     * Create Distributors based on the json file read
     * @param fileName the file name of the json file that stores distributor information
     */
    @Override
    public void loadDistributor(String fileName) throws FileNotFoundException{
        Distributor[] distributors = readDistributor(fileName);
        if (distributors != null){
            ProfileManager pm = new ProfileManager();
            for (Distributor d : distributors){
                pm.createDistributor(d.getUserName(), d.getUserAddress(), d.getUserId());
                pm.modifyDistributor(String.valueOf(d.getUserId()), d.getExposure(),
                        d.getSpeed(), d.getCarbon());
            }
        }
    }

}
