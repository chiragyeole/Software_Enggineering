

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;

import eng.edu.model.AssumptionsDisplayModel;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
/**
 *
 * @author deeptichavan
 * 
 * Modified by Gayatri
 * This class generates assumptions as CheckBoxes
 */
public class AssumptionsDisplayView  {
    
    public AssumptionsDisplayModel model = new AssumptionsDisplayModel();
    public ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    public ArrayList<Label> labels = new ArrayList<>();
    String basePath = System.getProperty("user.home");
    File fileReal = new File(basePath + "/questions/correct.png");
    
    public void displayAssumptions(){
        
        int i;
     
        /*
        *assumptionsList :: generated from the assumptions text file
        */
        for(i = 0; i < model.assumptionsList.size(); i++){
            String assumptionTxt = model.assumptionsList.get(i).getAssumption();
            CheckBox checkBox = new CheckBox(assumptionTxt);
            Label label = new Label();
            checkBox.setId("checkbox" + i);

            ImageView correct = new ImageView(fileReal.toURI().toString());
            correct.setFitHeight(15);
            correct.setFitWidth(15);
            label.setGraphic(correct);
            label.setVisible(false);
            label.setId("label" + i );
            labels.add(label);
            checkBoxes.add(checkBox);
        }
        
    }
}

