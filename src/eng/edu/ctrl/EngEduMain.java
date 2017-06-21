package eng.edu.ctrl;

import eng.edu.model.AssumptionsDisplayModel;
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

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    
    AssumptionsDisplayModel adm;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // load main form in to VBox (Root)
        VBox mainPane = (VBox) FXMLLoader.load(getClass().getResource("/eng/edu/view/main.fxml"));
        SplitPane split = (SplitPane) mainPane.getChildren().get(1);
        AnchorPane anchor = (AnchorPane) split.getItems().get(0);
        vbox1 = (VBox) anchor.getChildren().get(0);
        scroll = (ScrollPane) vbox1.getChildren().get(2);
        //submitButton = (Button) vbox1.getChildren().get(3);
        //get all the checkboxes
        adm = new AssumptionsDisplayModel();
        adm.assignAssumptionsToCheckBoxes();
        adm.assignLablesToAssumptions();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 20));

        //add these checkboxes to the vbox
        int i;
        for (i = 0; i < adm.checkBoxes.size(); i++) {
            System.out.println("Iteration" + i);
            final HBox hbox = new HBox();
            vbox.getChildren().add(hbox);
            hbox.getChildren().addAll(adm.labels.get(i), adm.checkBoxes.get(i));
        }
        //add vbox to scroll pane
        scroll.setContent(vbox);

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
