/**
 * This class displays the real world and idealized model images
 */
package eng.edu.ctrl;

//import static eng.edu.ctrl.ReasonPageController.selectedReasons;
import eng.edu.view.AssumptionsDisplayView;
import java.util.HashMap;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.Window;

import eng.edu.utilities.Utilities;
import eng.edu.view.OptionsResponseView;

public class QuestionController {

    @FXML
    private VBox dataPane;

    @FXML
    private ImageView realWorldImage;

    @FXML
    private ImageView idealizedImage;

    
    @FXML
    private Button submitId;

    @FXML
    public  ScrollPane scrollPane;
    
    public static int updatedScore;
    
    public static boolean isAssumptionListener = true;
    public static ArrayList<ToggleGroup> toggleGroupList = new ArrayList<>(); 
    public static ArrayList<String> incorrectlyAnsweredAssumptionsList = new ArrayList<String>();
    public static int quesNo;
    
    public void initialize() throws MalformedURLException {
        /*
        * real world image stored in users home location is displayed from here.
         */
        Utilities u = new Utilities();
        quesNo = u.number;
        
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
        int numberOfWrongReasonsSelected = 0;
        for (int i = 0; i < toggleGroupList.size(); i++) {
            ToggleGroup group = toggleGroupList.get(i);
            if(group.getSelectedToggle()!=null){
                String selectedReason = group.getSelectedToggle().getUserData().toString();
                if(selectedReason.equals(correctReasonsList.get(i))){
                    verificationResult.add(1);
                }
                else{
                    verificationResult.add(0);
                    numberOfWrongReasonsSelected++;
                }
//                RadioButton radioButton = (RadioButton)group.getSelectedToggle();
//                System.out.println("ID "+radioButton.getId());
//                
            }
        }  
       System.out.println("verificationResult "+verificationResult);
       OptionsResponseView optionsResponseView = new OptionsResponseView();
       int score = optionsResponseView.calculateScore(numberOfWrongReasonsSelected, correctReasonsList.size(), "reasons");
       updatedScore +=score;
       optionsResponseView.displayScore(submitId.getScene(), updatedScore);
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
        OptionsResponseView opr = new OptionsResponseView();
        
        if(isAssumptionListener){
            ReasonPageController reasonPageController = new ReasonPageController();
            incorrectlyAnsweredAssumptionsList = reasonPageController.getIncorrectSelectedResponse(submitId.getScene());    
            AssumptionsListener assumptionsListener = new AssumptionsListener();
            boolean isAnswerSelected = assumptionsListener.checkIfAssumptionsMarked(event);
            if(isAnswerSelected){
                isAssumptionListener = false;
                if(incorrectlyAnsweredAssumptionsList.isEmpty()){
                    QuestionController.closeWindow(event);
                }else{
                    ReasonsListener reasonsListener = new ReasonsListener();
                    reasonsListener.reasonsListener(incorrectlyAnsweredAssumptionsList, submitId.getScene());
                    opr.displayOptionIcon(adv.model.assumptionsList, submitId.getScene());
                }
            }else{
                opr.showPopupForSelectingAtleastOneAssumption();
            }
        }else{
            boolean result = checkIfAllReasonsAreSelected();
            if(result){
                ArrayList<String> correctReasonsList = getCorrectReasonsForIncorrectlySelectedReasons();
                verifySelectedReasons(correctReasonsList);
                closeWindow(event);
            }else{
                opr.showPopupForSelectingAllReasons();
            }
        }
    }

}
