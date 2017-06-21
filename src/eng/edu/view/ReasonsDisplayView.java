/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;


import static eng.edu.ctrl.QuestionController.toggleGroupList;
import eng.edu.model.AssumptionsDisplayModel;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Gayatri
 */
public class ReasonsDisplayView {

    public static ArrayList<String> getReasonsForCurrentAssumption(HashMap<String, ArrayList> incorrectAssumptionReasonsMap, ArrayList<String> incorrectlyAnsweredAssumptionsList, int count){
        ArrayList<String> reasons = incorrectAssumptionReasonsMap.get(incorrectlyAnsweredAssumptionsList.get(count));
        return reasons;
    }
    
    public static boolean checkIfReasonsToBeDisplayedForCurrentAssumption(HashMap<String, ArrayList> incorrectAssumptionReasonsMap, AssumptionsDisplayModel adm, int i){
        boolean reasonsToBeDisplayed = false;
        if(incorrectAssumptionReasonsMap.keySet().contains(adm.checkBoxes.get(i).getText())){
            reasonsToBeDisplayed = true;
        }else{
            reasonsToBeDisplayed = false;
        }    
        return reasonsToBeDisplayed; 
    }
    
    
    
    public static void displayReasons(HashMap<String, ArrayList> incorrectAssumptionReasonsMap, ArrayList<String> incorrectlyAnsweredAssumptionsList, ScrollPane scrollPane){
       
        AssumptionsDisplayModel adm = new AssumptionsDisplayModel();
        adm.assignAssumptionsToCheckBoxes();  
        adm.assignLablesToAssumptions();
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 20));            
        int count = 0;            

        for(int i = 0; i < adm.checkBoxes.size(); i++){
            boolean reasonsToBeDisplayed = checkIfReasonsToBeDisplayedForCurrentAssumption(incorrectAssumptionReasonsMap, adm, i);
            if(reasonsToBeDisplayed){
                ArrayList<String> reasons = getReasonsForCurrentAssumption(incorrectAssumptionReasonsMap,incorrectlyAnsweredAssumptionsList, count);
                
                final VBox vbox1 = new VBox();
                final HBox hbox = new HBox();
                vbox.getChildren().addAll(hbox, vbox1);            
                hbox.getChildren().addAll(adm.labels.get(i),adm.checkBoxes.get(i));               

                final ToggleGroup group = new ToggleGroup();
                for (int j = 0; j < reasons.size(); j++) {
                    RadioButton radioButton = new RadioButton(reasons.get(j));
                    radioButton.setUserData(reasons.get(j));
                    vbox1.getChildren().add(radioButton);
                    vbox1.setMargin(radioButton, new Insets(0, 0, 0, 50));
                    radioButton.setToggleGroup(group);
                }
                toggleGroupList.add(group);              
                count++;    
            }else{
                final HBox hbox = new HBox();
                vbox.getChildren().add(hbox);
                hbox.getChildren().addAll(adm.labels.get(i),adm.checkBoxes.get(i));
            }
        }         
        scrollPane.setContent(vbox);
    }
    
}
