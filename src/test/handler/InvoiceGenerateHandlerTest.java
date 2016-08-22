/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.handler;


import handler.InvoiceGenerateHandler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Mantu
 */
public class InvoiceGenerateHandlerTest {
    InvoiceGenerateHandler instance=null;
    public InvoiceGenerateHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance=InvoiceGenerateHandler.getInstance();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of getInstance method, of class InvoiceGenerateHandler.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        InvoiceGenerateHandler expResult = instance;
        InvoiceGenerateHandler result = InvoiceGenerateHandler.getInstance();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of generateInvoice method, of class InvoiceGenerateHandler.
     */
    @Test
    public void testGenerateInvoice() {
        System.out.println("GenerateInvoice");
        InvoiceGenerateHandler instance = this.instance;
        boolean expResult = true;
        boolean result = instance.generateInvoice();
        assertEquals(expResult, result);
        
    }

   
    
}
