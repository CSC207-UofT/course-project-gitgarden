import Entities.*;
import Entities.Request;
import Entities.Offer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FarmerTest {
    Farmer farmer1 = new Farmer("temp_name1", "temp_address1");
    Distributor distributor1 = new Distributor("distributor_name_1", "distributor address1");
    Request request1 = new Request(farmer1, "request_name_1", 100, 10);
    Request request2 = new Request(farmer1, "request_name_2", 200, 20);
    Offer offer1 = new Offer(farmer1, distributor1, "offer_name3", 300, 30);
    Offer offer2 = new Offer(farmer1, distributor1, "offer_name4", 400, 40);

    @Test(timeout = 50)
    public void TestAdd_request(){
        farmer1.add_request(request1);
        assertEquals(request1, farmer1.getCurrent_requests().get(0));
    }

    @Test(timeout = 50)
    public void TestRemove_request(){
        farmer1.add_request(request1);
        farmer1.add_request(request2);
        farmer1.remove_request(request1);
        assertEquals(request2, farmer1.getCurrent_requests().get(0));
    }

    @Test(timeout = 50)
    public void TestgetCurrent_requests(){
        farmer1.add_request(request1);
        ArrayList<Request> temp = new ArrayList<>();
        temp.add(request1);
        assertEquals(temp, farmer1.getCurrent_requests());
    }

    @Test(timeout = 50)
    public void TestAdd_Offer(){
        farmer1.add_offer(offer1);
        assertEquals(offer1, farmer1.getOffer_history().get(0));
    }

    @Test(timeout = 50)
    public void TestRemove_Offer(){
        farmer1.add_offer(offer1);
        farmer1.add_offer(offer2);
        farmer1.remove_offer(offer1);
        assertEquals(offer2, farmer1.getOffer_history().get(0));
    }

    @Test(timeout = 50)
    public void TestgetOffer_history(){
        farmer1.add_offer(offer1);
        ArrayList<Offer> temp = new ArrayList<>();
        temp.add(offer1);
        assertEquals(temp, farmer1.getOffer_history());
    }

}
