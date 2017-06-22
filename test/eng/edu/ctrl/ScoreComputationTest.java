/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chiragyeole
 */
public class ScoreComputationTest {
    
    /**
     * Test of calculateScore method, of class ScoreComputation.
     */
    @Test
    public void testCalculateScore() {
        System.out.println("calculateScore");
        int numberOfIncorrectResponses = 1;
        int numberOfResponses = 3;
        String scoreEvaluationType = "assumption";
        int expResult = 2;
        int result = ScoreComputation.calculateScore(numberOfIncorrectResponses, numberOfResponses, scoreEvaluationType);
        assertEquals(expResult, result);
   
    }

    /**
     * Test of readScoreFile method, of class ScoreComputation.
     */
    @Test
    public void testReadScoreFile() {
        System.out.println("readScoreFile");
        ArrayList<Integer> expResult = null;
        expResult.add(2);
        expResult.add(-2);
        ArrayList<Integer> result = ScoreComputation.readScoreFile();
        assertEquals(expResult, result);

    }
    
}
