package UseCases;

import Entities.IRequest;
import Entities.IUser;

import java.util.ArrayList;

public interface RequestInterface {
    void createRequest(IUser user, String product, Double quantity, Double price);

    void createCounterOffer(IUser user, IRequest request, Double quantity, Double price);

    void acceptRequest(IRequest request);

    void declineRequest(IRequest request);

    void trashRequest(IRequest request);

    String nameFromID(String requestID, String userName);

    String productFromID(String requestID, String userName);

    String quantityFromID(String requestID, String userName);

    String priceFromID(String requestID, String userName);

    ArrayList<String> coFromID(String requestID, String userName);

    String previousIDFromID(String requestID, String userName);
}
