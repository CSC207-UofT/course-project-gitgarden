import Controller.ServiceController;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceControllerTest {

    @Test(timeout = 50)
    public void TestisAlphanumeric() {
        ServiceController sc = new ServiceController();
        String temp_str = "str2021";
        assertTrue(sc.isAlphanumeric(temp_str));
    }

}
