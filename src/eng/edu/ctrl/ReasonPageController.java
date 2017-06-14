/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import eng.edu.view.AssumptionsDisplayView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author deeptichavan
 */
public class ReasonPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void verifyAnswer(Scene scene){
        
        ArrayList<Integer> response = getStudentsResponse(scene);
        System.out.println("response :: " + response);
        String basePath = System.getProperty("user.home");
        File fileReal = new File(basePath + "/questions/correct.png");
        File fileReal1 = new File(basePath + "/questions/cross.png");
        
        AssumptionsDisplayView atv = new AssumptionsDisplayView();
        
        ArrayList<String> incorrectResponse = new ArrayList<>();
        int i;
        for(i = 0; i < response.size(); i++){
            String txt = atv.model.assumptionsList.get(response.get(i)).assumption;
            int res = atv.model.assumptionsList.get(response.get(i)).isCorrect;
            
            if(res == 0){
                incorrectResponse.add(txt);
                //Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
                
                String id = "#label" + response.get(i);
                Label lb = (Label)scene.lookup(id);
                lb.setVisible(true);
                ImageView cross = new ImageView(fileReal1.toURI().toString());
                cross.setFitHeight(15);
                cross.setFitWidth(15);
                lb.setGraphic(cross);
                //lb.setText("Incorrect");
            }
            else
            {
             String id = "#label" + response.get(i);   
             Label lb = (Label)scene.lookup(id);
             lb.setVisible(true);
              ImageView correct = new ImageView(fileReal.toURI().toString());
              correct.setFitHeight(15);
               correct.setFitWidth(15);
                lb.setGraphic(correct);
             //lb.setText("Correct");
            }
        }
        
        System.out.println("Incorrest list :: " + incorrectResponse);
    }
    
    
    /*
    * get the option numbers that the student selected
    */
    public ArrayList<Integer> getStudentsResponse(Scene scene){
        
        AssumptionsDisplayView atv = new AssumptionsDisplayView();
        
        ArrayList<Integer> response = new ArrayList<>();
        int listSize = atv.model.assumptionsList.size();
        
        int i;
        for(i = 0; i < listSize; i++){
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox)scene.lookup(id);
            
            if(cb.isSelected()){
                response.add(i);
            }
            
        }
        
        System.out.println("Student's response :: " + response);
        return response;
    }
}
