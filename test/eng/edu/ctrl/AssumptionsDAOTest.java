/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deeptichavan
 */
public class AssumptionsDAOTest {
    
    public AssumptionsDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAssumption method, of class AssumptionsDAO.
     */
    @org.junit.Test
    public void testGetAssumption() {
        System.out.println("getAssumption");
        AssumptionsDAO instance = null;
        String expResult = "";
        String result = instance.getAssumption();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssumption method, of class AssumptionsDAO.
     */
    @org.junit.Test
    public void testSetAssumption() {
        System.out.println("setAssumption");
        String assumption = "";
        AssumptionsDAO instance = null;
        instance.setAssumption(assumption);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsCorrect method, of class AssumptionsDAO.
     */
    @org.junit.Test
    public void testGetIsCorrect() {
        System.out.println("getIsCorrect");
        AssumptionsDAO instance = null;
        int expResult = 0;
        int result = instance.getIsCorrect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsCorrect method, of class AssumptionsDAO.
     */
    @org.junit.Test
    public void testSetIsCorrect() {
        System.out.println("setIsCorrect");
        int isCorrect = 0;
        AssumptionsDAO instance = null;
        instance.setIsCorrect(isCorrect);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
