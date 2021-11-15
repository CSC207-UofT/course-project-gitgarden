import Entities.Distributor;
import Entities.Farmer;
import Entities.Request;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestTest {
    Farmer farmer1 = new Farmer("tempName1", "tempAddress1");
    Farmer farmer2 = new Farmer("tempName2", "tempAddress2");
    Distributor distributor1 = new Distributor("distributor1", "distributorAddress1");
    Distributor distributor2 = new Distributor("distributor2", "distributorAddress2");
    Request request1 = new Request(farmer1, "requestName1", 100, 10);
    Request request2 = new Request(farmer2, "requestName2", 200, 20);
    Request counteroffer1 = new Request(distributor1, "offerName3", 300, 30);
    Request counteroffer2 = new Request(distributor2, "offerName4", 400, 40);


    @Test(timeout = 50)
    public void TestGetRequest_id(){
        assertTrue( 10000000 <= request1.getRequestId() && request1.getRequestId() <= 99999999);
    }

    @Test(timeout = 50)
    public void TestGetUser(){
        assertSame(request1.getUser(), farmer1);
    }

    @Test(timeout = 50)
    public void TestCounterOffer() {
        request1.add(request2);
        request1.add(counteroffer1);
        request1.add(counteroffer2);
        request1.remove(request2);
        assertTrue(request1.getCounteroffers().contains(counteroffer1)
                && request1.getCounteroffers().contains(counteroffer2));
    }


}
