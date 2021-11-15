package UseCases;

import Entities.IRequest;
import Entities.IUser;

public interface RequestInterface {
    void createRequest(IUser user, String product, Double quantity, Double price);

    void createCounterOffer(IUser user, IRequest request, Double quantity, Double price);

    void acceptRequest(IRequest request);
}
