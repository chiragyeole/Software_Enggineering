/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *
 * @author Gayatri
 */
public class AssumptionsListener {

    public boolean checkIfAssumptionsMarked(ActionEvent event, Button submitId) {

        ReasonPageController reasonPageController = new ReasonPageController(submitId.getScene());
        int numberOfResponse = reasonPageController.response.size();
        if (numberOfResponse == 0) {
            return false;
        } else {
            return true;
        }
    }

}
