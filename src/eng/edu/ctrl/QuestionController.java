/**
 * This class displays the real world and idealized model images
 */
package eng.edu.ctrl;

//import static eng.edu.ctrl.ReasonPageController.selectedReasons;
import eng.edu.view.AssumptionsDisplayView;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import eng.edu.utilities.Utilities;
import javafx.scene.control.CheckBox;

public class QuestionController {

    @FXML
    private VBox dataPane;

    @FXML
    private ImageView realWorldImage;

    @FXML
    private ImageView idealizedImage;

    public static int n;
    @FXML
    private Button submitId;

    @FXML
    public static ScrollPane scrollPane;

    public Button okButton;
    int clicked = 0;
    boolean responseSelected = false;
    ArrayList<ToggleGroup> toggleGroupList = new ArrayList<>();
    ArrayList<String> incorrectAssumptionsList = new ArrayList<String>();

    public void initialize() throws MalformedURLException {
        
        

        /*
        * real world image stored in users home location is displayed from here.
         */
        Utilities u = new Utilities();
        n = u.number;
        
        System.out.println("inititalize :: " + n);
        String path = u.getPath("RealWorld", ".png");
        Image imageReal = new Image(path);
        realWorldImage.setImage(imageReal);

        /*
        * Idealized model image stored in users home location is displayed from here.
         */
        path = u.getPath("IdealizedModel", ".png");
        Image imageIdeal = new Image(path);
        idealizedImage.setImage(imageIdeal);
        
        System.out.print("-----12-----" + scrollPane);

    }

    

    public void setDataPane(Node node) {
        // update VBox with new form(FXML) depends on which button is clicked
        dataPane.getChildren().setAll(node);
    }

    public VBox fadeAnimate(String url) throws IOException {
        VBox v = (VBox) FXMLLoader.load(getClass().getResource(url));
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(v);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        return v;
    }

    //Pops up a dialogue box to indicate that user needs to select atleast one assumption
    public void showPopupForSelectingAtleastOneAssumption() {
        Alert alert = new Alert(AlertType.INFORMATION);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/eng/edu/view/dialogbox.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please select atleast one option!");
        alert.showAndWait();
    }

    //Pops up a dialogue box to indicate that user needs to give reasons for all incorrect assumptions seleted previously
    public void showPopupForSelectingAllReasons() {
        Alert alert = new Alert(AlertType.INFORMATION);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/eng/edu/view/dialogbox.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please select reasons for all incorrect assumptions!");
        alert.showAndWait();
    }

    public void displayReasons(HashMap<String, ArrayList> incorrectAssumptionReasonsMap, Scene scene) {
        
        System.out.println("--------scroll--1---" + scrollPane);

        AssumptionsDisplayView adv = new AssumptionsDisplayView();
        adv.displayAssumptions();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 20));

        int count = 0;
        int i;
        for (i = 0; i < adv.checkBoxes.size(); i++) {
            if (incorrectAssumptionReasonsMap.keySet().contains(adv.checkBoxes.get(i).getText())) {
                ArrayList<String> reasons = incorrectAssumptionReasonsMap.get(incorrectAssumptionsList.get(count));

                final VBox vbox1 = new VBox();
                final HBox hbox = new HBox();
                vbox.getChildren().addAll(hbox, vbox1);
                hbox.getChildren().addAll(adv.labels.get(i), adv.checkBoxes.get(i));

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
            } else {
                final HBox hbox = new HBox();
                vbox.getChildren().add(hbox);
                hbox.getChildren().addAll(adv.labels.get(i), adv.checkBoxes.get(i));
            }
        }
        
        System.out.println("--------scroll-----" + scrollPane);
        scrollPane.setContent(vbox);

        displayOptionIcon(adv.model.assumptionsList, scene);

    }

    public void displayOptionIcon(ObservableList<AssumptionsDAO> assumptionsList, Scene scene) {

        int i;
        String img;
        
        System.out.println("displayOptionIcon :: " + ReasonPageController.response);
        
        displayStudentResponse(scene);
       // disableCheckBoxes(scene);
        
        for (i = 0; i < assumptionsList.size(); i++) {
            String id = "#label" + i;
            Label lb = (Label) scene.lookup(id);
            lb.setVisible(true);

            if (assumptionsList.get(i).isCorrect == 1) {
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
    
    public void displayStudentResponse(Scene scene){
        
        int i;
        for (i = 0; i < ReasonPageController.response.size(); i++) {
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox) scene.lookup(id);
            cb.setSelected(true);
            cb.setStyle("-fx-font-weight: bold;");
        }
        
    }
    
    public void disableCheckBoxes(Scene scene){
        
        int i;
        for(i = 0; i < ReasonPageController.aaumptionListSize; i++){
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox) scene.lookup(id);
            cb.setDisable(true);
        }
    }

    public void checkIfAllReasonsAreSelected(ActionEvent event) {
        int numberOfselectedReasons = 0;
        for (int i = 0; i < toggleGroupList.size(); i++) {
            ToggleGroup group = toggleGroupList.get(i);
            if (group.getSelectedToggle() != null) {
                numberOfselectedReasons++;
            }
        }
        if (numberOfselectedReasons != toggleGroupList.size()) {
            showPopupForSelectingAllReasons();
        } else {
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        }
    }

    //handles the steps after clicking the submit button
    @FXML
    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        
        System.out.println("--------scroll---2--" + scrollPane);
        int numberOfResponse = 0;
        if (responseSelected == false) {
            ReasonPageController reasonPageController = new ReasonPageController();
            reasonPageController = reasonPageController.verifyAnswer(submitId.getScene());
            incorrectAssumptionsList = reasonPageController.incorrectResponse;
            numberOfResponse = reasonPageController.numberOfResponse;
            if (numberOfResponse == 0) {
                showPopupForSelectingAtleastOneAssumption();
                return;
            } else {
                responseSelected = true;
            }
        }
        clicked++;

        if (incorrectAssumptionsList.isEmpty()) {
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        } else if (clicked >= 2) {
            checkIfAllReasonsAreSelected(event);
        } else {
            ReasonPageController reasonPageController = new ReasonPageController();
            HashMap<String, ArrayList> assumptionReasonsMap = reasonPageController.readAllReasonsFromFile();
            HashMap<String, ArrayList> incorrectAssumptionReasonsMap = new HashMap<String, ArrayList>();
            for (int i = 0; i < incorrectAssumptionsList.size(); i++) {
                if (assumptionReasonsMap.keySet().contains(incorrectAssumptionsList.get(i))) {
                    incorrectAssumptionReasonsMap.put(incorrectAssumptionsList.get(i), assumptionReasonsMap.get(incorrectAssumptionsList.get(i)));
                }
            }
            displayReasons(incorrectAssumptionReasonsMap, submitId.getScene());
        }
    }

}
