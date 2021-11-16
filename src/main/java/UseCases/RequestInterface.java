package UseCases;

import Entities.IDistributor;
import Entities.IFarmer;
import Entities.IRequest;
import Entities.IUser;

import java.util.ArrayList;

public interface RequestInterface {
    void createRequest(IUser user, String product, Double quantity, Double price);

    void createCounterOffer(IUser user, IRequest request, Double quantity, Double price);

    void acceptRequest(IRequest request);

    void declineRequest(IRequest request);

    void trashRequest(IRequest request);

}
