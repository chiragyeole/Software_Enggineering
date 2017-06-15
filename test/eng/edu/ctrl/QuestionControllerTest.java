/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 *
 * @author poojithadharmavaram
 */
public class QuestionControllerTest {
    
    public QuestionControllerTest() {
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
     * Test of getPath method, of class QuestionController.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        String imageType = ".png";
        Random rand = new Random();
        int number = rand.nextInt(2)+1;
        String fileType = "RealWorld";
        QuestionController instance = new QuestionController();
        String result = instance.getPath(imageType, number, fileType);
        
        String basePath = System.getProperty("user.home");
        String expResult = "file:"+basePath + "/questions/" + imageType + number + fileType;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    

    
}
