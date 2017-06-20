/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import eng.edu.view.AssumptionsDisplayView;
import eng.edu.view.ReasonsDisplayView;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Gayatri
 */
public class ReasonsListener {
    
    public static HashMap<String, ArrayList> getReasonsForIncorrectAssumptions(HashMap<String, ArrayList> assumptionReasonsMap, ArrayList<String> incorrectlyAnsweredAssumptionsList){
        HashMap<String, ArrayList> incorrectAssumptionReasonsMap = new HashMap<String, ArrayList>();
        for(int i=0; i<incorrectlyAnsweredAssumptionsList.size(); i++){
            if(assumptionReasonsMap.keySet().contains(incorrectlyAnsweredAssumptionsList.get(i))){
                incorrectAssumptionReasonsMap.put(incorrectlyAnsweredAssumptionsList.get(i), assumptionReasonsMap.get(incorrectlyAnsweredAssumptionsList.get(i)));
            }
        }  
        return incorrectAssumptionReasonsMap;
    } 
    
    
    public static void reasonsListener(ArrayList<String> incorrectlyAnsweredAssumptionsList, Scene scene){
        ReasonPageController reasonPageController = new ReasonPageController();
        BufferedReader bufferedReader = reasonPageController.getFileReader();
        HashMap<String, ArrayList> assumptionReasonsMap = reasonPageController.readAllReasonsFromFile(bufferedReader);
                 
        HashMap<String, ArrayList> incorrectAssumptionReasonsMap = getReasonsForIncorrectAssumptions(assumptionReasonsMap, incorrectlyAnsweredAssumptionsList);      
        ScrollPane scrollPane = (ScrollPane)scene.lookup("#scrollPane");
        ReasonsDisplayView.displayReasons(incorrectAssumptionReasonsMap, scrollPane);
    }
}
