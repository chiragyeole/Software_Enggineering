/**
 * This class displays the real world and idealized model images
 */

package eng.edu.ctrl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class QuestionController {

    @FXML
    private Button submitId;

    @FXML
    private Button openFrm2;

    @FXML
    private Button openFrm3;

    @FXML
    private VBox dataPane;
    
    @FXML
    private ImageView realWorldImage ;

  
    @FXML
    private ImageView idealizedImage;
    
    public void initialize() throws MalformedURLException { 
        
        /*
        * real world image stored in users home location is displayed from here.
        */
        String basePath = System.getProperty("user.home");
        File fileReal = new File(basePath + "/questions/RealWorld1.png");
        System.out.println(fileReal.toURI().toString());
        Image imageReal = new Image(fileReal.toURI().toString());        
        realWorldImage.setImage(imageReal);
        
        
        /*
        * Idealized model image stored in users home location is displayed from here.
        */
        File fileIdeal = new File(basePath + "/questions/IdealizedModel1.png");
        System.out.println(fileIdeal.toURI().toString());
        Image imageIdeal = new Image(fileIdeal.toURI().toString());        
        idealizedImage.setImage(imageIdeal);

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
    
     @FXML protected void handleSubmitButtonAction(ActionEvent event) {
       //actiontarget.setText("Sign in button pressed");
       ReasonPageController reasonPageController = new ReasonPageController();
       reasonPageController.verifyAnswer(submitId.getScene());
   }

}  
