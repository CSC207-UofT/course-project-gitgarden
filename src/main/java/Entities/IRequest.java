package Entities;

import java.util.ArrayList;

public interface IRequest {

    void add(Request request);

    void remove(Request request);

    ArrayList<Request> getCounteroffers();

    int getRequestId();

    User getUser();

    String getProdName();

    int getProdQuantity();

    double getProdPricePerKg();
}
