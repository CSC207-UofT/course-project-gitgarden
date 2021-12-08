package UseCases;

import Entities.*;
import UseCases.RankingManager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import static java.lang.Math.*;

public class RankingManagerTest {
    RankingManager rm;

    @Before
    public void setUp(){
        ArrayList<IDistributor> allDist= new ArrayList<>();
        IDistributor a = new Distributor("Onyx", "A", 1);
        IDistributor b = new Distributor("Andy", "B", 2);
        IDistributor c = new Distributor("Patrick", "C", 3);
        IDistributor d = new Distributor("Mark", "D", 4);
        IDistributor e = new Distributor("Divit", "E", 5);
        IDistributor f = new Distributor("Melaney", "F", 6);
        IDistributor g = new Distributor("Jagat", "G", 7);

        allDist.add(a);
        allDist.add(b);
        allDist.add(c);
        allDist.add(d);
        allDist.add(e);
        allDist.add(f);
        allDist.add(g);

        rm = new RankingManager("0", "1");
        Request offer = new Request(0, "Orange", 50, 3.00, null);
        for (int i = 0; i < allDist.size(); i++){
            allDist.get(i).addOffer(offer);
            allDist.get(i).setExposure(1 + abs(i - 5));
            allDist.get(i).setSpeed(30 - 2 * i);
            allDist.get(i).setCarbon(5 + 10 * i);
        }
        IFarmer farmer = new Farmer("Pooria", "H", 8);
        farmer.setPrefPrice(0);
        farmer.setPrefExposure(0);
        farmer.setPrefSpeed(0);
        farmer.setPrefCarbon(0);

        this.rm = new RankingManager("0", "1");
    }

//Functionalities

    @Test
    public void rankDistributors(){

    }


//    public void TestRankDistributorsPrice() {
//        RankingManager rm = this.rm;
//        rm.getFarmer().setPrefPrice(10);
//       ArrayList<IDistributor> rankedList = rm.rankDistributors();
//       assertEquals(rm.getAllDistributors().get(0), rankedList.get(0));
//    }
//
//    @Test
//    public void TestRankDistributorsExposure() {
//        RankingManager rm = this.rankingManager;
//        rm.getFarmer().setPrefExposure(10);
//        ArrayList<IDistributor> rankedList = rm.rankDistributors();
//        assertEquals(rm.getAllDistributors().get(5), rankedList.get(0));
//    }
//
//    @Test
//    public void TestRankDistributorsSpeed() {
//        RankingManager rm = this.rankingManager;
//        rm.getFarmer().setPrefSpeed(10);
//        ArrayList<IDistributor> rankedList = rm.rankDistributors();
//        assertEquals(rankedList.get(6), rm.getAllDistributors().get(0));
//    }
//
//    @Test
//    public void TestRankDistributorsCarbon() {
//        RankingManager rm = this.rankingManager;
//        rm.getFarmer().setPrefCarbon(10);
//        ArrayList<IDistributor> rankedList = rm.rankDistributors();
//        assertEquals(rankedList.get(0), rm.getAllDistributors().get(0));
//    }
//
//    @Test
//    public void TestCalcRanking() {
//        RankingManager rm = this.rankingManager;
//        rm.getFarmer().setPrefExposure(10);
//        IDistributor dist = rm.getAllDistributors().get(3);
//        double exposureRanking = rm.calcRanking(dist, rm.getAllDistributors(), "exposure");
//        assertEquals(2.50 / 3, exposureRanking, 0.01);
//    }
//
//    @Test
//    public void TestGetCriterion() {
//        RankingManager rm = this.rankingManager;
//        assertEquals(rm.getCriterion(rm.getAllDistributors().get(0), "carbon"), 5, 0.01);
//    }
//
//    @Test
//    public void TestGetPrefCriterion() {
//        RankingManager rm = this.rankingManager;
//        rm.getFarmer().setPrefExposure(7);
//        assertEquals(rm.getPrefCriterion(rm.getFarmer(), "exposure"), 7, 0.01);
//    }

}
