package UseCases;

import Entities.IDistributor;
import Entities.IRequest;
import Entities.Request;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class RatingStructure extends RankingManager{

    public RatingStructure(String requestID, String farmerID) {
        super(requestID, farmerID);
    }

    public static void rate(Request request, int rating){
        request.setRating(rating);
    }

    public static void displayRating(Request request){
        System.out.println(request.getRating());
    }

    public static double roundHundredth(double value){
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(2, RoundingMode.UP).doubleValue();
    }

    public static boolean isLegal(int value){
        return (1 <= value && value <= 10);
    }

    public static double getHistoryAvg(IDistributor user){
        ArrayList<IRequest> temp = user.getOfferHistory();
        int value = 0;
        double count = 0;
        for(IRequest offer: temp){
            if (isLegal(offer.getRating())){
                value += offer.getRating();
                count += 1.0;
            }
        }

        if (count != 0){
            return roundHundredth(value / count);
        }
        else{
            return 0.00d;
        }
    }

    public ArrayList<String> rankDistributors(ArrayList<IDistributor> distributors){
        IDistributor[] temp = new IDistributor[distributors.size()];
        distributors.toArray(temp);

        for (int i = 0; i < distributors.toArray().length - 1; i++){
            int min = i;
            for (int j = i + 1; j < distributors.toArray().length - 1; j++) {
                if (getHistoryAvg(temp[i]) > getHistoryAvg(temp[min])){
                    min = j;
                }
            }
            if (i != min) {
                IDistributor n = temp[min];
                temp[min] = temp[i];
                temp[i] = n;
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        for (IDistributor user: temp){
            result.add(user.getUserName());
        }

        return result;
    }


}
