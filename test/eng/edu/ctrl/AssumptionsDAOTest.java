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
    @Test
    public void testGetAssumption() {
        System.out.println("getAssumption");
        AssumptionsDAO instance = new AssumptionsDAO("assumption1", 0);
        String expResult = "assumption1";
        String result = instance.getAssumption();
        System.out.println("exp :: " + expResult);
        System.out.println("result :: " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAssumption method, of class AssumptionsDAO.
     */
    @Test
    public void testSetAssumption() {
        System.out.println("setAssumption");
        String assumption = "";
        AssumptionsDAO instance = new AssumptionsDAO("assumption1", 0);
        instance.setAssumption(assumption);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIsCorrect method, of class AssumptionsDAO.
     */
    @Test
    public void testGetIsCorrect() {
        System.out.println("getIsCorrect");
        AssumptionsDAO instance = new AssumptionsDAO("assumption1", 0);
        int expResult = 0;
        int result = instance.getIsCorrect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsCorrect method, of class AssumptionsDAO.
     */
    @Test
    public void testSetIsCorrect() {
        System.out.println("setIsCorrect");
        int isCorrect = 0;
        AssumptionsDAO instance = new AssumptionsDAO("assumption1", 0);
        instance.setIsCorrect(isCorrect);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}