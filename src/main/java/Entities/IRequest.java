package Entities;

import java.util.ArrayList;

public interface IRequest {

    void add(IRequest request);

    void remove(IRequest request);

    ArrayList<IRequest> getCounteroffers();

    int getRequestId();

    IUser getUser();

    String getProdName();

    double getProdQuantity();

    double getProdPricePerKg();

    IRequest getPrevious();
}
