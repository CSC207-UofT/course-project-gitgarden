import Entities.*;
import Entities.Request;
import UseCases.RankingManager;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class RankingStructureTest {
    User farmer1 = new Farmer("tempName2", "tempAddress1", 0);
    User farmer2 = new Farmer("tempName2", "tempAddress2", 1);
    Distributor distributor1 = new Distributor("distributorName1", "distributorAddress1", 0);
    Distributor distributor2 = new Distributor("distributorName2", "distributorAddress2", 0);
    IRequest request1 = new Request(farmer1, "request_name_1", 100, 10, null);
    IRequest request2 = new Request(farmer2, "request_name_2", 200, 20, null);


    @Test
    public void jTest(){
    }

}

