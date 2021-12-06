package UseCases;

import Entities.*;
import Controller.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProfileManagerTest {
    ProfileManager pm;
    ServiceController sc;

    @Before
    public void setUp() {
        pm = new ProfileManager();
        sc = new ServiceController();
    }

    @Test
    public void TestCreateLegalUser(){
        pm = new ProfileManager();
        pm.createFarmer("temp", "address", 0);
        assertEquals(pm.getFarmerList().get(0).getUserName(), "temp");
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

}
