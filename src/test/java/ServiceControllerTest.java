import Controller.ServiceController;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceControllerTest {

    @Test(timeout = 50)
    public void TestIsAlphabetic() {
        ServiceController sc = new ServiceController();
        String tempStr = "str2021";
        assertFalse(sc.isAlphabetic(tempStr));
    }

    @Test(timeout = 50)
    public void TestIsValidName() {
        ServiceController sc = new ServiceController();
        String tempStr = "93b50a78e19";
        assertTrue(sc.isValidName(tempStr));
    }

}
