/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.model;

import eng.edu.ctrl.AssumptionsDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author deeptichavan
 * 
 * This class reads the assumptions text file and stores them in a list,
 * which is then displayed from the AssumptionsTableView class
 */
public class AssumptionsTableModel {

    public String assumptionsTxt;
    public ObservableList<AssumptionsDAO> assumptionsList = FXCollections.observableArrayList();

    public AssumptionsTableModel() {

        String basePath = System.getProperty("user.home");
        assumptionsTxt = basePath + "/questions/assumptions1.txt";

        BufferedReader br;

        try {

            String currentLine;
            br = new BufferedReader(new FileReader(assumptionsTxt));

            while ((currentLine = br.readLine()) != null) {
                //text and result is spearated by a | in the .txt file
                String[] temp = currentLine.split("\\|");
                //get the assumption text
                String aTxt = temp[0].trim(); 
                //whether the assumption is correct or no
                //1 - correct and 0 - wrong
                int res = Integer.parseInt(temp[1].trim());     
                assumptionsList.add(new AssumptionsDAO(aTxt, res));
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
