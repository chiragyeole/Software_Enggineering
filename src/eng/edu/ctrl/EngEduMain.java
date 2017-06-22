package eng.edu.ctrl;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.scene.Parent;
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
