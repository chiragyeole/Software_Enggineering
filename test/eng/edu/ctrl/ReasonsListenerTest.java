/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poojithadharmavaram
 */
public class ReasonsListenerTest {

    public static HashMap<String, ArrayList> assumptionReasonsMap;

    public ReasonsListenerTest() {

        assumptionReasonsMap = new HashMap<String, ArrayList>();
    }

    public HashMap getMap() {
        String assumption;
        ArrayList reasons = new ArrayList();
        assumption = "Incorrect Assumption that includes a lot of text to make certain you can handle it #1.3";
        reasons.add("Valid Reason #ExamplesAreHard");
        assumptionReasonsMap.put(assumption, reasons);

        reasons = new ArrayList();
        assumption = "Incorrect Assumption #1.1";
        reasons.add("Valid Reason #1.1.1");
        reasons.add("Invalid Reason #1.1.2");
        reasons.add("Invalid Reason #1.1.3");
        assumptionReasonsMap.put(assumption, reasons);

        assumption = "Complicating Assumption #Who Cares I Am Making All This Up?";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #x.y.z");
        reasons.add("Valid");
        reasons.add("Invalid Reason #hashtag");
        reasons.add("Invalid Reason #HertzRules!");
        assumptionReasonsMap.put(assumption, reasons);

        assumption = "Incorrect Assumption #1.2";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #1.2.1");
        reasons.add("Invalid Reason #1.2.2");
        reasons.add("Invalid Reason #1.2.3");
        reasons.add("Valid Reason #1.2.4");
        assumptionReasonsMap.put(assumption, reasons);

        return assumptionReasonsMap;
    }

    /**
     * Test of getReasonsForIncorrectAssumptions method, of class
     * ReasonsListener.
     */
    @Test
    public void testGetReasonsForIncorrectAssumptions() {
        System.out.println("getReasonsForIncorrectAssumptions");

        assumptionReasonsMap = getMap();
        ArrayList<String> incorrectlyAnsweredAssumptionsList = new ArrayList();
        incorrectlyAnsweredAssumptionsList.add("Incorrect Assumption #1.1");

        HashMap<String, ArrayList> expResult = new HashMap<String, ArrayList>();
        String assumption = "Incorrect Assumption #1.1";
        ArrayList reasons = new ArrayList();
        reasons.add("Valid Reason #1.1.1");
        reasons.add("Invalid Reason #1.1.2");
        reasons.add("Invalid Reason #1.1.3");
        expResult.put(assumption, reasons);

        HashMap<String, ArrayList> result = ReasonsListener.getReasonsForIncorrectAssumptions(assumptionReasonsMap, incorrectlyAnsweredAssumptionsList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
