package DataBase;

import Entities.*;
import UseCases.DataAccessInterface;

import UseCases.ProfileManager;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import javax.swing.plaf.metal.MetalRadioButtonUI;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class JsonProvider implements DataAccessInterface {
    Gson gson = new Gson();

    /**
     * Read the save json files and convert everything into Java
     * @param fileName the file name of the save json file containing farmers/distributors
     * @return list of users
     */
    @Override
    public ArrayList<String> readUser(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        User[] users = gson.fromJson(reader, User[].class);
        ArrayList<String> res = new ArrayList<>();
        for (Object u:users) {
            res.add(u.toString());
        }
        return res;
    }

    /**
     * Read the saved json files and convert everything into Java
     * @param fileName The file name of the saved json file containing farmers
     * @return list of farmers
     */
    @Override
    public ArrayList<String> readFarmer(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        Farmer[] farmers = gson.fromJson(reader, Farmer[].class);
        ArrayList<String> res = new ArrayList<>();
        for (Object u:farmers) {
            res.add(u.toString());
        }
        return res;
    }

    /**
     * Read the saved json files and convert everything into Java
     * @param fileName The file name of the saved json file containing distributors
     * @return list of distributors
     */
    @Override
    public ArrayList<String> readDistributor(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(fileName));
        Farmer[] farmers = gson.fromJson(reader, Distributor[].class);
        ArrayList<String> res = new ArrayList<>();
        for (Object u:farmers) {
            res.add(u.toString());
        }
        return res;
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
     * Load the farmers to farmerList based on the list returned from readFarmer()
     * @param farmers list of Farmers that needs to be converted to IFarmer and add to farmerList
     */
    @Override
    public void loadFarmer(ArrayList<String> farmers) {
        if (farmers != null){
            ProfileManager pm = new ProfileManager();
//            for (Object f : farmers){
//
//            }
//            for (Farmer f : farmers){
//                pm.createFarmer(f.getUserName(), f.getUserAddress(), f.getUserId());
//                pm.modifyFarmer(String.valueOf(f.getUserId()), f.getPrefPrice(),
//                        f.getPrefExposure(), f.getPrefSpeed(), f.getPrefCarbon());
            }
//        }
    }


//    /**
//     * Load the farmers to farmerList using User object instead of Farmer
//     * @param users list of Users that needs to be converted to IFarmer and add to farmerList.
//     */
//    public void userLoadFarmer(String [] users){
//        if(users != null){
//            ProfileManager pm = new ProfileManager();
//            for (User u : users){
//                pm.createFarmer(u.getUserName(), u.getUserAddress(), u.getUserId());
//            }
//        }
//    }


    /**
     * Load the distributors to distributorList based on the list returned from readDistributor()
     * @param distributors list of Distributors that needs to be converted to IDistributor and add to
     *                     distributorList.
     */
    @Override
    public void loadDistributor(ArrayList<String> distributors) {
        if (distributors != null){
            ProfileManager pm = new ProfileManager();
//            for (Distributor d : distributors){
//                pm.createDistributor(d.getUserName(), d.getUserAddress(), d.getUserId());
//                pm.modifyDistributor(String.valueOf(d.getUserId()), d.getExposure(),
//                        d.getSpeed(), d.getCarbon());
//            }
        }
    }


//    /**
//     * Load the distributors to distributorList using User object instead of Distributor
//     * @param users list of Users that needs to be converted to IDistributor and add to distributorList.
//     */
//    @Override
//    public void userLoadDistributor(String[] users){
//        if(users != null){
//            ProfileManager pm = new ProfileManager();
////            for (User u : users){
////                pm.createDistributor(u.getUserName(), u.getUserAddress(), u.getUserId());
////            }
//        }
//    }
}
