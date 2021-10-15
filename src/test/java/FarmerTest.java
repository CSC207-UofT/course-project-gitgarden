import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FarmerTest {

    @Test(timeout = 50)
    public void TestgetUser_name() {
        User temp = new User("temp_name", "temp_address");
        assertEquals("temp_name", temp.getUser_name());
    }

    @Test(timeout = 50)
    public void TestgetUser_address() {
        User temp = new User("temp_name", "temp_address");
        assertEquals("temp_address", temp.getUser_address());
    }

}
