package Controller;

import Entities.Distributor;
import Entities.Farmer;
import Entities.Request;
import UseCases.MatchManager;
import UseCases.ProfileManager;
import Entities.Offer;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceController {

    /**
     * Method for UserInterface, pass parameters to ProfileManager if the input is valid
     * @param name  Name of the user
     * @param address   Address of the user
     */

    public static void createProfile(String name, String address, double slider1, double slider2, double slider3,
                                     double slider4, boolean flag) throws Exception{
        if (isAlphanumeric(name)){
            ProfileManager.createUser(name, address, slider1, slider2, slider3, slider4, flag);
        }
        else {
            throw new Exception("Your input is not valid!");
        }
    }

    /**
     * Method for UserInterface, pass parameters to ProfileManager if the input is valid
     * @param farmer Farmer object
     * @param name   Name of the product
     * @param quantity  Quantity of the product
     * @param price     Price of the product per kilogram
     */
    public static ArrayList<Distributor> createRequest(Entities.Farmer farmer, String name, String quantity,
                                                       String price) throws Exception{
        if (isAlphanumeric(name) && isNumeric(quantity) && isNumeric(price)){
            Request request = new Request(farmer, name, Integer.parseInt(quantity), Float.parseFloat(price));

            farmer.current_requests.add(request);
            for (Entities.Distributor distributor : ProfileManager.distributorList) {
                distributor.current_requests.add(request);
            }

        } else {
            throw new Exception("Your input is not valid!");
        }

        return null;
    }

    public static void distributorAcceptOffer(Farmer farmer, Distributor distributor, Request request) {
        String p_name = request.getProduct_name();
        int p_quantity = request.getProduct_quantity();
        Float p_price_per_unit = request.getProduct_price_per_unit();

        Offer offer = new Offer(farmer, distributor, p_name, p_quantity, p_price_per_unit);

        farmer.offer_history.add(request);
        distributor.offer_history.add(offer);
        farmer.remove_request(request);

        if (distributor.current_requests.contains(request))
            distributor.remove_request(request);
    }

    public static void farmerAcceptOffer(Farmer farmer, Distributor distributor, Request counterOffer) {
        String p_name = counterOffer.getProduct_name();
        int p_quantity = counterOffer.getProduct_quantity();
        Float p_price_per_unit = counterOffer.getProduct_price_per_unit();

        Offer offer = new Offer(farmer, distributor, p_name, p_quantity, p_price_per_unit);

        farmer.offer_history.add(counterOffer);
        distributor.offer_history.add(offer);

        for (Request request1 : farmer.current_requests) {
            if (request1.counteroffer.contains(counterOffer)) {
                farmer.current_requests.remove(request1);
            }
        }

        distributor.current_requests.remove(counterOffer);
    }

    public static void createCounterOffer(Request request, Entities.Distributor distributor, String quantity,
                                                       String price) throws Exception{
        if (isAlphanumeric(request.getProduct_name()) && isNumeric(quantity) && isNumeric(price)){
            Request counterOffer = new Request(request.getFarmer(), request.getProduct_name(), Integer.parseInt(quantity),
                    Float.parseFloat(price));

            for (Request request1 : distributor.current_requests) {
                if (request1 == request) {
                    for (Request request2 : request1.counteroffer) {
                        if (distributor.current_requests.contains(request2)) {
                            distributor.current_requests.remove(request2);
                        }
                    }
                    request1.counteroffer.add(counterOffer);
                    distributor.current_requests.add(request1);
                }
            }


            /**
             for (Entities.Distributor distributor : ProfileManager.distributorList) {
                distributor.current_requests.add(request);
            } */

        } else {
            throw new Exception("Your input is not valid!");
        }
    }


    /**
     * Checks if the input is alphanumeric.
     * @param input     Input to the program
     * @return boolean that indicates if the input is alphanumeric.
     */
    public static boolean isAlphanumeric(String input){
        return input.matches("^[a-zA-Z0-9]*$");
    }


    /**
     * Checks if the input is numeric
     * @param input     Input from the user
     * @return boolean that indicates if the input is numeric. Exception if the
     *         string is empty or blank.
     */
    public static boolean isNumeric(String input){
        return !input.isEmpty() && !input.isBlank();
    }

}
