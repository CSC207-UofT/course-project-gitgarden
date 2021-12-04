package UseCases;

import Entities.Distributor;
import Entities.IDistributor;
import Entities.IFarmer;
import Entities.IRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.round;

public class RankingManager implements RankInterface {

    private static final double SINGLE_RANKING = 2.5;

    private final String requestID;
    private final String farmerID;

    public RankingManager(String requestID, String farmerID) {
        this.requestID = requestID;
        this.farmerID = farmerID;
    }

    @Override
    public ArrayList<String> rankDistributors(){
        ArrayList<IDistributor> rankList = distributorsFromRequestId(requestID);

        for (IDistributor dist: rankList){
            double priceRanking = calcRanking(dist, rankList, "price");
            double exposureRanking = calcRanking(dist, rankList, "exposure");
            double speedRanking = calcRanking(dist, rankList, "speed");
            double carbonRanking = calcRanking(dist, rankList, "carbon");
            double distRanking = priceRanking + exposureRanking + speedRanking + carbonRanking;
            dist.setRanking(distRanking);
        }
        rankList.sort(Collections.reverseOrder());
        return counterofferIdsFromDistributors(rankList);
    }

    public double calcRanking(IDistributor input_dist, ArrayList<IDistributor> rankList, String crit) {
        ProfileInterface pm = new ProfileManager();
        ArrayList<Double> critList = new ArrayList<>();
        for (IDistributor dist : rankList) { critList.add(getCriterion(dist, crit)); }
        Collections.sort(critList);
        IFarmer farmer = (IFarmer) pm.getUserFromId(farmerID);
        Double ref = critList.get((int) round((critList.size() - 1) * (1 - (getPrefCriterion(farmer, crit) / 10.0))));
        double ratio = ref / (getCriterion(input_dist, crit) + 0.01);
        if (ratio >= 1) {
            return SINGLE_RANKING;
        } else {
            return SINGLE_RANKING * ratio;
        }
    }

    public double getCriterion(IDistributor dist, String criterion){
        switch (criterion) {
            case "exposure":
                return dist.getExposure();
            case "speed":
                return dist.getSpeed();
            case "carbon":
                return dist.getCarbon();
            default:
                return dist.prodMap().getOrDefault(productFromRequestId(requestID), 0.01);

        }
    }

    public double getPrefCriterion(IFarmer farmer, String criterion) {
        switch (criterion) {
            case "exposure":
                return farmer.getPrefExposure();
            case "speed":
                return farmer.getPrefSpeed();
            case "carbon":
                return farmer.getPrefCarbon();
            default:
                return farmer.getPrefPrice();
        }
    }

    private ArrayList<IDistributor> distributorsFromRequestId(String requestID) {
        RequestInterface requestManager = new RequestManager();
        ArrayList<IDistributor> allDistributors = new ArrayList<>();
        IRequest request = requestManager.getRequestFromId(requestID);
        for (IRequest counteroffer: request.getCounteroffers()){
            allDistributors.add((IDistributor) counteroffer.getUser());
        }
        return allDistributors;
    }

    private ArrayList<String> counterofferIdsFromDistributors(ArrayList<IDistributor> rankList){
        ArrayList<String> allIds = new ArrayList<>();
        RequestInterface requestManager = new RequestManager();
        IRequest request = requestManager.getRequestFromId(requestID);
        for (IDistributor dist: rankList){
            for (IRequest counteroffer: request.getCounteroffers()){
                if (counteroffer.getUser().equals(dist)){
                    allIds.add(String.valueOf(counteroffer.getRequestId()));
                }
            }

        }
        return allIds;
    }

    private String productFromRequestId(String requestID){
        RequestInterface requestManager = new RequestManager();
        IRequest request = requestManager.getRequestFromId(requestID);
        return request.getProdName();
    }

    /**
     *Rating Structure
     */
    public static double roundHundredth(double value){
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(2, RoundingMode.UP).doubleValue();
    }

    public static boolean isLegal(double value){
        return (1 <= value && value <= 10);
    }

    public static Double getHistoryAvg(IDistributor user){
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

    public ArrayList<String> rateDistributors(){
        ArrayList<IDistributor> distributors = distributorsFromRequestId(requestID);
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

        return counterofferIdsFromDistributors(distributors);
    }

}
