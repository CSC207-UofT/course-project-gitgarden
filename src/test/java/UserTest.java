import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test(timeout = 50)
    public void TestGetUser_name() {
        User temp = new User("temp_name", "temp_address");
        assertEquals("temp_name", temp.getUser_name());
    }

    @Test(timeout = 50)
    public void TestGetUser_address() {
        User temp = new User("temp_name", "temp_address");
        assertEquals("temp_address", temp.getUser_address());
    }

    @Test(timeout = 50)
    public void TestGetUser_id() {
        User temp = new User("temp_name", "temp_address");
        assertEquals(1000, temp.getUser_id());
    }

    @Test(timeout = 50)
    public void TestGetUser_summary() {

        User temp = new User("temp_name", "temp_address");
        assertEquals("Default Summary", temp.getSummary());
    }

    @Test(timeout = 50)
    public void TestToString() {
        User u = new User("", "");
        u.setUser_name("test_name");
        u.setUser_address("test_address");
        assertEquals("Name: test_name\n" +
                "ID: 1000\n" +
                "Address: test_address\n" +
                "Summary: Default Summary", u.toString());
    }
}
