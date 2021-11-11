import Entities.Distributor;
import Entities.Farmer;
import UseCases.RankingManager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.ArrayList;
import static java.lang.Math.*;

public class RankingManagerTest {

    private RankingManager rankingManager;

    @Before
    public void setUp(){
        HashMap<String, Double> prodMap = new HashMap<>();
        ArrayList<Distributor> allDist= new ArrayList<>();
        allDist.add(new Distributor("Onyx", "A"));
        allDist.add(new Distributor("Andy", "B"));
        allDist.add(new Distributor("Patrick", "C"));
        allDist.add(new Distributor("Mark", "D"));
        allDist.add(new Distributor("Divit", "E"));
        allDist.add(new Distributor("Melaney", "F"));
        allDist.add(new Distributor("Jagat", "G"));
        for (int i = 0; i < allDist.size(); i++){
            allDist.get(i).setExposure(1 + abs(i - 5));
            allDist.get(i).setSpeed(30 - 2 * i);
            allDist.get(i).setCarbon(5 + 10 * i);
        }
        Farmer farmer = new Farmer("Pooria", "H");
        farmer.setPrefPrice(0);
        farmer.setPrefExposure(0);
        farmer.setPrefSpeed(0);
        farmer.setPrefCarbon(0);
        this.rankingManager = new RankingManager(allDist, farmer, "Orange", 3.00);

    }

    @Test
    public void TestRankDistributorsPrice() {
        RankingManager rm = this.rankingManager;
        rm.getFarmer().setPrefPrice(10);
        ArrayList<Distributor> rankedList = rm.rankDistributors();
        assertEquals(rm.getAllDistributors().get(3), rankedList.get(0));
    }

    @Test
    public void TestRankDistributorsExposure() {
        RankingManager rm = this.rankingManager;
        rm.getFarmer().setPrefExposure(10);
        ArrayList<Distributor> rankedList = rm.rankDistributors();
        assertEquals(rm.getAllDistributors().get(5), rankedList.get(0));
    }

    @Test
    public void TestRankDistributorsSpeed() {
        RankingManager rm = this.rankingManager;
        rm.getFarmer().setPrefSpeed(10);
        ArrayList<Distributor> rankedList = rm.rankDistributors();
        assertEquals(rankedList.get(6), rm.getAllDistributors().get(0));
    }

    @Test
    public void TestRankDistributorsCarbon() {
        RankingManager rm = this.rankingManager;
        rm.getFarmer().setPrefCarbon(10);
        ArrayList<Distributor> rankedList = rm.rankDistributors();
        assertEquals(rankedList.get(0), rm.getAllDistributors().get(0));
    }

    @Test
    public void TestCalcRanking() {
        RankingManager rm = this.rankingManager;
        rm.getFarmer().setPrefExposure(10);
        Distributor dist = rm.getAllDistributors().get(3);
        double exposureRanking = rm.calcRanking(dist, rm.getAllDistributors(), "exposure");
        assertEquals(2.50 / 3, exposureRanking, 0.01);
    }

    @Test
    public void TestGetCriterion() {
        RankingManager rm = this.rankingManager;
        assertEquals(rm.getCriterion(rm.getAllDistributors().get(0), "carbon"), 5, 0.01);
    }

    @Test
    public void TestGetPrefCriterion() {
        RankingManager rm = this.rankingManager;
        rm.getFarmer().setPrefExposure(7);
        assertEquals(rm.getPrefCriterion(rm.getFarmer(), "exposure"), 7);
    }
}
