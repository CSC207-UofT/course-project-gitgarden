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

    }
