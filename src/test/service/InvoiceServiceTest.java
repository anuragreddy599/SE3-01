/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.service;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import pojo.ClientTO;
import pojo.InvoiceTO;
import service.InvoiceService;

/**
 *
 * @author Mantu
 */
public class InvoiceServiceTest {
    InvoiceService instance=null;
    public InvoiceServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance=InvoiceService.getInstance();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of getInstance method, of class InvoiceService.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        InvoiceService expResult = instance;
        InvoiceService result = InvoiceService.getInstance();
        assertEquals(expResult, result);
       
    }


    /**
     * Test of findInvoiceForBudget method, of class InvoiceService.
     */
    @Test
    public void testFindInvoiceForBudget() {
        System.out.println("FindInvoiceForBudget");
        Long client = new Long("10004");
        Long projectNumber = new Long("1004");
       
        List<InvoiceTO> result = instance.findInvoiceForBudget(client, projectNumber);
        assertNotEquals(0, result.size());
        
    }
    
}
