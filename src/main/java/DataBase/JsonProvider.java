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
     * Load the farmers to farmerList based on the array returned from readFarmer()
     * @param farmers array of Farmers that needs to be converted to IFarmer and add to farmerList
     * TODO: Check whether requests and offer history work properly
     */
    @Override
    public void loadFarmer(Farmer[] farmers) {
        if(farmers != null){
            for (Farmer f : farmers){
                ProfileManager pm = new ProfileManager();
                pm.createFarmer(f.getUserName(), f.getUserAddress(), f.getUserId());
                pm.modifyFarmer(String.valueOf(f.getUserId()), f.getPrefPrice(),
                        f.getPrefExposure(), f.getPrefSpeed(), f.getPrefCarbon());
                /*
                In case the above code does not work as intended.../interact directly with Entities
                rather than using ProfileManager.
                 */
//                IFarmer farmer = new Farmer(f.getUserName(), f.getUserAddress(),
//                        f.getUserId());
//                farmer.setPrefPrice(f.getPrefPrice());
//                farmer.setPrefExposure(f.getPrefExposure());
//                farmer.setPrefSpeed(f.getPrefSpeed());
//                farmer.setPrefCarbon(f.getPrefCarbon());
//                farmerList.add(farmer);
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
                ProfileManager pm = new ProfileManager();
                pm.createDistributor(d.getUserName(), d.getUserAddress(), d.getUserId());
                pm.modifyDistributor(String.valueOf(d.getUserId()), d.getExposure(),
                        d.getSpeed(), d.getCarbon());
                /*
                In case the above code does not work as intended.../interact directly with Entities
                rather than using ProfileManager.
                 */
//                IDistributor dist = new Distributor(d.getUserName(), d.getUserAddress(),
//                        d.getUserId());
//                dist.setExposure(d.getExposure());
//                dist.setSpeed(d.getSpeed());
//                dist.setCarbon(d.getCarbon());
//                distributorList.add(dist);
            }
        }
    }
}
