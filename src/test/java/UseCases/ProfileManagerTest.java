package UseCases;

import Entities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void testModifyFarmer() {
        pm.createFarmer("temp", "address", 0);
        pm.modifyFarmer("0", 1, 2, 3, 4);
        assertEquals(pm.getFarmerList().get(0).getPrefCarbon(), 1);
    }

    @Test
    public void testGetAllFarmerNames() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        ArrayList<String> farmers = new ArrayList<>();
        farmers.add("temp1");
        farmers.add("temp2");
        assertEquals(pm.getAllFarmerNames(), farmers);
    }

    @Test
    public void testGetAllFarmerNamesEmpty() {
        assertEquals(pm.getAllFarmerNames(), new ArrayList<>());
    }

    @Test
    public void testGetAllIds() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        ArrayList<String> farmers = new ArrayList<>();
        farmers.add("0");
        farmers.add("1");
        assertEquals(pm.getAllFarmerNames(), farmers);
    }

    @Test
    public void testGetAllIdsEmpty() {
        assertEquals(pm.getAllFarmerNames(), new ArrayList<>());
    }

    @Test
    public void testAddressFromId() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        assertEquals(pm.addressFromId("0"), "address1");
    }

    @Test
    public void testAddressFromId_NonExisting() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        assertNull(pm.addressFromId("2"));
    }

    @Test
    public void testNameFromId() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        assertEquals(pm.addressFromId("0"), "address");
    }

    @Test
    public void testNameFromId_NonExisting() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        assertNull(pm.addressFromId("2"));
    }

    @Test
    public void testGetUserFromName() {
        pm.createFarmer("temp1", "address1", 0);
        pm.createFarmer("temp2", "address2", 1);
        assertEquals(pm.getUserFromId("0").getUserName(), "temp1");
    }
}