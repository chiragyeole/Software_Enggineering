/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import eng.edu.model.AssumptionsDisplayModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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

    public ReasonPageController(){
        
    }
    
    public ReasonPageController(Scene scene){
        response = getStudentsResponse(scene);
    }
    
    public ArrayList<String> getIncorrectSelectedAssumption() {

        
        AssumptionsDisplayModel adm = new AssumptionsDisplayModel();

        //get the incorrect assumptions that the student selected
        ArrayList<String> incorrectSelectedResponse = new ArrayList<>();
        int i;
        for (i = 0; i < response.size(); i++) {
            String txt = adm.assumptionsList.get(response.get(i)).getAssumption();

            //verify against the correct result
            boolean res = adm.assumptionsList.get(response.get(i)).getIsCorrect();
                        
            if (res == false) {
                incorrectSelectedResponse.add(txt);
            } 
        }
        
        return incorrectSelectedResponse;
    }

    

    

    /*
    * get the option numbers that the student selected
     */
    public ArrayList<Integer> getStudentsResponse(Scene scene) {

        AssumptionsDisplayModel adm = new AssumptionsDisplayModel();

        ArrayList<Integer> response = new ArrayList<>();
        aaumptionListSize = adm.assumptionsList.size();

        int i;
        for (i = 0; i < aaumptionListSize; i++) {
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox) scene.lookup(id);

            if (cb.isSelected()) {
                response.add(i);
            }

        }

        return response;
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
                        if (temp[i].contains("|")) {
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
