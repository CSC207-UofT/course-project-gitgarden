import Entities.Distributor;
import Entities.Farmer;
import Entities.Offer;
import Entities.Request;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DistributorTest {
    Farmer farmer1 = new Farmer("temp_name1", "temp_address1");
    Distributor distributor1 = new Distributor("distributor_1", "distributor address1");
    Request request1 = new Request(farmer1, "request_name_1", 100, 10);
    Request request2 = new Request(farmer1, "request_name_2", 200, 20);
    Offer offer1 = new Offer(farmer1, distributor1, "offer_name3", 300, 30);
    Offer offer2 = new Offer(farmer1, distributor1, "offer_name4", 400, 40);

    @Test(timeout = 50)
    public void TestGetCurrent_requests(){
        distributor1.add_request(request1);
        distributor1.add_request(request2);
        ArrayList<Request> temp = new ArrayList<>();
        temp.add(request1);
        temp.add(request2);
        assertEquals(distributor1.getCurrent_requests(), temp);
    }

    @Test
    public void TestProdMap(){
        distributor1.add_offer(offer1);
        distributor1.add_offer(offer2);
        System.out.println(distributor1.prodMap());
    }

}
