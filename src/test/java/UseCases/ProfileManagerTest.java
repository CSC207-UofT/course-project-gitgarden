package UseCases;

import Entities.Farmer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProfileManagerTest {
    ProfileManager pm;

    @Before
    public void setUp() {
        pm = new ProfileManager();
    }

    @Test
    public void testCreateFarmer() {
        pm.createFarmer("temp", "address", 0);
        ArrayList<Farmer> farmers = new ArrayList<>();
        farmers.add(new Farmer("temp", "address", 0));
        assertEquals(pm.getFarmerList().get(0).getUserName(), farmers.get(0).getUserName());
    }

    @Test
    public void testModifyUser() {
        pm.createFarmer("temp", "address", 0);
        pm.modifyUser("0", "farmer", "address");
        assertEquals(pm.getFarmerList().get(0).getUserName(), "farmer");
    }

    @Test
    public void testNameFromId() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        assertEquals(pm.addressFromId("0"), "address");
    }
}