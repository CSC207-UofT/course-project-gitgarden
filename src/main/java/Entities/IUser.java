package Entities;

import java.util.ArrayList;

public interface IUser {

    void addRequest(Request request);

    void removeRequest(Request request);

    ArrayList<Request> getCurrentRequests();

    void addOffer(Request offer);

    void removeOffer(Request offer);

    ArrayList<Request> getOfferHistory();

    void setUserName(String name);

    String getUserName();

    int getUserId();

    void setUserAddress(String address);

    String getUserAddress();
}
