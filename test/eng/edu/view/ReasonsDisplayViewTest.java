/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;

import eng.edu.model.AssumptionsModel;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.ScrollPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poojithadharmavaram
 */
public class ReasonsDisplayViewTest {
    
    public ReasonsDisplayViewTest() {
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
     * Test of displayReasons method, of class ReasonsDisplayView.
     */
    @Test
    public void testDisplayReasons() {
        System.out.println("displayReasons");
        HashMap<String, ArrayList> incorrectAssumptionReasonsMap = null;
        ArrayList<String> incorrectlyAnsweredAssumptionsList = null;
        ScrollPane scrollPane = null;
        ReasonsDisplayView.displayReasons(incorrectAssumptionReasonsMap, incorrectlyAnsweredAssumptionsList, scrollPane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReasonsForCurrentAssumption method, of class ReasonsDisplayView.
     */
    @Test
    public void testGetReasonsForCurrentAssumption() {
        System.out.println("getReasonsForCurrentAssumption");
        HashMap<String, ArrayList> incorrectAssumptionReasonsMap = null;
        ArrayList<String> incorrectlyAnsweredAssumptionsList = null;
        int count = 0;
        ArrayList<String> expResult = null;
        ArrayList<String> result = ReasonsDisplayView.getReasonsForCurrentAssumption(incorrectAssumptionReasonsMap, incorrectlyAnsweredAssumptionsList, count);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfReasonsToBeDisplayedForCurrentAssumption method, of class ReasonsDisplayView.
     */
    @Test
    public void testCheckIfReasonsToBeDisplayedForCurrentAssumption() {
        System.out.println("checkIfReasonsToBeDisplayedForCurrentAssumption");
        HashMap<String, ArrayList> incorrectAssumptionReasonsMap = null;
        AssumptionsModel adm = null;
        int i = 0;
        boolean expResult = false;
        boolean result = ReasonsDisplayView.checkIfReasonsToBeDisplayedForCurrentAssumption(incorrectAssumptionReasonsMap, adm, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
