import Entities.Distributor;
import Entities.Farmer;
import Entities.Request;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DistributorTest {
    Farmer farmer1 = new Farmer("temp_name1", "temp_address1");
    Distributor distributor1 = new Distributor("distributor_1", "distributor address1");
    Request request1 = new Request(farmer1, "request_name_1", 100, 10);
    Request request2 = new Request(farmer1, "request_name_2", 200, 20);
    Request offer1 = new Request(distributor1, "offer_name3", 300, 30);
    Request offer2 = new Request(distributor1, "offer_name4", 400, 40);


    @Test
    public void TestProdMap(){
        distributor1.addOffer(offer1);
        distributor1.addOffer(offer2);
        System.out.println(distributor1.prodMap());
    }

}
