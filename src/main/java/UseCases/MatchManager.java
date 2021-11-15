package UseCases;

import Entities.IDistributor;

import java.util.ArrayList;

public class MatchManager {
    /**
     *
     * @param distributors ArrayList of all potential distributors
     * @param req_name Name of product in request
     * @param req_price Price per kg of product in request
     * @return All distributors fulfilling requested criteria
     */
    public static ArrayList<IDistributor> match(ArrayList<IDistributor> distributors, String req_name, String req_price){
        ArrayList<IDistributor> match_list = new ArrayList<>();
        for(IDistributor dist: distributors){
            if (dist.prodMap().containsKey(req_name)){
                if (dist.prodMap().get(req_name) >= Double.parseDouble(req_price)){
                    match_list.add(dist);
                }

            }
        }
        return match_list;
    }
}