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


import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class EngEduMain extends Application {

    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
       Parent root = FXMLLoader.load(getClass().getResource("/eng/edu/view/WelcomePage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        //stage.setMaximized(true);
        //stage.setFullScreen(true);
        stage.setTitle("Engineering Educators");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
