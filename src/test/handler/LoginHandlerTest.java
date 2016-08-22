/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.handler;

import handler.LoginHandler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import pojo.UserTO;

/**
 *
 * @author Mantu
 */
public class LoginHandlerTest {
    LoginHandler instance=null; 
    public LoginHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance=LoginHandler.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class LoginHandler.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        LoginHandler expResult = instance;
        LoginHandler result = LoginHandler.getInstance();
        assertEquals(expResult, result);
        
    }

   

    /**
     * Test of login method, of class LoginHandler.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        UserTO userObj = new UserTO();
        userObj.setUserId("Admin");
        userObj.setPassword("ab");
        
        
        UserTO expResult = instance.login(userObj);
        assertEquals(userObj.getPassword(), expResult.getPassword());
        
    }
    
}
