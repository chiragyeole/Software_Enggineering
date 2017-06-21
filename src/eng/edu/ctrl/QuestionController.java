/**
 * This class displays the real world and idealized model images
 */
package eng.edu.ctrl;

//import static eng.edu.ctrl.ReasonPageController.selectedReasons;
import eng.edu.view.AssumptionsDisplayView;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.Window;

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
    public  ScrollPane scrollPane;
    
    public static boolean isAssumptionListener = true;
    public static ArrayList<ToggleGroup> toggleGroupList = new ArrayList<>(); 
    public static ArrayList<String> incorrectlyAnsweredAssumptionsList = new ArrayList<String>();

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
    }

    

    public void setDataPane(Node node) {
        // update VBox with new form(FXML) depends on which button is clicked
        dataPane.getChildren().setAll(node);
    }

      //Pops up a dialogue box to indicate that user needs to select atleast one assumption
    public void showPopupForSelectingAtleastOneAssumption(){      
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
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

    public void displayOptionIcon(ObservableList<AssumptionsDAO> assumptionsList, Scene scene) {

        int i;
        String img;
        
        System.out.println("displayOptionIcon :: " + ReasonPageController.response);
        
        displayStudentResponse(scene);
        disableCheckBoxes(scene);
        
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
            String id = "#checkbox" + ReasonPageController.response.get(i);
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

    public boolean checkIfAllReasonsAreSelected(){
        int numberOfselectedReasons = 0;
        for (int i = 0; i < toggleGroupList.size(); i++) {
            ToggleGroup group = toggleGroupList.get(i);
            if(group.getSelectedToggle()!=null){
                numberOfselectedReasons++;
            }
        }           
        if(numberOfselectedReasons!=toggleGroupList.size()){
            return false;
        }
        else{
            return true;
        } 
    }
    
    public ArrayList<String> getCorrectReasonsForIncorrectlySelectedReasons(){
        HashMap<String,String> correctReasons = ReasonPageController.correctReasons;
        ArrayList<String> correctReasonsList = new ArrayList<>();
        for(int i=0; i< incorrectlyAnsweredAssumptionsList.size(); i++){
            String currentAssumption = incorrectlyAnsweredAssumptionsList.get(i);
            String currentReason = correctReasons.get(currentAssumption);
            correctReasonsList.add(currentReason);
        }
        return correctReasonsList;
    }
    
    public void verifySelectedReasons(ArrayList<String> correctReasonsList){
        ArrayList<Integer> verificationResult = new ArrayList<>();
        for (int i = 0; i < toggleGroupList.size(); i++) {
            ToggleGroup group = toggleGroupList.get(i);
            if(group.getSelectedToggle()!=null){
                String selectedReason = group.getSelectedToggle().getUserData().toString();
                if(selectedReason.equals(correctReasonsList.get(i))){
                    verificationResult.add(1);
                }
                else{
                    verificationResult.add(0);
                }
                RadioButton radioButton = (RadioButton)group.getSelectedToggle();
                System.out.println("ID "+radioButton.getId());
                
            }
        }  
       System.out.println("verificationResult "+verificationResult);
    }
    
    public static void closeWindow(ActionEvent event){
        Button button = (Button)(event.getSource());    
        Window window = button.getScene().getWindow();
        Stage stage = (Stage)window;             
        stage.close();
    }
    
   
    //handles the steps after clicking the submit button
    @FXML
    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        
        AssumptionsDisplayView adv = new AssumptionsDisplayView();
        if(isAssumptionListener){
            AssumptionsListener assumptionsListener = new AssumptionsListener();
            boolean isAnswerSelected = assumptionsListener.checkIfAssumptionsMarked(event, submitId);
            if(isAnswerSelected){
                isAssumptionListener = false;
                if(incorrectlyAnsweredAssumptionsList.isEmpty()){
                    QuestionController.closeWindow(event);
                }
                else{
                    ReasonsListener reasonsListener = new ReasonsListener();
                    reasonsListener.reasonsListener(incorrectlyAnsweredAssumptionsList, submitId.getScene());
                    displayOptionIcon(adv.model.assumptionsList, submitId.getScene());
                }
            }
            else{
                showPopupForSelectingAtleastOneAssumption();
            }
        }
        else{
            boolean result = checkIfAllReasonsAreSelected();
            if(result){
//                Scene scene = submitId.getScene();
                ArrayList<String> correctReasonsList = getCorrectReasonsForIncorrectlySelectedReasons();
                verifySelectedReasons(correctReasonsList);
                closeWindow(event);
            }
            else{
                showPopupForSelectingAllReasons();
            }
        }
    }

}
