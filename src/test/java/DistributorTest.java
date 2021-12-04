import Entities.Distributor;
import Entities.Farmer;
import Entities.IRequest;
import Entities.Request;
import org.junit.Test;

public class DistributorTest {
    Farmer farmer1 = new Farmer("temp_name1", "temp_address1", 0);
    Distributor distributor1 = new Distributor("distributor_1", "distributor address1", 0);
    IRequest request1 = new Request(0, farmer1, "request_name_1", 100, 10, null);
    IRequest request2 = new Request(1, farmer1, "request_name_2", 200, 20, null);
    IRequest offer1 = new Request(2, distributor1, "Orange", 300, 3.00, request1);
    IRequest offer2 = new Request(3, distributor1, "NotOrange", 400, 3.50, request2);


    @Test
    public void TestProdMap(){
        distributor1.addOffer(offer1);
        distributor1.addOffer(offer2);
        System.out.println(distributor1.prodMap());
    }

}
