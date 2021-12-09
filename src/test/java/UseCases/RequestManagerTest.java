package UseCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

public class RequestManagerTest {
    ProfileManager pm;
    RequestManager rm;

    @Before
    public void setUp() {
        pm = new ProfileManager();
        pm.createFarmer("farmer", "address", 1);
        pm.createDistributor("Distributor", "address", 2);
        rm = new RequestManager();
    }

    @Test
    public void testAcceptRequest() {
        rm.createRequest(100, "1", "prod1", 1000d, 100.00);
        rm.acceptRequest("100", "2");
        Assert.assertTrue(pm.getUserFromId("2").getCurrentRequests() == null &&
                Objects.equals(pm.getUserFromId("2").getOfferHistory().get(0).getProdName(), "prod1"));
    }

    @Test
    public void testDeclineRequest() {
        rm.createRequest(100, "1", "prod1", 1000d, 100.00);
        rm.declineRequest("100");
        Assert.assertTrue(pm.getUserFromId("1").getCurrentRequests() == null &&
                pm.getUserFromId("1").getOfferHistory().get(0).getProdName() == null &&
                pm.getUserFromId("2").getCurrentRequests() == null &&
                pm.getUserFromId("2").getOfferHistory().get(0).getProdName() == null);
    }

    @Test
    public void testDataFromId() {
        rm.createRequest(100, "1", "prod1", 1000d, 100.00);
        String[] data = rm.dataFromId("100");
        Assert.assertTrue(Objects.equals(data[0], "prod1")
                && Objects.equals(data[1], "1000d")
                && Objects.equals(data[2], "100.00")
                && Objects.equals(data[3], ""));
    }

}