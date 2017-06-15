/**
 * This class displays the real world and idealized model images
 */
package eng.edu.ctrl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionController {

    @FXML
    private Button submitId;

    @FXML
    private VBox dataPane;

    @FXML
    private ImageView realWorldImage;

    @FXML
    private ImageView idealizedImage;

    public static int n;

    public void initialize() throws MalformedURLException {

        Random rand = new Random();
        n = rand.nextInt(2) + 1;

        /*
        * real world image stored in users home location is displayed from here.
         */
        String path = getPath("RealWorld", n, ".png");
        Image imageReal = new Image(path);
        realWorldImage.setImage(imageReal);

        /*
        * Idealized model image stored in users home location is displayed from here.
         */
        path = getPath("IdealizedModel", n, ".png");
        Image imageIdeal = new Image(path);
        idealizedImage.setImage(imageIdeal);

    }

    public String getPath(String imageType, int number, String fileType) {

        String basePath = System.getProperty("user.home");
        File file = new File(basePath + "/questions/" + imageType + number + fileType);

        return file.toURI().toString();
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

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        //actiontarget.setText("Sign in button pressed");
        ReasonPageController reasonPageController = new ReasonPageController();
        ArrayList<String> incorrectAssumptionsList = reasonPageController.verifyAnswer(submitId.getScene());

        System.out.println("handleSubmitButtonAction");
        HashMap<String, ArrayList> assumptionReasonsMap = reasonPageController.readAllReasonsFromFile();

        if (!incorrectAssumptionsList.isEmpty()) {
            try {
                reasonPageController.getReasonsForIncorrectassumptions(incorrectAssumptionsList, assumptionReasonsMap);
            } catch (Exception ex) {
                Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
