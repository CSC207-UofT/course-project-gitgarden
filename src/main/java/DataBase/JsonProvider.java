package DataBase;

import UseCases.DataAccessInterface;

import Entities.Distributor;
import Entities.Farmer;
import Entities.Request;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.*;

import static UseCases.ProfileManager.distributorList;
import static UseCases.ProfileManager.farmerList;

public class JsonProvider implements DataAccessInterface {
    Gson gson = new Gson();

    @Override
    public void read(){

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

    @Override
    public void loadFarmer() {

    }

    @Override
    public void loadDistributor() {

    }
}
