package UseCases;

import Entities.IRequest;

import java.util.ArrayList;

public interface RequestInterface {
    void createRequest(String id, String product, Double quantity, Double price);

    void createCounterOffer(String id, String requestID, Double quantity, Double price);

    void acceptRequest(String requestID);

    void declineRequest(String requestID);

    void trashRequest(String requestID);

    String[] dataFromId(String requestID);

    ArrayList<String> coFromId(String requestID);

    IRequest getRequestFromId(String requestID);
}
