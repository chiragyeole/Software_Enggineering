/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poojithadharmavaram
 */
public class AssumptionsDAOTest {
    
    /**
     * Test of getAssumption method, of class AssumptionsDAO.
     */
    @Test
    public void testGetAssumption() {
        System.out.println("getAssumption");
        AssumptionsDAO instance = new AssumptionsDAO("This is a correct assumption",true);
        String expResult = "This is a correct assumption";
        String result = instance.getAssumption();
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
        String assumption = "This is a modified correct assumption";
        AssumptionsDAO instance = new AssumptionsDAO("This is a correct assumption",true);
        instance.setAssumption(assumption);
        // TODO review the generated test code and remove the default call to fail.
       assertEquals(assumption, instance.getAssumption());
    }

    /**
     * Test of getIsCorrect method, of class AssumptionsDAO.
     */
    @Test
    public void testGetIsCorrect() {
        System.out.println("getIsCorrect");
        AssumptionsDAO instance = new AssumptionsDAO("This is an incorrect assumption",false);
        boolean expResult = false;
        boolean result = instance.getIsCorrect();
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
        boolean isCorrect = false;
        AssumptionsDAO instance = new AssumptionsDAO("This is an incorrect assumption",true);
        instance.setIsCorrect(isCorrect);
        assertEquals(isCorrect, instance.getIsCorrect());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
