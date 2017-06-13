

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
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author deeptichavan
 * 
 * This class populates the assumptions on the screen
 * assumptionsList has the list of assumptions which are read from the txt file
 */
public class AssumptionsTableView  {
    
    
    public  TableView<AssumptionsDAO> table = new TableView<AssumptionsDAO>();
    //public TextArea content = new TextArea("");
  
    private AssumptionsTableModel model = new AssumptionsTableModel();
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void createTable(){
        
         TableColumn chCol = new TableColumn("Checked");
         
         chCol.setCellValueFactory( new Callback<CellDataFeatures<AssumptionsDAO, CheckBox>, ObservableValue<CheckBox>>() {

             @Override
             public ObservableValue<CheckBox> call(
                     CellDataFeatures<AssumptionsDAO, CheckBox> arg0) {
                 AssumptionsDAO user = arg0.getValue();
                 CheckBox checkBox = new CheckBox();
                 /*
                 for (Long value : model.checkedMessages) {
                    if(value.intValue()==user.isCorrect ){
                        checkBox.selectedProperty().setValue(Boolean.TRUE);
                    }
                }*/
                 
                 
                 
                 return new SimpleObjectProperty<CheckBox>(checkBox);
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
    
         /*
         table.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                AssumptionsDAO a =   table.getSelectionModel().getSelectedItem();
                content.setText(a.getAssumption());
            }
            
            
        });
*/
    }

}

