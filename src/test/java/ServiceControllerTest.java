import Controller.ServiceController;
import UseCases.ProfileInterface;
import UseCases.ProfileManager;
import UseCases.RequestManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceControllerTest {
    ProfileInterface pm = new ProfileManager();
    RequestManager rm = new RequestManager();

    @Test(timeout = 50)
    public void TestIsAlphabetic() {
        ServiceController sc = new ServiceController(pm, rm);
        String tempStr = "str2021";
        assertFalse(sc.isAlphabetic(tempStr));
    }

    @Test(timeout = 50)
    public void TestIsValidName() {
        ServiceController sc = new ServiceController(pm, rm);
        String tempStr = "93b50a78e19";
        assertTrue(sc.isValidName(tempStr));
    }

    @Test(timeout = 50)
    public void TestIsValidAddress() {
        ServiceController sc = new ServiceController(pm, rm);
        String tempStr = "93 Nowhere Ave.";
        assertTrue(sc.isValidAddress(tempStr));
    }

}
