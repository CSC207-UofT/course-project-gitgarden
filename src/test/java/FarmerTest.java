import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FarmerTest {

    @Test(timeout = 50)
    public void TestgetUser_name() {
        Farmer temp = new Farmer("temp_name", "temp_address");
        assertEquals("temp_name", temp.getUser_name());
    }

    @Test(timeout = 50)
    public void TestgetUser_address() {
        Farmer temp = new Farmer("temp_name", "temp_address");
        assertEquals("temp_address", temp.getUser_address());
    }

    @Test(timeout = 50)
    public void TestgetRequests() {
        Farmer temp = new Farmer("temp_name", "temp_address");
        assertNull(temp.getRequests());

    }

}
