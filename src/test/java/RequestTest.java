import org.junit.Test;

import static org.junit.Assert.*;

public class RequestTest {

    @Test(timeout = 50)
    public void TestgetFarmerName(){
        Request r = new Request("test_name", "test_address", "test_product", 210, 102.25F);
        assertEquals("test_name", r.getFarmerName());
    }

    @Test(timeout = 50)
    public void TestgetFarmerAddress(){
        Request r = new Request("test_name", "test_address", "test_product", 210, 102.25F);
        assertEquals("test_address", r.getFarmerAddress());
    }

    @Test(timeout = 50)
    public void TestgetProductName(){
        Request r = new Request("test_name", "test_address", "test_product", 210, 102.25F);
        assertEquals("test_product", r.getProductName());
    }

    @Test(timeout = 50)
    public void TestgetProductQuantity(){
        Request r = new Request("test_name", "test_address", "test_product", 210, 102.25F);
        assertEquals(210, r.getProductQuantity());
    }

    @Test(timeout = 50)
    public void TestgetProductPrice(){
        Request r = new Request("test_name", "test_address", "test_product", 210, 102.25F);
        assertEquals(102.25F, r.getProductPrice(), 0.0001);
    }

    @Test(timeout = 50)
    public void TesttoString(){
        Request r = new Request("", "", "", 0, 0F);
        r.setFarmerName("test_name");
        r.setFarmerAddress("test_address");
        r.setProductName("test_product");
        r.setProductQuantity(210);
        r.setProductPrice(102.25F);
        assertEquals("Name: test_name\n" +
                "Address: test_address\n" +
                "Product: test_product\n" +
                "Quantity: 210\n" +
                "Price: 102.25", r.toString());
    }

}
