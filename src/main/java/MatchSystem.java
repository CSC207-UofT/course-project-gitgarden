import java.util.ArrayList;
import java.util.List;

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
 *  Farmer
 *  Distributor
 *  RankingSystem
 *  ProfileManager
 *  Request
 *  Offer
 *  ServiceController
 */

public class MatchSystem{
    public static ArrayList<Distributor> distributors;

    /**
     *
     * @param distributors ArrayList of all potential distributors
     * @param req_name Name of product in request
     * @param req_price Price per kg of product in request
     * @return All distributors fulfilling requested criteria
     */
    public static ArrayList<Distributor> match(ArrayList<Distributor> distributors, String req_name, double req_price){
        ArrayList<Distributor> match_list = new ArrayList<>();
        for(Distributor dist: distributors){
            if (dist.getprodMap().containsKey(req_name)){
                if (dist.getprodMap().get(req_name) >= req_price){
                    match_list.add(dist);
                }

            }
        }
        return match_list;
    }
}