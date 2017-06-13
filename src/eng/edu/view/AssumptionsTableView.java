

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;

import eng.edu.ctrl.AssumptionsDAO;
import eng.edu.model.AssumptionsTableModel;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author deeptichavan
 * 
 * This class populates the assumptions on the screen
 * assumptionsList has the list of assumptions which are read from the .txt file
 */
public class AssumptionsTableView  {
    
    
    public  TableView<AssumptionsDAO> table = new TableView<AssumptionsDAO>();
    //public TextArea content = new TextArea("");
  
    public AssumptionsTableModel model = new AssumptionsTableModel();
    
    public TableColumn chCol = new TableColumn("Checked");
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void createTable(){
      
         chCol.setCellValueFactory( new Callback<CellDataFeatures<AssumptionsDAO, CheckBox>, ObservableValue<CheckBox>>() {

             @Override
             public ObservableValue<CheckBox> call(CellDataFeatures<AssumptionsDAO, CheckBox> arg0) {
                 CheckBox checkBox = new CheckBox();
                
                 return new SimpleObjectProperty<>(checkBox);
             }
         
         
         });
  
         TableColumn assumption = new TableColumn("assumption");
         assumption.setCellValueFactory(
             new PropertyValueFactory<AssumptionsDAO,String>("assumption")
         );
  
         table.setItems(model.assumptionsList);
         table.getColumns().addAll(chCol,assumption);
         table.setPrefHeight(200);
         table.setPrefWidth(500);
         table.setTableMenuButtonVisible(true);
         table.setId("assumptionsTable");
         table.getSelectionModel().setSelectionMode(
            SelectionMode.MULTIPLE
            );
    }
}

