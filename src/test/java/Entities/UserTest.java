package Entities;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User temp = new User("wrongName", "wrongAddress", 10000000);

    User farmer1 = new Farmer("tempName2", "tempAddress1", 511673577);
    User farmer2 = new Farmer("tempName2", "tempAddress2", 100000001);
    User distributor1 = new Distributor("distributorName1", "distributorAddress1", 999999999);
    IRequest request1 = new Request(0, farmer1, "request_name_1", 100, 10, null);
    IRequest request2 = new Request(1, farmer2, "request_name_2", 200, 20, null);
    IRequest offer1 = new Request(2, distributor1, "offer_name3", 300, 3.00, request1);

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
        ArrayList<IRequest> temp = new ArrayList<>();
        temp.add(request1);
        assertEquals(temp, farmer1.getCurrentRequests());
    }

    @Test(timeout = 50)
    public void TestAddOffer(){
        farmer1.addOffer(offer1);
        assertEquals(offer1, farmer1.getOfferHistory().get(0));
    }

    @Test(timeout = 50)
    public void TestGetOfferHistory(){
        farmer1.addOffer(offer1);
        ArrayList<IRequest> temp = new ArrayList<>();
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
        assertTrue(100000000 <= farmer1.getUserId() && farmer2.getUserId() <= 999999999);
    }

    @Test(timeout = 50)
    public void TestToString() {
        assertEquals("Name: wrongName\n" +
                "Address: wrongAddress", temp.toString());
    }
}
