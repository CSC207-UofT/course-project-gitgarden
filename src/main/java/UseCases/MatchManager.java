package UseCases;

import Entities.Distributor;

import java.util.ArrayList;

/*
 * MatchSystem - Onyx
 * Class name: MatchSystem
 * Parent Class: None
 * Use Case
 *
 * Responsibilities:
 * * Takes input of a single request
 * * Return a list of recommended distributors, based on the given farmer's preferences
 * * Receive distributor info and output a list of recommended farmers [expansion]
 * * Create offer using distributor's information [expansion]
 *
 * Collaborators:
 *  Entities.Farmer
 *  Entities.Distributor
 *  RankingSystem
 *  UseCases.ProfileManager
 *  Entities.Request
 *  Offer
 *  Controller.ServiceController
 */

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
