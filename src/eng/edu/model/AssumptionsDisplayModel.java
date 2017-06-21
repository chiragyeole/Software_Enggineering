/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.model;

import eng.edu.utilities.Utilities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author deeptichavan
 *
 * This class reads the assumptions text file and stores them in a list, which
 * is then displayed from the AssumptionsTableView class
 */
public class AssumptionsDisplayModel {

    public String assumptionsTxt;
    public ObservableList<AssumptionsDAO> assumptionsList = FXCollections.observableArrayList();

    public AssumptionsDisplayModel() {

        assumptionsTxt = Utilities.assumptionsTxt;
        String[] split = assumptionsTxt.split("file:");
        assumptionsTxt = split[1];

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
                //true - correct and false - wrong
                boolean res;
                if ("true".equalsIgnoreCase(temp[1].trim())) {
                    res = true;
                } else {
                    res = false;
                }
                assumptionsList.add(new AssumptionsDAO(aTxt, res));
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
