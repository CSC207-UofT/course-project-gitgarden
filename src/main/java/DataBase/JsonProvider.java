package DataBase;

import Entities.*;
import UseCases.DataAccessInterface;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.*;

import static UseCases.ProfileManager.distributorList;
import static UseCases.ProfileManager.farmerList;

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
        return gson.fromJson(reader, Farmer.class);
    }

    /**
     * Read the saved json files and convert everything into Java
     * @param fileName The file name of the saved json file containing distributors
     * @return list of distributors
     */
    @Override
    public Distributor[] readDistributor(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        return gson.fromJson(reader, Distributor.class);
    }

    /**
     * Take the farmerList and distributorList, convert them to json format and save them
     * in "distributors.json" and "farmers.json"
     */
    @Override
    public void write(){
        try(FileWriter writer = new FileWriter("distributors.json")){
            writer.write(gson.toJson(distributorList));
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("farmers.json")){
            writer.write(gson.toJson(farmerList));
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Load the farmers to farmerList based on the array returned from readFarmer()
     * @param farmers array of Farmers that needs to be converted to IFarmer and add to farmerList
     * TODO: Check whether requests and offer history work properly
     */
    @Override
    public void loadFarmer(Farmer[] farmers) {
        if(farmers != null){
            for (Farmer f : farmers){
                //TODO: Call ProfileManager will require createFarmer() to be static...
                IFarmer farmer = new Farmer(f.getUserName(), f.getUserAddress(),
                        f.getUserId());
                farmer.setPrefPrice(f.getPrefPrice());
                farmer.setPrefExposure(f.getPrefExposure());
                farmer.setPrefSpeed(f.getPrefSpeed());
                farmer.setPrefCarbon(f.getPrefCarbon());
                farmerList.add(farmer);
            }
        }
    }

    /**
     * Load the distributors to distributorList based on the array returned from readDistributor()
     * @param distributors array of Distributors that needs to be converted to IDistributor and add to
     *                     distributorList.
     * TODO: Check whether requests and offer history work properly
     */
    @Override
    public void loadDistributor(Distributor[] distributors) {
        if (distributors != null){
            for (Distributor d : distributors){
                //TODO: Call ProfileManager will require createDistributor() to be static...
                IDistributor dist = new Distributor(d.getUserName(), d.getUserAddress(),
                        d.getUserId());
                dist.setExposure(d.getExposure());
                dist.setSpeed(d.getSpeed());
                dist.setCarbon(d.getCarbon());
                distributorList.add(dist);
            }
        }
    }
}
