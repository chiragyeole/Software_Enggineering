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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poojithadharmavaram
 */
public class ReasonPageControllerTest {

    public static HashMap<String, ArrayList> expResult;

    public ReasonPageControllerTest() {
        expResult = new HashMap<String, ArrayList>();
    }

    /**
     * Test of readAllReasonsFromFile method, of class ReasonPageController.
     */
    @Test
    public void testReadAllReasonsFromFile() {
        System.out.println("readAllReasonsFromFile");

        String basePath = System.getProperty("user.home");
        String baseDirectory = "/questions/";
        String filename = basePath + baseDirectory + "q1/reasons1.txt";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
        } catch (Exception e) {
            System.out.println(e);
        }
        ReasonPageController instance = new ReasonPageController();
        HashMap result = instance.readAllReasonsFromFile(bufferedReader);
        expResult = expectedResult();

        assertEquals(expResult, result);
    }

    public HashMap expectedResult() {
        String assumption;
        ArrayList reasons = new ArrayList();
        assumption = "Incorrect Assumption that includes a lot of text to make certain you can handle it #1.3";
        reasons.add("Valid Reason #ExamplesAreHard");
        expResult.put(assumption, reasons);

        reasons = new ArrayList();
        assumption = "Incorrect Assumption #1.1";
        reasons.add("Valid Reason #1.1.1");
        reasons.add("Invalid Reason #1.1.2");
        reasons.add("Invalid Reason #1.1.3");
        expResult.put(assumption, reasons);

        assumption = "Complicating Assumption #Who Cares I Am Making All This Up?";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #x.y.z");
        reasons.add("Valid");
        reasons.add("Invalid Reason #hashtag");
        reasons.add("Invalid Reason #HertzRules!");
        expResult.put(assumption, reasons);

        assumption = "Incorrect Assumption #1.2";
        reasons = new ArrayList();
        reasons.add("Invalid Reason #1.2.1");
        reasons.add("Invalid Reason #1.2.2");
        reasons.add("Invalid Reason #1.2.3");
        reasons.add("Valid Reason #1.2.4");
        expResult.put(assumption, reasons);

        return expResult;
    }

}
