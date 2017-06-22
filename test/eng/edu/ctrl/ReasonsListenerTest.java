/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Scene;
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

    
    public static HashMap<String, ArrayList> assumptionReasonsMap;
    
    public ReasonsListenerTest() {
        
        assumptionReasonsMap = new HashMap<String, ArrayList>();
    }
    
    public HashMap getMap()
    {
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        String assumption;
        ArrayList reasons = new ArrayList();
        assumption = "Incorrect Assumption that includes a lot of text to make certain you can handle it #1.3";
        reasons.add("Valid Reason #ExamplesAreHard");
<<<<<<< HEAD
        assumptionReasonsMap.put(assumption, reasons);

=======
        assumptionReasonsMap.put(assumption,reasons);
        
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        reasons = new ArrayList();
        assumption = "Incorrect Assumption #1.1";
        reasons.add("Valid Reason #1.1.1");
        reasons.add("Invalid Reason #1.1.2");
        reasons.add("Invalid Reason #1.1.3");
<<<<<<< HEAD
        assumptionReasonsMap.put(assumption, reasons);

=======
        assumptionReasonsMap.put(assumption,reasons);
        
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        assumption = "Complicating Assumption #Who Cares I Am Making All This Up?";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #x.y.z");
        reasons.add("Valid");
        reasons.add("Invalid Reason #hashtag");
        reasons.add("Invalid Reason #HertzRules!");
<<<<<<< HEAD
        assumptionReasonsMap.put(assumption, reasons);

=======
        assumptionReasonsMap.put(assumption,reasons);
        
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        assumption = "Incorrect Assumption #1.2";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #1.2.1");
        reasons.add("Invalid Reason #1.2.2");
        reasons.add("Invalid Reason #1.2.3");
        reasons.add("Valid Reason #1.2.4");
<<<<<<< HEAD
        assumptionReasonsMap.put(assumption, reasons);

=======
        assumptionReasonsMap.put(assumption,reasons);
        
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        return assumptionReasonsMap;
    }

    /**
<<<<<<< HEAD
     * Test of getReasonsForIncorrectAssumptions method, of class
     * ReasonsListener.
=======
     * Test of getReasonsForIncorrectAssumptions method, of class ReasonsListener.
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
     */
    @Test
    public void testGetReasonsForIncorrectAssumptions() {
        System.out.println("getReasonsForIncorrectAssumptions");
<<<<<<< HEAD

        assumptionReasonsMap = getMap();
        ArrayList<String> incorrectlyAnsweredAssumptionsList = new ArrayList();
        incorrectlyAnsweredAssumptionsList.add("Incorrect Assumption #1.1");

=======
        
        assumptionReasonsMap = getMap();
        ArrayList<String> incorrectlyAnsweredAssumptionsList = new ArrayList();
        incorrectlyAnsweredAssumptionsList.add("Incorrect Assumption #1.1");
        
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        HashMap<String, ArrayList> expResult = new HashMap<String, ArrayList>();
        String assumption = "Incorrect Assumption #1.1";
        ArrayList reasons = new ArrayList();
        reasons.add("Valid Reason #1.1.1");
        reasons.add("Invalid Reason #1.1.2");
        reasons.add("Invalid Reason #1.1.3");
<<<<<<< HEAD
        expResult.put(assumption, reasons);

        HashMap<String, ArrayList> result = ReasonsListener.getReasonsForIncorrectAssumptions(assumptionReasonsMap, incorrectlyAnsweredAssumptionsList);
        assertEquals(expResult, result);
=======
        expResult.put(assumption,reasons);
       
        HashMap<String, ArrayList> result = ReasonsListener.getReasonsForIncorrectAssumptions(assumptionReasonsMap, incorrectlyAnsweredAssumptionsList);
        assertEquals(expResult, result);      
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

<<<<<<< HEAD
=======
    /**
     * Test of readAllReasonsFromFile method, of class ReasonsListener.
     */
    @Test
    public void testReadAllReasonsFromFile()  {
        System.out.println("readAllReasonsFromFile");
        
        String basePath = System.getProperty("user.home");
        String baseDirectory = "/questions/";
        String filename = basePath + baseDirectory + "q1/reasons1.txt";
        BufferedReader bufferedReader = null;
        try
        {
            bufferedReader= new BufferedReader(new FileReader(filename));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        ReasonsListener instance = new ReasonsListener();
        HashMap result = instance.readAllReasonsFromFile(bufferedReader);
        
        //
        HashMap<String, ArrayList> expResult = new HashMap<String, ArrayList>();
        String assumption;
        ArrayList reasons = new ArrayList();
        assumption = "Incorrect Assumption that includes a lot of text to make certain you can handle it #1.3";
        reasons.add("Valid Reason #ExamplesAreHard");
        expResult.put(assumption,reasons);
        
        reasons = new ArrayList();
        assumption = "Incorrect Assumption #1.1";
        reasons.add("Valid Reason #1.1.1");
        reasons.add("Invalid Reason #1.1.2");
        reasons.add("Invalid Reason #1.1.3");
        expResult.put(assumption,reasons);
        
        assumption = "Complicating Assumption #Who Cares I Am Making All This Up?";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #x.y.z");
        reasons.add("Valid");
        reasons.add("Invalid Reason #hashtag");
        reasons.add("Invalid Reason #HertzRules!");
        expResult.put(assumption,reasons);
        
        assumption = "Incorrect Assumption #1.2";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #1.2.1");
        reasons.add("Invalid Reason #1.2.2");
        reasons.add("Invalid Reason #1.2.3");
        reasons.add("Valid Reason #1.2.4");
        expResult.put(assumption,reasons);
        
       
        assertEquals(expResult, result);
    }

    
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
}
