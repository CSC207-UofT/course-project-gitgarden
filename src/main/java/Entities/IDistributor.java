package Entities;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDistributor {
    void add_request(Request request);

    void remove_request(Request request);

    ArrayList<RequestStructure> getCurrent_requests();

    void add_offer(Offer offer);

    void remove_offer(Offer offer);

    ArrayList<Offer> getOffer_history();

    HashMap<String, Float> prodMap();

    //=========================================================================

    int compareTo(Distributor other);

    void setExposure(double exposure);

    void setSpeed(double speed);

    void setCarbon(double carbon);

    double getSpeed();

    double getExposure();

    double getCarbon();

    void setRanking(double ranking);
}
