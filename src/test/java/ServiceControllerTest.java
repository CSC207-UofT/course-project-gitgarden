import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceControllerTest {

    @Test(timeout = 50)
    public void TestisNumeric() {
        String temp_str = "test_str2021";
        assertFalse(ServiceController.isNumeric(temp_str));
    }

    @Test(timeout = 50)
    public void TestisAlphanumeric() {
        String temp_str = "test_str202";
        assertTrue(ServiceController.isNumeric(temp_str));
    }

}
