/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;

import eng.edu.ctrl.AssumptionsListener;
import static eng.edu.ctrl.QuestionController.toggleGroupList;
import eng.edu.model.AssumptionsDAO;
import eng.edu.model.AssumptionsModel;
import eng.edu.utilities.Utilities;
import java.io.File;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author deeptichavan
 */
public class OptionsResponseView {

    //it shows correct and incorrect icons against each assumptions
    public void displayOptionIcon(ObservableList<AssumptionsDAO> assumptionsList, Scene scene) {

        int i;
        String img;

        highlightSelectedOptions(scene);
        disableCheckBoxes(scene);

        for (i = 0; i < assumptionsList.size(); i++) {
            String id = "#label" + i;
            Label lb = (Label) scene.lookup(id);
            lb.setVisible(true);

            if (assumptionsList.get(i).getIsCorrect() == true) {
                img = new File(Utilities.basePath + "/questions/correct.png").toURI().toString();
            } else {
                img = new File(Utilities.basePath + "/questions/cross.png").toURI().toString();
            }
            ImageView iv = new ImageView(img);
            iv.setFitHeight(15);
            iv.setFitWidth(15);
            lb.setGraphic(iv);
        }
    }


    public void highlightSelectedOptions(Scene scene) {

        AssumptionsModel adm = new AssumptionsModel();
        int i;
        for (i = 0; i < AssumptionsListener.response.size(); i++) {

            boolean isCorrect = adm.assumptionsList.get(AssumptionsListener.response.get(i)).getIsCorrect();
            String id = "#checkbox" + AssumptionsListener.response.get(i);
            CheckBox cb = (CheckBox) scene.lookup(id);
            cb.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
            cb.setSelected(true);
            if (isCorrect) {   
                cb.setStyle("-fx-text-fill: green;");
            }else{
                cb.setStyle("-fx-text-fill: red;");
            }
        }

    }

    public static void highlightReasonResponse(ArrayList<String> correctReasonsList){
        for (int i = 0; i < toggleGroupList.size(); i++) {
            ToggleGroup group = toggleGroupList.get(i);
            if(group.getSelectedToggle()!=null){
                String selectedReason = group.getSelectedToggle().getUserData().toString();
                RadioButton rb = (RadioButton)group.getSelectedToggle();
                rb.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
                if(selectedReason.equals(correctReasonsList.get(i))){
                    rb.setStyle("-fx-text-fill: green;");
                }
                else{
                    rb.setStyle("-fx-text-fill: red;");
                }
                
            }
        }  
    }
    public void disableCheckBoxes(Scene scene) {

        int i;
        for (i = 0; i < AssumptionsListener.aaumptionListSize; i++) {
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox) scene.lookup(id);
            cb.setDisable(true);
        }
    }

    
    public void displayScore(Scene scene, int score){
        Label lb1 = (Label) scene.lookup("#score");
        lb1.setText("Score: "+score);
        System.out.println("updatedScore "+score);
    }

    //Pops up a dialogue box to indicate that user needs to select atleast one assumption
    public void showPopupForSelectingAtleastOneAssumption() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/eng/edu/view/dialogbox.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please select atleast one option!");
        alert.showAndWait();
    }

    //Pops up a dialogue box to indicate that user needs to give reasons for all incorrect assumptions seleted previously
    public void showPopupForSelectingAllReasons() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/eng/edu/view/dialogbox.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please select reasons for all incorrect assumptions!");
        alert.showAndWait();
    }
}
