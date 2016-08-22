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
import pojo.BudgetReportTO;
import service.ReportService;

/**
 *
 * @author Mantu
 */
public class ReportServiceTest {
    ReportService instance=null;
    public ReportServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance=ReportService.getInstance();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of getInstance method, of class ReportService.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ReportService expResult = instance;
        ReportService result = ReportService.getInstance();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBudgetReport method, of class ReportService.
     */
    @Test
    public void testGetBudgetReport() {
        System.out.println("GetBudgetReport");
        
        List<BudgetReportTO> result = instance.getBudgetReport();
       
        assertNotEquals(0, result.size());
    }
    
}
