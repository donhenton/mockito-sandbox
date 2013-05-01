/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mockito.sandbox;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dhenton
 */
public class UserTest {

    public static final String NAME = "FRED";
    public static final String PASSWORD = "PASSWORD";
    User user1 = null;
    User user2 = null;

    @Before
    public void assembleService() {

        user1 = new User();
        user1.setName(NAME);
        user1.setPassword(PASSWORD);
        user1.setOkay(true);
        user2 = new User();
        user2.setName(NAME);
        user2.setPassword(PASSWORD);
        user2.setOkay(true);
    }

    @Test
    public void testUserSetters() {
        assertEquals(NAME, user1.getName());
        assertEquals(PASSWORD, user1.getPassword());
        assertTrue(user1.isOkay());

    }
    
    @Test
    public void testEqualsForUser()
    {
        assertEquals(user1,user2);
        assertFalse(user1.equals(null));
        assertFalse(user1.equals(new String("fred")));
        
        user2.setName(NAME+"xx");
        assertNotEquals(user1,user2);
        
    }
    
    @Test
    public void testHashEquals()
    {
        assertTrue(user1.hashCode() > 0);
        assertTrue(user1.toString().indexOf(NAME)> 0);
    }
}
