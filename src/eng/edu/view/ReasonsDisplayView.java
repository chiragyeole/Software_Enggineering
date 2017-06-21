/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;

import static eng.edu.ctrl.QuestionController.incorrectlyAnsweredAssumptionsList;
import static eng.edu.ctrl.QuestionController.toggleGroupList;
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
    
    public static void displayReasons(HashMap<String, ArrayList> incorrectAssumptionReasonsMap, ScrollPane scrollPane){
       
        AssumptionsDisplayView adv = new AssumptionsDisplayView();
        adv.assignAssumptionsToCheckBoxes();  
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 20));    
        
        int count = 0;            
        int i;
        for(i = 0; i < adv.checkBoxes.size(); i++){
            if(incorrectAssumptionReasonsMap.keySet().contains(adv.checkBoxes.get(i).getText())){
                ArrayList<String> reasons = incorrectAssumptionReasonsMap.get(incorrectlyAnsweredAssumptionsList.get(count));
               
                final VBox vbox1 = new VBox();
                final HBox hbox = new HBox();
                vbox.getChildren().addAll(hbox, vbox1);            
                hbox.getChildren().addAll(adv.labels.get(i),adv.checkBoxes.get(i));
                
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
            }
            else{
                final HBox hbox = new HBox();
                vbox.getChildren().add(hbox);
                hbox.getChildren().addAll(adv.labels.get(i),adv.checkBoxes.get(i));
            }
        } 
        
        scrollPane.setContent(vbox);
    }
    
}
