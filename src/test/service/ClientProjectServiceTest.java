/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.service;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import service.ClientProjectService;
import static org.junit.Assert.*;


/**
 *
 * @author Mantu
 */
public class ClientProjectServiceTest {
    ClientProjectService instance=null;
    public ClientProjectServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance=ClientProjectService.getInstance();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of getInstance method, of class ClientProjectService.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ClientProjectService expResult = instance;
        ClientProjectService result = ClientProjectService.getInstance();
        assertEquals(expResult, result);
        
    }

  
    /**
     * Test of findProjectName method, of class ClientProjectService.
     */
    @Test
    public void testFindProjectName() {
        System.out.println("FindProjectName");
        Long projectNo = new Long("1001");
        
        String expResult = "E-Commerce";
        String result = instance.findProjectName(projectNo);
        assertEquals(expResult, result);
        
    }
    
}
