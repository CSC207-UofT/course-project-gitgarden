import Entities.*;
import Entities.Request;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class FarmerTest {
    User farmer1 = new Farmer("tempName2", "tempAddress1", 0);
    User farmer2 = new Farmer("tempName2", "tempAddress2", 0);
    Distributor distributor1 = new Distributor("distributorName1", "distributorAddress1", 0);
    Distributor distributor2 = new Distributor("distributorName2", "distributorAddress2", 0);
    IRequest request1 = new Request(0, farmer1, "request_name_1", 100, 10, null);
    IRequest request2 = new Request(1, farmer2, "request_name_2", 200, 20, null);
    IRequest offer1 = new Request(2, distributor1, "offer_name3", 300, 3.00, request1);
    IRequest offer2 = new Request(3, distributor2, "offer_name4", 400, 4.00, request2);

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
    public void TestRemoveOffer(){
        farmer1.addOffer(offer1);
        farmer1.addOffer(offer2);
        farmer1.removeOffer(offer1);
        assertEquals(offer2, farmer1.getOfferHistory().get(0));
    }

    @Test(timeout = 50)
    public void TestGetOffer_history(){
        farmer1.addOffer(offer1);
        ArrayList<IRequest> temp = new ArrayList<>();
        temp.add(offer1);
        assertEquals(temp, farmer1.getOfferHistory());
    }

}
