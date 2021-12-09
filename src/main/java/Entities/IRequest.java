package Entities;

import java.util.ArrayList;

public interface IRequest {

    /**
     * Adds a counteroffer to the request.
     *
     * @param co The counteroffer to be added.
     */
    void add(IRequest co);

    /**
     * Gets this request's counteroffers.
     *
     * @return the current counteroffers to the request.
     */
    ArrayList<IRequest> getCounteroffers();

    /**
     * Gets this request's ID.
     *
     * @return the current value of requestID.
     */
    int getRequestId();

    /**
     * Gets this request's user.
     *
     * @return The user making this request.
     */
    IUser getUser();

    /**
     * Gets this request's product name.
     *
     * @return The product name.
     */
    String getProdName();

    /**
     * Gets this request's product quantity.
     *
     * @return The product quantity.
     */
    double getProdQuantity();

    /**
     * Gets this request's product price per kilogram.
     *
     * @return The product price per kilogram.
     */
    double getProdPricePerKg();

    /**
     * Gets this request's previous request.
     *
     * @return The request to which this was a counteroffer, null if none.
     */
    IRequest getPrevious();
}
