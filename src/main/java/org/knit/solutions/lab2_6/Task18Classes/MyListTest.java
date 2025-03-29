package org.knit.solutions.lab2_6.Task18Classes;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyListTest {
    private MyList myList;

    @Before
    public void setUp() {
        myList = new MyList();
    }

    @Test
    public void testSize() {
        assertTrue(myList.getList().size() < Math.pow(10, 4));
        assertFalse(myList.getList().isEmpty());
    }


}
