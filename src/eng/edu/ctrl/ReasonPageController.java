/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import static eng.edu.utilities.Utilities.baseDirectory;
import static eng.edu.utilities.Utilities.basePath;
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

/**
 * FXML Controller class
 *
 * @author deeptichavan
 */
public class ReasonPageController implements Initializable {

    ArrayList<String> correctReasons = new ArrayList<>();
    public static HashMap<Integer, String> selectedReasons = new HashMap<>();
    public String reasonsTxt;
    public static ArrayList<Integer> response;
    public static int aaumptionListSize;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public ArrayList<String> verifyAnswer(Scene scene) {

        //get what options did the student select
        response = getStudentsResponse(scene);
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

//        ReasonPageController reasonPageController = new ReasonPageController();
//        reasonPageController.incorrectResponse = incorrectResponse;
//        reasonPageController.numberOfResponse = response.size();
        return incorrectResponse;
    }

    public void displayOptionIcon(int no, String img, Scene scene) {

        String id = "#label" + no;
        Label lb = (Label) scene.lookup(id);
        lb.setVisible(true);
        ImageView iv = new ImageView(img);
        iv.setFitHeight(15);
        iv.setFitWidth(15);
        lb.setGraphic(iv);
    }

    public void displayScore(ArrayList<String> incorrectResponse, Scene scene, ArrayList<Integer> response) {

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
        aaumptionListSize = atv.model.assumptionsList.size();

        int i;
        for (i = 0; i < aaumptionListSize; i++) {
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox) scene.lookup(id);

            if (cb.isSelected()) {
                response.add(i);
            }

        }

        System.out.println("Student's response :: " + response);
        return response;
    }

    public BufferedReader getFileReader() {
        BufferedReader bufferedReader = null;
        try {

            int n1 = QuestionController.n;
            System.out.println("n1: " + n1);
            File file = new File(basePath + baseDirectory + "q" + n1 + "/" + "reasons" + n1 + ".txt");
            reasonsTxt = file.toURI().toString();
            String[] split = reasonsTxt.split("file:");
            reasonsTxt = split[1];

            bufferedReader = new BufferedReader(new FileReader(reasonsTxt));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return bufferedReader;
    }

    public HashMap readAllReasonsFromFile(BufferedReader bufferedReader) {
        HashMap<String, ArrayList> assumptionsReasonsMap = new HashMap<String, ArrayList>();
        try {
            String currentAssumption = new String();
            String CurrentLine;
            int count = 0;
            while ((CurrentLine = bufferedReader.readLine()) != null) {
                ArrayList<String> reasons = new ArrayList<>();
                if (count % 2 == 0) {
                    currentAssumption = CurrentLine;
                } else {
                    String[] temp = {CurrentLine};
                    if (CurrentLine.contains(";")) {
                        temp = CurrentLine.split(";");
                    }

                    for (int i = 0; i < temp.length; i++) {
                        if (temp[i].contains("\\|")) {
                            String lastReason = temp[i];
                            String temp1[] = lastReason.split("\\|");
                            correctReasons.add(temp1[1]);
                            reasons.add(temp1[0]);
                        } else {
                            reasons.add(temp[i]);
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

}
