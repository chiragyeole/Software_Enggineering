/**
 * This class displays the real world and idealized model images
 */
package eng.edu.ctrl;

//import static eng.edu.ctrl.ReasonPageController.selectedReasons;
import static eng.edu.ctrl.AssumptionsListener.response;
<<<<<<< HEAD
=======
import java.util.HashMap;
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
import eng.edu.model.AssumptionsModel;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.Window;

import eng.edu.utilities.Utilities;
import eng.edu.view.OptionsResponseView;
import eng.edu.view.WelcomePageController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

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
<<<<<<< HEAD
    public Button nextId;

    @FXML
    public ScrollPane scrollPane;

    public static int updatedScore;

    public static ArrayList<String> incorrectlyAnsweredAssumptionsList;

    public static boolean isAssumptionListener = true;
    public static ArrayList<ToggleGroup> toggleGroupList = new ArrayList<>();

=======
    public  ScrollPane scrollPane;
    
    public static int updatedScore;
    
    public static ArrayList<String> incorrectlyAnsweredAssumptionsList;
    
    public static boolean isAssumptionListener = true;
    public static ArrayList<ToggleGroup> toggleGroupList = new ArrayList<>(); 
    
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
    public static int quesNo;

    public void initialize() throws MalformedURLException {
<<<<<<< HEAD

        isAssumptionListener = true;
        updatedScore = readScore();

        Utilities u = new Utilities();
        quesNo = u.number;

=======
       
        Utilities u = new Utilities();
        quesNo = u.number;
       
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
        //Real world image stored in users home location is displayed from here.
        String path = u.getPath("RealWorld", ".png");
        Image imageReal = new Image(path);
        realWorldImage.setImage(imageReal);

        //Idealized model image stored in users home location is displayed from here.
        path = u.getPath("IdealizedModel", ".png");
        Image imageIdeal = new Image(path);
        idealizedImage.setImage(imageIdeal);
<<<<<<< HEAD
    }
=======
    }   
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e

    public void setDataPane(Node node) {
        // update VBox with new form(FXML) depends on which button is clicked
        dataPane.getChildren().setAll(node);
    }

<<<<<<< HEAD
    public static void closeWindow(ActionEvent event) {
        Button button = (Button) (event.getSource());
=======
    
    
    
    public static void closeWindow(ActionEvent event){
        Button button = (Button)(event.getSource());    
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
        Window window = button.getScene().getWindow();
        Stage stage = (Stage) window;
        stage.close();
    }

    //handles the steps after clicking the submit button
    @FXML
    public void handleSubmitButtonAction(ActionEvent event) throws IOException {

        AssumptionsModel assumptionsDisplayModel = new AssumptionsModel();
        OptionsResponseView optionsResponseView = new OptionsResponseView();
<<<<<<< HEAD

        //if submit is for assumptions or reasons
        if (isAssumptionListener) {
            AssumptionsListener assumptionsListener = new AssumptionsListener();
            boolean isAnswerSelected = assumptionsListener.checkIfAssumptionsMarked(event, submitId);
            //at least one assumption should be selected
            if (isAnswerSelected) {
                //so that next time the submit is for Reasons
                isAssumptionListener = false;
                incorrectlyAnsweredAssumptionsList = AssumptionsListener.getIncorrectSelectedAssumption(submitId);
                QuestionController.updatedScore += ScoreComputation.calculateScore(incorrectlyAnsweredAssumptionsList.size(), response.size(), "assumption");
                optionsResponseView.displayScore(submitId.getScene(), QuestionController.updatedScore);

                //student didn't mark any incorrect assumptions
                if (incorrectlyAnsweredAssumptionsList.isEmpty()) {
                    optionsResponseView.displayOptionIcon(assumptionsDisplayModel.assumptionsList, submitId.getScene());
                    submitId.setVisible(false);
                    nextId.setVisible(true);
                } else {
=======
        
        //if submit is for assumptions or reasons
        if(isAssumptionListener){        
            AssumptionsListener assumptionsListener = new AssumptionsListener();
            boolean isAnswerSelected = assumptionsListener.checkIfAssumptionsMarked(event, submitId);           
            //at least one assumption should be selected
            if(isAnswerSelected){              
                //so that next time the submit is for Reasons
                isAssumptionListener = false;              
                incorrectlyAnsweredAssumptionsList = AssumptionsListener.getIncorrectSelectedAssumption(submitId);                 
                QuestionController.updatedScore = ScoreComputation.calculateScore(incorrectlyAnsweredAssumptionsList.size(), response.size(), "assumption");       
                optionsResponseView.displayScore(submitId.getScene(), QuestionController.updatedScore);
        
                //student didn't mark any incorrect assumptions
                if(incorrectlyAnsweredAssumptionsList.isEmpty()){
                    QuestionController.closeWindow(event);
                }else{
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
                    //give reasons for the incorrectly selected assumptions
                    ReasonsListener rl = new ReasonsListener();
                    rl.reasonsListener(incorrectlyAnsweredAssumptionsList, submitId.getScene());
                    optionsResponseView.displayOptionIcon(assumptionsDisplayModel.assumptionsList, submitId.getScene());
                }
<<<<<<< HEAD
            } else {
                optionsResponseView.showPopupForSelectingAtleastOneAssumption();
            }
        } else {
//            isAssumptionListener = true;
            boolean result = ReasonsListener.checkIfAllReasonsAreSelected();
            if (result) {
                ArrayList<String> correctReasonsList = ReasonsListener.getCorrectReasonsForIncorrectlySelectedReasons();
                int numberOfWrongReasonsSelected = ReasonsListener.getNumberOfIncorrectReasons(correctReasonsList);
                int score = ScoreComputation.calculateScore(numberOfWrongReasonsSelected, correctReasonsList.size(), "reasons");
                updatedScore += score;
                optionsResponseView.displayScore(submitId.getScene(), updatedScore);
                submitId.setVisible(false);
                nextId.setVisible(true);
            } else {
                optionsResponseView.showPopupForSelectingAllReasons();
            }
        }
    }

    public void handleNextPage(ActionEvent event) throws IOException {
        int score = updatedScore;
        closeWindow(event);

        if (Utilities.questionAlreadyDone.size() == Utilities.max) {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/eng/edu/view/EndPage.fxml"));
            AnchorPane anchor = (AnchorPane) root.getChildren().get(0);
            Label label = (Label) anchor.getChildren().get(1);
            label.setText("Your final score is " + score);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.setTitle("Engineering Educators");
            stage.show();
        } else {
            //QuestionController.incorrectlyAnsweredAssumptionsList.clear();
            //initialize();
            writeScore(updatedScore);

            WelcomePageController w = new WelcomePageController();
            w.handleMainPage(event);

        }
    }

    public static void writeScore(int score) {
        try {
            PrintWriter writer = new PrintWriter(Utilities.basePath + Utilities.baseDirectory + "updatedscore.txt", "UTF-8");
            writer.println(score);
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

    public static int readScore() {

        File scoreFile = new File(Utilities.basePath + "/questions/updatedscore.txt");

        BufferedReader br;
        String currentLine = "";
        String score = "";

        try {

            br = new BufferedReader(new FileReader(scoreFile));

            while ((currentLine = br.readLine()) != null) {
                score = currentLine;
=======
            }else{
                optionsResponseView.showPopupForSelectingAtleastOneAssumption();
            }
        }else{
            boolean result = ReasonsListener.checkIfAllReasonsAreSelected();
            if(result){
                ArrayList<String> correctReasonsList = ReasonsListener.getCorrectReasonsForIncorrectlySelectedReasons();
                int numberOfWrongReasonsSelected = ReasonsListener.getNumberOfIncorrectReasons(correctReasonsList);
                int score = ScoreComputation.calculateScore(numberOfWrongReasonsSelected, correctReasonsList.size(), "reasons");
                updatedScore +=score;
                optionsResponseView.displayScore(submitId.getScene(), updatedScore);
                closeWindow(event);
            }else{
                optionsResponseView.showPopupForSelectingAllReasons();
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (score == null) {
            score = "0";
        }
        writeScore(0);

        return Integer.parseInt(score);
    }

}
