package UseCases;

import Entities.IDistributor;
import Entities.IRequest;
import Entities.Request;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class RatingStructure{

    public static void rate(String request, double rating){
        RequestManager requestManager = new RequestManager();
        requestManager.getRequestFromId(request).setRating(rating);
    }

    public static void displayRating(Request request){
        System.out.println(request.getRating());
    }
}
