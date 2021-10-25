import Entities.Farmer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FarmerTest {

    @Test(timeout = 50)
    public void TestGetUserName() {
        Farmer temp = new Farmer("temp_name", "temp_address");
        assertEquals("temp_name", temp.getUser_name());
    }

    @Test(timeout = 50)
    public void TestGetUser_address() {
        Farmer temp = new Farmer("temp_name", "temp_address");
        assertEquals("temp_address", temp.getUser_address());
    }

    @Test(timeout = 50)
    public void TestGetRequests() {
        Farmer temp = new Farmer("temp_name", "temp_address");
        assertNull(temp.getRequests());

    }

}
