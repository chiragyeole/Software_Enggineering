/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import eng.edu.view.AssumptionsDisplayView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
        
        AssumptionsDisplayView atv = new AssumptionsDisplayView();
        
        ArrayList<String> incorrectResponse = new ArrayList<>();
        int i;
        for(i = 0; i < response.size(); i++){
            String txt = atv.model.assumptionsList.get(response.get(i)).assumption;
            int res = atv.model.assumptionsList.get(response.get(i)).isCorrect;
            
            if(res == 0){
                incorrectResponse.add(txt);
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
