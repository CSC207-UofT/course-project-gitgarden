import Entities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User temp = new User("wrong_name", "wrong_address");

    @Test(timeout = 50)
    public void TestGetUser_name() {
        temp.setUser_name("temp_name");
        assertEquals("temp_name", temp.getUser_name());
    }

    @Test(timeout = 50)
    public void TestGetUser_address() {
        temp.setUser_address("temp_address");
        assertEquals("temp_address", temp.getUser_address());
    }

    @Test(timeout = 50)
    public void TestGetUser_id() {
        assertTrue( 100000 <= temp.getUser_id() && temp.getUser_id() <= 999999);
    }

    @Test(timeout = 50)
    public void TestGetUser_summary() {
        temp.setSummary("New_Summary");
        assertEquals("New_Summary", temp.getSummary());
    }

    @Test(timeout = 50)
    public void TestToString() {
        assertEquals("Name: wrong_name\n" +
                "Address: wrong_address\n" +
                "Summary: Default Summary\n", temp.toString());
    }
}
