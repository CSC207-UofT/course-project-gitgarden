package Entities;

import java.util.ArrayList;

public interface IFarmer {
    void add_request(Request request);

    void remove_request(Request request);

    ArrayList<RequestStructure> getCurrent_requests();

    void add_offer(Offer offer);

    void remove_offer(Offer offer);

    ArrayList<Offer> getOffer_history();

    //=========================================================================

    void setPrefPrice(double prefPrice);

    void setPrefExposure(double prefExposure);

    void setPrefSpeed(double prefSpeed);

    void setPrefCarbon(double prefCarbon);

    double getPrefPrice();

    double getPrefExposure();

    double getPrefSpeed();

    double getPrefCarbon();
}
