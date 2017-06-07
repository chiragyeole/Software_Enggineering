package samplefx.ctrl;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MainController {

    @FXML
    private Button btnMenuBar;

    @FXML
    private Button openFrm2;

    @FXML
    private Button openFrm3;

    @FXML
    private VBox dataPane;

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
    public void reasonPage(ActionEvent event){
    
        
        try {
            System.out.println("Displayv Reasons");
             Parent root1 = FXMLLoader.load(getClass().getResource("/samplefx/view/ReasonPage.fxml"));
            
            Stage stage = new Stage();
            //stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Reasons");
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
