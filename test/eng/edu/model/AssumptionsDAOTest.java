/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.model;

<<<<<<< HEAD
=======
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poojithadharmavaram
 */
public class AssumptionsDAOTest {
    
<<<<<<< HEAD
=======
    public AssumptionsDAOTest() {
    }
    
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
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
<<<<<<< HEAD
        String assumption = "This is a modified correct assumption";
        AssumptionsDAO instance = new AssumptionsDAO("This is a correct assumption",true);
        instance.setAssumption(assumption);
        // TODO review the generated test code and remove the default call to fail.
       assertEquals(assumption, instance.getAssumption());
=======
        String assumption = "This is a correct assumption";
        AssumptionsDAO instance = new AssumptionsDAO("blah",true);
        instance.setAssumption(assumption);
        
        String expResult = "This is a correct assumption";
        String result = instance.getAssumption();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
    }

    /**
     * Test of getIsCorrect method, of class AssumptionsDAO.
     */
    @Test
    public void testGetIsCorrect() {
        System.out.println("getIsCorrect");
<<<<<<< HEAD
        AssumptionsDAO instance = new AssumptionsDAO("This is an incorrect assumption",false);
        boolean expResult = false;
=======
        AssumptionsDAO instance = new AssumptionsDAO("This is a correct assumption",true);
        boolean expResult = true;
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
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
<<<<<<< HEAD
        boolean isCorrect = false;
        AssumptionsDAO instance = new AssumptionsDAO("This is an incorrect assumption",true);
        instance.setIsCorrect(isCorrect);
        assertEquals(isCorrect, instance.getIsCorrect());
=======
        boolean isCorrect = true;
        AssumptionsDAO instance = new AssumptionsDAO("This is a correct assumption",true);
        instance.setIsCorrect(isCorrect);
        
        boolean expResult = true;
        boolean result = instance.getIsCorrect();
        assertEquals(expResult, result);
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
