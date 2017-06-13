/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import eng.edu.view.AssumptionsTableView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
        
        ObservableList<Integer> response = getStudentsResponse(scene);
        System.out.println("response :: " + response);
        
        AssumptionsTableView atv = new AssumptionsTableView();
        
        ArrayList<String> incorrectResponse = new ArrayList<>();
        int i;
        for(i = 0; i < response.size(); i++){
            String txt = atv.model.assumptionsList.get(response.get(i)).assumption;
            int res = atv.model.assumptionsList.get(response.get(i)).isCorrect;
            //System.out.println(txt + " :: " + res);
            if(res == 0){
                incorrectResponse.add(txt);
            }
        }
        
        System.out.println("Incorrest list :: " + incorrectResponse);
    }
    
    
    public ObservableList<Integer> getStudentsResponse(Scene scene){
        
        TableView tv = (TableView) scene.lookup("#assumptionsTable");
        
        ObservableList<Integer> response = tv.getSelectionModel().getSelectedIndices();
        return response;
    }
}
