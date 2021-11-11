import Entities.Distributor;
import Entities.Farmer;
import Entities.Offer;
import Entities.Request;
import org.junit.Test;
import java.util.Objects;
import static org.junit.Assert.*;

public class OfferTest {
    Farmer farmer1 = new Farmer("temp_name1", "temp_address1");
    Farmer farmer2 = new Farmer("temp_name2", "temp_address2");
    Distributor distributor1 = new Distributor("distributor1", "distributor address1");
    Distributor distributor2 = new Distributor("distributor1", "distributor address1");
    Request request1 = new Request(farmer1, "request_name_1", 100, 10);
    Request request2 = new Request(farmer1, "request_name_2", 200, 20);
    Offer offer1 = new Offer(farmer1, distributor1, "offer_name3", 300, 30);
    Offer offer2 = new Offer(farmer1, distributor1, "offer_name4", 400, 40);

    @Test(timeout = 50)
    public void TestGetRequest_id(){
        assertTrue( 100000 <= offer1.getRequest_id() && offer1.getRequest_id() <= 999999);
    }

    @Test(timeout = 50)
    public void TestGetFarmer(){
        offer1.setFarmer(farmer2);
        assertTrue(offer1.getFarmer() == farmer2
                && Objects.equals(offer1.getFarmerName(), "temp_name2")
                && Objects.equals(offer1.getFarmerAddress(), "temp_address2"));
    }

}