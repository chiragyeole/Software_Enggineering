package eng.edu.ctrl;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import eng.edu.view.AssumptionsDisplayView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class EngEduMain extends Application {

    @FXML
    public ScrollPane scroll;
    @FXML
    private Button submitId;
    
    VBox vbox1;
    Button submitButton;
    AssumptionsDisplayView adv;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // load main form in to VBox (Root)
        VBox mainPane = (VBox) FXMLLoader.load( getClass().getResource("/eng/edu/view/main.fxml" ) );
        SplitPane split = (SplitPane)mainPane.getChildren().get(1);
        AnchorPane anchor = (AnchorPane) split.getItems().get(0);
        vbox1 = (VBox)anchor.getChildren().get(0);
        scroll = (ScrollPane) vbox1.getChildren().get(2);       
        submitButton = (Button)vbox1.getChildren().get(3);
        
        
        //get all the checkboxes
        adv = new AssumptionsDisplayView();
        adv.displayAssumptions();
      
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 20));
        
        
        //add these checkboxes to the vbox
        int i;
        for(i = 0; i < adv.checkBoxes.size(); i++){
            System.out.println("Iteration" + i);
            final HBox hbox = new HBox();
            vbox.getChildren().add(hbox);
            hbox.getChildren().addAll(adv.labels.get(i),adv.checkBoxes.get(i));
            
            //hbox.getChildren().clear();
        }
        //add vbox to scroll pane
        scroll.setContent(vbox);      
        
        
//        submitButton.setOnAction(new EventHandler<ActionEvent>() {
//        @Override public void handle(ActionEvent t) {
//        
//            
//        QuestionController questionController = new QuestionController();
//        ArrayList<String> incorrectAssumptionsList = questionController.verifyAnswer(submitId.getScene());
//
//        System.out.println(incorrectAssumptionsList.size());
//        System.out.println("handleSubmitButtonAction");
//        HashMap<String, ArrayList> assumptionReasonsMap = questionController.readAllReasonsFromFile();
//
//        if (!incorrectAssumptionsList.isEmpty()) {
//            try {
//                reasonPageController.getReasonsForIncorrectassumptions(incorrectAssumptionsList, assumptionReasonsMap);
//            } catch (Exception ex) {
//                Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//            
//            
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 10, 10, 20));    
//        
//        int i;
//        for(i = 0; i < adv.checkBoxes.size(); i++){
//            System.out.println("Iteration" + i);
//            
//            if(assumptionReasonsMap.keySet().contains(adv.checkBoxes.get(i).getText())){
//                RadioButton radioButton = new RadioButton("display me");
//                final VBox vbox1 = new VBox();
//                final HBox hbox = new HBox();
//                vbox.getChildren().addAll(hbox, vbox1);
//               
//                hbox.getChildren().addAll(adv.labels.get(i),adv.checkBoxes.get(i));
//                vbox1.getChildren().add(radioButton);
//                vbox1.setMargin(radioButton, new Insets(0, 0, 0, 50));
//                
//            }
//            else{
//                final HBox hbox = new HBox();
//                vbox.getChildren().add(hbox);
//                hbox.getChildren().addAll(adv.labels.get(i),adv.checkBoxes.get(i));
//            }
//            
//            //hbox.getChildren().clear();
//        }
//        
//        scroll.setContent(vbox); 
//      }
//    });
        
        
        //group the images and checkboxes together
        Group grp = new Group();
        grp.getChildren().addAll(mainPane, vbox);
        
        
        primaryStage.setTitle("Engineering Educators");
        primaryStage.setScene(new Scene(grp));     
        primaryStage.setMaximized(true);    // make the main form fit to the screen
        primaryStage.show(); 
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
