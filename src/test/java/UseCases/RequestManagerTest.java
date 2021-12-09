package UseCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestManagerTest {
    ProfileManager pm;
    RequestManager rm;

    @Before
    public void setUp() {
        pm = new ProfileManager();
        pm.createFarmer("farmer", "address", 147);
        pm.createDistributor("Distributor", "address", 247);
        rm = new RequestManager();
    }

    @Test
    public void testAcceptRequest() {
        rm.createRequest(100, "147", "prod1", 1000d, 100.00, false);
        rm.acceptRequest("100", "247");
        Assert.assertTrue(pm.getUserFromId("147").getOfferHistory().contains(rm.getRequestFromId("100")));
    }

    @Test
    public void testDataFromId() {
        rm.createRequest(101, "147", "prod2", 1000.0, 100.00, false);
        String[] data = rm.dataFromId("101");
        Assert.assertEquals("prod2", data[0]);
        Assert.assertEquals("1000.0", data[1]);
        Assert.assertEquals("100.0", data[2]);
    }

}