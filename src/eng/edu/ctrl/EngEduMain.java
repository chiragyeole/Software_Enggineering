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

import eng.edu.view.AssumptionsTableView;

public class EngEduMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // load main form in to VBox (Root)
        VBox mainPane = (VBox) FXMLLoader.load( getClass().getResource("/eng/edu/view/main.fxml" ) );
        
        primaryStage.setTitle("Engineering Educators");
        
        //assumptions are listed in table view
        AssumptionsTableView tbl = new AssumptionsTableView();
        tbl.createTable();
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(tbl.table);
        vbox.setPadding(new Insets(410, 10, 10, 10));
   
        Group grp = new Group();
        grp.getChildren().addAll(mainPane, vbox);
        
        primaryStage.setScene(new Scene(grp, 500, 250));
       
        primaryStage.setMaximized(false);    // make the main form fit to the screen
        primaryStage.show(); 
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
