import Entities.Offer;
import Entities.Request;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestTest {


    @Test
    public void TestShow(){
        Request lst1 = new Request(1, "name1",
                "address1", "p1", 10, 10),
                lst2 = new Request(2, "name2",
                        "address2", "p2", 20, 20);
        Offer offer3 = new Offer(3, "name3",
                "address3", "p3", 30, 30),
                offer4 = new Offer(4, "name4",
                        "address4", "p4", 40, 40);

        lst2.add(offer3);
        lst2.add(offer4);
        lst1.add(lst2);
        lst1.show();
    }


}
