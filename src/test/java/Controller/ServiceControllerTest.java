package Controller;

import Controller.ServiceController;
import UseCases.ProfileManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceControllerTest {
    ProfileManager pm;
    ServiceController sc;

    @Before
    public void setUp() {
        pm = new ProfileManager();
        sc = new ServiceController();
    }

    //Interface User

    @Test
    public void TestCreateLegalUser() throws Exception {
        sc.createProfileCheck("name", "address", true);
        assertEquals(pm.getFarmerList().get(0).getUserId(), 0);
    }

    @Test
    public void TestModifyLegalUser() throws Exception {
        pm.createFarmer("temp", "address", 0);
        sc.modifyUserCheck("0", "modifyName", "modifyAddress");
        assertEquals(pm.getFarmerList().get(0).getUserName(), "modifyName");
    }

    @Test(expected = Exception.class)
    public void TestCreateIllegalNameException() throws Exception {
        sc.createProfileCheck("测试",
                "address", true);
    }

    @Test(expected = Exception.class)
    public void TestModifyIllegalNameException() throws Exception {
        pm.createFarmer("temp", "address", 0);
        sc.modifyUserCheck("0", "modifyName", "测试");
    }

    @Test(expected = Exception.class)
    public void TestEmptyNameException() throws Exception {
        sc.createProfileCheck("",
                "address", true);
    }

    @Test(expected = Exception.class)
    public void TestModifyEmptyNameException() throws Exception {
        pm.createFarmer("temp", "address", 0);
        sc.modifyUserCheck("0", "", "address");
    }

    @Test(expected = Exception.class)
    public void TestExistingNameException() throws Exception {
        pm.createFarmer("temp", "address", 0);
        sc.createProfileCheck("temp",
                "address", true);
    }

    @Test(expected = Exception.class)
    public void TestCreateIllegalAddressException() throws Exception {
        sc.createProfileCheck("temp",
                "测试", true);
    }

    @Test(expected = Exception.class)
    public void TestModifyIllegalAddressException() throws Exception {
        pm.createFarmer("temp", "address", 0);
        sc.modifyUserCheck("0", "modifyName", "测试");
    }

    @Test(expected = Exception.class)
    public void TestEmptyAddressException() throws Exception {
        sc.createProfileCheck("temp",
                "", true);
    }

    @Test(expected = Exception.class)
    public void TestModifyEmptyAddressException() throws Exception {
        pm.createFarmer("temp", "address", 0);
        sc.modifyUserCheck("0", "modifyName", "");
    }

    //Interface Request






    //Others

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

    @Test(timeout = 50)
    public void TestIsAlphanumeric() {
        ServiceController sc = new ServiceController();
        String tempStr = "";
        assertFalse(sc.isAlphanumeric(tempStr));
    }

}
