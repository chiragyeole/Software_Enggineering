

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;

import eng.edu.model.AssumptionsDisplayModel;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.text.TextAlignment;
/**
 *
 * @author deeptichavan
 * 
 * This class generates assumptions as CheckBoxes
 */
public class AssumptionsDisplayView  {
    
    public AssumptionsDisplayModel model = new AssumptionsDisplayModel();
    public ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    String style = "-fx-wrap-text:true;";
    
    public void displayAssumptions(){
        
        int i;
     
        /*
        *assumptionsList :: generated from the assumptions text file
        */
        for(i = 0; i < model.assumptionsList.size(); i++){
            String assumptionTxt = model.assumptionsList.get(i).getAssumption();
            CheckBox checkBox = new CheckBox(assumptionTxt);
            checkBox.setId("checkbox" + i);
            checkBox.setMaxSize(650, 10);
            //checkBox.setWrapText(true);
            checkBox.setStyle(style);
            checkBoxes.add(checkBox);
        }
        
    }
}

