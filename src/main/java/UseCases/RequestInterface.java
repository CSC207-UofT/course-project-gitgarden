package UseCases;

import Entities.IRequest;

import java.util.ArrayList;

public interface RequestInterface {
    void createRequest(int requestID, String id, String product, Double quantity, Double price, boolean accepted);

    void createCounterOffer(int requestID, String id, String counteredRequestID, Double quantity, Double price);

    void acceptRequest(String requestID, String userID);

    void declineRequest(String requestID);

    void trashRequest(String requestID);

    String[] dataFromId(String requestID);

    ArrayList<String> coFromId(String requestID);

    ArrayList<String> requestToId(ArrayList<IRequest> requests);

    IRequest getRequestFromId(String requestID);

    ArrayList<Integer> getAllRequestIds();
}
