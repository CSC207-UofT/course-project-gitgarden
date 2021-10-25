import Controller.ServiceController;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceControllerTest {

    @Test(timeout = 50)
    public void TestisNumeric() {
        String temp_str = "str2021";
        assertFalse(ServiceController.isNumeric(temp_str));
    }

    @Test(timeout = 50)
    public void TestisAlphanumeric() {
        String temp_str = "str2021";
        assertTrue(ServiceController.isAlphanumeric(temp_str));
    }

}
