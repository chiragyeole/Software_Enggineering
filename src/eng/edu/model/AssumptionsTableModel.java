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

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(assumptionsTxt);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(assumptionsTxt));

            while ((sCurrentLine = br.readLine()) != null) {
                assumptionsList.add(new AssumptionsDAO(sCurrentLine, 1));
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
