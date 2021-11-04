import Entities.Distributor;
import Entities.Farmer;
import UseCases.RankingManager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class RankingManagerTest {

    private RankingManager rankingManager;

    @Before
    public void setUp(){
        HashMap<String, Double> prodMap = new HashMap<>();
        prodMap.put("Orange", 3.00); // Constant price for now
        ArrayList<Distributor> allDist= new ArrayList<>();
        allDist.add(new Distributor("Onyx", "A", prodMap));
        allDist.add(new Distributor("Andy", "B", prodMap));
        allDist.add(new Distributor("Patrick", "C", prodMap));
        allDist.add(new Distributor("Mark", "D", prodMap));
        allDist.add(new Distributor("Divit", "E", prodMap));
        allDist.add(new Distributor("Melaney", "F", prodMap));
        allDist.add(new Distributor("Jagat", "G", prodMap));
        for (int i = 0; i < allDist.size(); i++){
            allDist.get(i).setExposure(i); // exposure metric rises by 1 as we go up
            allDist.get(i).setSpeed(30 - 2 * i); // number of hours decreases from 30 by 2 as we go up
            allDist.get(i).setCarbon(10 * i + 5); // number of g CO2eq increases from 5 by 10 as we go up
        }
        Farmer farmer = new Farmer("Pooria", "H");
        farmer.setPrefPrice(0);
        farmer.setPrefExposure(0);
        farmer.setPrefSpeed(10);
        farmer.setPrefCarbon(0);
        this.rankingManager = new RankingManager(allDist, farmer, "Orange", 3.00);

    }

    @Test(timeout = 50)
    public void TestRankDistributors() {
        RankingManager rm = this.rankingManager;
        ArrayList<Distributor> rankedList = rm.rankDistributors();
        Collections.reverse(rankedList);
        assertEquals(rankedList, rm.getAllDistributors());
    }

    @Test
    public void TestCalcPriceRanking() {

    }

    @Test
    public void TestCalcRanking() {
    }

    @Test
    public void TestGetCriterion() {
        RankingManager rm = this.rankingManager;
        assertEquals(rm.getCriterion(rm.getAllDistributors().get(0), "carbon"), 5);
    }

    @Test
    public void TestGetPrefCriterion() {
        RankingManager rm = this.rankingManager;
        assertEquals(rm.getPrefCriterion(rm.getFarmer(), "exposure"), 0);
    }
}
