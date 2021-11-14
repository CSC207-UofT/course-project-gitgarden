import Entities.Distributor;
import Entities.Farmer;
import Entities.Request;
import Entities.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User temp = new User("wrongName", "wrongAddress");

    User farmer1 = new Farmer("tempName2", "tempAddress1");
    User farmer2 = new Farmer("tempName2", "tempAddress2");
    User distributor1 = new Distributor("distributorName1", "distributorAddress1");
    User distributor2 = new Distributor("distributorName2", "distributorAddress2");
    Request request1 = new Request(farmer1, "request_name_1", 100, 10);
    Request request2 = new Request(farmer2, "request_name_2", 200, 20);
    Request offer1 = new Request(distributor1, "offer_name3", 300, 3.00);
    Request offer2 = new Request(distributor2, "offer_name4", 400, 4.00);

    @Test(timeout = 50)
    public void TestAddRequest(){
        farmer1.addRequest(request1);
        assertEquals(request1, farmer1.getCurrentRequests().get(0));
    }

    @Test(timeout = 50)
    public void TestRemoveRequest(){
        farmer1.addRequest(request1);
        farmer1.addRequest(request2);
        farmer1.removeRequest(request1);
        assertEquals(request2, farmer1.getCurrentRequests().get(0));
    }

    @Test(timeout = 50)
    public void TestGetCurrentRequests(){
        farmer1.addRequest(request1);
        ArrayList<Request> temp = new ArrayList<>();
        temp.add(request1);
        assertEquals(temp, farmer1.getCurrentRequests());
    }

    @Test(timeout = 50)
    public void TestAddOffer(){
        farmer1.addOffer(offer1);
        assertEquals(offer1, farmer1.getOfferHistory().get(0));
    }

    @Test(timeout = 50)
    public void TestRemoveOffer(){
        farmer1.addOffer(offer1);
        farmer1.addOffer(offer2);
        farmer1.removeOffer(offer1);
        assertEquals(offer2, farmer1.getOfferHistory().get(0));
    }

    @Test(timeout = 50)
    public void TestGetOfferHistory(){
        farmer1.addOffer(offer1);
        ArrayList<Request> temp = new ArrayList<>();
        temp.add(offer1);
        assertEquals(temp, farmer1.getOfferHistory());
    }

    @Test(timeout = 50)
    public void TestGetUserName() {
        temp.setUserName("tempName");
        assertEquals("tempName", temp.getUserName());
    }

    @Test(timeout = 50)
    public void TestGetUserAddress() {
        temp.setUserAddress("tempAddress");
        assertEquals("tempAddress", temp.getUserAddress());
    }

    @Test(timeout = 50)
    public void TestGetUserId() {
        assertTrue(10000000 <= farmer1.getUserId() && farmer2.getUserId() <= 99999999);
    }

    @Test(timeout = 50)
    public void TestToString() {
        assertEquals("Name: wrongName\n" +
                "Address: wrongAddress\n" +
                "Summary: Default Summary\n", temp.toString());
    }
}
