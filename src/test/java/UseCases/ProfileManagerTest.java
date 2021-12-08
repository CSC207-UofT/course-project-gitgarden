package UseCases;

import Entities.*;
import Controller.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProfileManagerTest {
    ProfileManager pm;

    @Before
    public void setUp() {
        pm = new ProfileManager();
    }

}
