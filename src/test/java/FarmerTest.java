import Entities.*;
import Entities.Request;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class FarmerTest {
    User farmer1 = new Farmer("tempName2", "tempAddress1");
    User farmer2 = new Farmer("tempName2", "tempAddress2");
    Distributor distributor1 = new Distributor("distributorName1", "distributorAddress1");
    Distributor distributor2 = new Distributor("distributorName2", "distributorAddress2");
    Request request1 = new Request(farmer1, "request_name_1", 100, 10);
    Request request2 = new Request(farmer2, "request_name_2", 200, 20);
    Request offer1 = new Request(distributor1, "offer_name3", 300, 3.00);
    Request offer2 = new Request(distributor1, "offer_name4", 400, 4.00);

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
    public void TestGetOffer_history(){
        farmer1.addOffer(offer1);
        ArrayList<Request> temp = new ArrayList<>();
        temp.add(offer1);
        assertEquals(temp, farmer1.getOfferHistory());
    }

}
