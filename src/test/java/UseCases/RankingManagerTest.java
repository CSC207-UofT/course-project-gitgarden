package UseCases;
import Controller.ServiceController;
import Entities.*;
import UseCases.RankingManager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import static java.lang.Math.*;

    public class RankingManagerTest {
        ServiceController sc;
        ProfileManager pm;
        RequestManager rm;
        RankingManager rkm;

        @Before
        public void setUp(){
            pm = new ProfileManager();
            rm = new RequestManager();
            pm.createFarmer("Pooria", "H", 8);
            pm.createDistributor("Onyx", "A", 1);
            pm.createDistributor("Andy", "B", 2);
            pm.createDistributor("Patrick", "C", 3);
            pm.createDistributor("Mark", "D", 4);
            pm.createDistributor("Divit", "E", 5);
            pm.createDistributor("Melaney", "F", 6);
            pm.createDistributor("Jagat", "G", 7);
            rm.createRequest(0, "8", "Orange", 50d, 3.00);

            for (int i = 0; i < pm.getDistributorList().size(); i++){
                pm.getDistributorList().get(i).addOffer(rm.getRequestFromId("0"));
                pm.getDistributorList().get(i).setExposure(1 + abs(i - 5));
                pm.getDistributorList().get(i).setSpeed(30 - 2 * i);
                pm.getDistributorList().get(i).setCarbon(5 + 10 * i);
            }

            pm.modifyFarmer("8", 0, 0, 0, 0);

            rkm = new RankingManager("0", "1");
            sc = new ServiceController(pm, rm);
        }

//Functionalities

        @Test
        public void rankDistributors(){
            System.out.println(sc.rank("0", 1));
        }

    }
