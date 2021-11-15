package UseCases;

import Entities.IRequest;
import Entities.IUser;
import Entities.Request;

public class RequestManager implements RequestInterface{

    public void createRequest(IUser user, String product, Double quantity, Double price) {
        IRequest request = new Request(user, product, quantity, price, null);
        user.addRequest(request);
    }

    public void createCounterOffer(IUser user, IRequest request, Double quantity, Double price){
        IRequest co = new Request(user, request.getProdName(), quantity, price, request);
        request.add(co); // Adds co as a counteroffer to previous request
        if (request.getPrevious().getPrevious() != null){
            user.removeRequest(request);
            request.getPrevious().getUser().removeRequest(request);
        }
        user.addRequest(co); // Adds co to user's current
        request.getPrevious().getUser().addRequest(co); // Adds co to previous user's current
    }

    public void acceptRequest(IRequest request){
        IUser previousUser = request.getPrevious().getUser();
        request.getUser().addOffer(request);
        previousUser.addOffer(request);
        IRequest root = requestRoot(request);
        root.getUser().removeRequest(root);

    }

    private IRequest requestRoot(IRequest request){
        IRequest previous = request.getPrevious();
        if(previous == null){
            return request;
        } else {
            return requestRoot(previous);
        }
    }
}
