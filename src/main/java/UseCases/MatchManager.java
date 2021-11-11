package UseCases;

import Entities.Distributor;

import java.util.ArrayList;

public class MatchManager {
    /**
     *
     * @param distributors ArrayList of all potential distributors
     * @param req_name Name of product in request
     * @param req_price Price per kg of product in request
     * @return All distributors fulfilling requested criteria
     */
    public static ArrayList<Distributor> match(ArrayList<Distributor> distributors, String req_name, String req_price){
        ArrayList<Distributor> match_list = new ArrayList<>();
        for(Distributor dist: distributors){
            if (dist.getProdMap().containsKey(req_name)){
                if (dist.getProdMap().get(req_name) >= Double.parseDouble(req_price)){
                    match_list.add(dist);
                }

            }
        }
        return match_list;
    }
}