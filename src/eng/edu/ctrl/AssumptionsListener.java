/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import static eng.edu.ctrl.QuestionController.incorrectlyAnsweredAssumptionsList;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *
 * @author Gayatri
 */
public class AssumptionsListener {

    public boolean checkIfAssumptionsMarked(ActionEvent event) {
        ReasonPageController reasonPageController = new ReasonPageController();
        int numberOfResponse = reasonPageController.response.size();
        if (numberOfResponse == 0) {
            return false;
        } else {
            return true;
        }
    }
 
}
