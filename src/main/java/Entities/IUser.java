package Entities;

import java.util.ArrayList;

public interface IUser {

    void addRequest(IRequest request);

    void removeRequest(IRequest request);

    ArrayList<IRequest> getCurrentRequests();

    void addOffer(IRequest offer);

    void removeOffer(IRequest offer);

    ArrayList<IRequest> getOfferHistory();

    void setUserName(String name);

    String getUserName();

    int getUserId();

    void setUserAddress(String address);

    String getUserAddress();
}
