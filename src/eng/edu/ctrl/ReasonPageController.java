/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import eng.edu.view.AssumptionsDisplayView;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.BufferedReader;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author deeptichavan
 */
public class ReasonPageController implements Initializable {

    ArrayList<String> correctReasons = new ArrayList<>();
    public static HashMap<Integer, String> selectedReasons = new HashMap<>();
    public String reasonsTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public ArrayList<String> verifyAnswer(Scene scene) {

        //get what options did the student select
        ArrayList<Integer> response = getStudentsResponse(scene);
        System.out.println("response :: " + response);
        
        String basePath = System.getProperty("user.home");
        File correctImg = new File(basePath + "/questions/correct.png");
        File wrongImg = new File(basePath + "/questions/cross.png");

        AssumptionsDisplayView atv = new AssumptionsDisplayView();

        //get the incorrect assumptions that the student selected
        ArrayList<String> incorrectResponse = new ArrayList<>();
        int i;
        for (i = 0; i < response.size(); i++) {
            String txt = atv.model.assumptionsList.get(response.get(i)).assumption;
            
            //verify against the correct result
            //response --> what student selected
            //assumptionList --> whether the selected option is right or no
            int res = atv.model.assumptionsList.get(response.get(i)).isCorrect;

            if (res == 0) {
                incorrectResponse.add(txt);
                displayOptionIcon(response.get(i), wrongImg.toURI().toString(), scene);
            } else {  
                displayOptionIcon(response.get(i), correctImg.toURI().toString(), scene);
            }
        }
        
        displayScore(incorrectResponse, scene, response);
        
        System.out.println("Incorrest list :: " + incorrectResponse);

        return incorrectResponse;
    }

    public void displayOptionIcon(int no, String img, Scene scene){
        
        String id = "#label" + no;
                Label lb = (Label) scene.lookup(id);
                lb.setVisible(true);
                ImageView iv = new ImageView(img);
                iv.setFitHeight(15);
                iv.setFitWidth(15);
                lb.setGraphic(iv);
    }
    
    public void displayScore(ArrayList<String> incorrectResponse, Scene scene, ArrayList<Integer> response){
        
        //dummy logic for score
        if (incorrectResponse.isEmpty()) {
            Label lb1 = (Label) scene.lookup("#score");
            lb1.setText("Score: 4");
        } else if (incorrectResponse.size() == response.size()) {
            Label lb1 = (Label) scene.lookup("#score");
            lb1.setText("Score: 0");
        } else {
            Label lb1 = (Label) scene.lookup("#score");
            lb1.setText("Score: 2");
        }
    }
    
    
    /*
    * get the option numbers that the student selected
     */
    public ArrayList<Integer> getStudentsResponse(Scene scene) {

        AssumptionsDisplayView atv = new AssumptionsDisplayView();

        ArrayList<Integer> response = new ArrayList<>();
        int listSize = atv.model.assumptionsList.size();

        int i;
        for (i = 0; i < listSize; i++) {
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox) scene.lookup(id);

            if (cb.isSelected()) {
                response.add(i);
            }

        }

        System.out.println("Student's response :: " + response);
        return response;
    }

    public HashMap readAllReasonsFromFile() {
        System.out.println("deepti");

        String basePath = System.getProperty("user.home");
        reasonsTxt = basePath + "/questions/reasons.txt";

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        HashMap<String, ArrayList> assumptionsReasonsMap = new HashMap<String, ArrayList>();

        String currentAssumption = new String();

        try {

            fileReader = new FileReader(reasonsTxt);
            bufferedReader = new BufferedReader(fileReader);
            String CurrentLine;

            System.out.println(reasonsTxt);
            bufferedReader = new BufferedReader(new FileReader(reasonsTxt));
            int count = 0;

            while ((CurrentLine = bufferedReader.readLine()) != null) {

                System.out.println(CurrentLine);
                ArrayList<String> reasons = new ArrayList<>();
                if (count % 2 == 0) {
                    currentAssumption = CurrentLine;
                } else {
                    boolean flag = false;
                    String[] temp = null;

                    if (CurrentLine.contains(";")) {
                        temp = CurrentLine.split(";");
                    } else {
                        flag = true;
                    }

                    if (flag == true) {
                        String lastReason = CurrentLine;
                        String temp1[] = lastReason.split("\\|");
                        correctReasons.add(temp1[1]);
                        reasons.add(temp1[0]);
                    } else {
                        for (int i = 0; i < temp.length; i++) {
                            if (i == temp.length - 1) {
                                String lastReason = temp[i];
                                String temp1[] = lastReason.split("\\|");
                                correctReasons.add(temp1[1]);
                                reasons.add(temp1[0]);
                            } else {
                                reasons.add(temp[i]);
                            }
                        }
                    }

                    assumptionsReasonsMap.put(currentAssumption, reasons);
                }
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return assumptionsReasonsMap;
    }

    public void getReasonsForIncorrectassumptions(ArrayList<String> incorrectAssumptionsList, HashMap<String, ArrayList> assumptionReasonsMap) throws Exception {

        ArrayList<GridPane> gridPaneList = new ArrayList<>();
        ArrayList<ToggleGroup> toggleGroupList = new ArrayList<>();
        for (int i = 0; i < incorrectAssumptionsList.size(); i++) {
            GridPane gridPane = new GridPane();
            Label currentIncorrectAssumption = new Label(incorrectAssumptionsList.get(i));
            ArrayList<String> reasons = assumptionReasonsMap.get(incorrectAssumptionsList.get(i));
            gridPane.add(currentIncorrectAssumption, 0, 0);

            final ToggleGroup group = new ToggleGroup();

            for (int j = 0; j < reasons.size(); j++) {
                RadioButton radiobutton = new RadioButton(reasons.get(j));
                radiobutton.setUserData(reasons.get(j));
                radiobutton.setToggleGroup(group);
                gridPane.add(radiobutton, 0, j + 1);
            }
            gridPaneList.add(gridPane);
            toggleGroupList.add(group);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/eng/edu/view/ReasonPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Reasons Page");

        Group grp = new Group();
        grp.getChildren().add(root1);
        VBox vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(25, 5, 5, 20));
        for (int i = 0; i < gridPaneList.size(); i++) {
            vBox.getChildren().add(gridPaneList.get(i));
        }

        grp.getChildren().add(vBox);

        stage.setScene(new Scene(grp));
        stage.show();

        for (int i = 0; i < toggleGroupList.size(); i++) {
            ToggleGroup group = toggleGroupList.get(i);
            group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
                if (group.getSelectedToggle() != null) {
                    String selectedReason = group.getSelectedToggle().getUserData().toString();
                    int groupNumber = toggleGroupList.indexOf(group);
                    selectedReasons.put(groupNumber, selectedReason);
                }
            });

        }

        System.out.println("map size here " + selectedReasons.size());
    }

    public void checkValidReasons(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    public void verifySelectedReasons(ArrayList<String> correctReasons) {
        for (int i = 0; i < selectedReasons.size(); i++) {
            System.out.println("hii " + selectedReasons.get(0));
            if (selectedReasons.keySet().contains(i)) {
                String selectedReason = selectedReasons.get(i);
                String correspondingCorrectReason = correctReasons.get(i);
                if (selectedReason.equals(correspondingCorrectReason)) {
                    System.out.println("correct");
                } else {
                    System.out.println("incorrect");
                }
            }
        }
    }

}
