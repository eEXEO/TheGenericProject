/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import entity.Vehicles;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 9
 */
public class RemoveOVController implements Initializable {

@FXML
    private TableView<Vehicles> tableView;
    
    @FXML
    private TableColumn<?, ?> make;
        
    @FXML
    private TableColumn<?, ?> model;
            
    @FXML
    private TableColumn<?, ?> year;
                
    @FXML
    private TableColumn<?, ?> color;
                    
    @FXML
    private TableColumn<?, ?> plates;
    
    @FXML
    private TableColumn<?, ?> hasOwner;
    
    @FXML
    private Label ll;

public void setTable()
    {
        make.setCellValueFactory(new PropertyValueFactory<>("make"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        plates.setCellValueFactory(new PropertyValueFactory<>("plates"));
        hasOwner.setCellValueFactory(new PropertyValueFactory<>("hasOwner"));
    }


    @FXML
    private void actionRemoveOV(ActionEvent event) throws ParseException 
    {
        if(tableView.getSelectionModel().getSelectedIndex() > -1)
        {
        dao.VehiclesDAO.editVehicleOV(tableView.getSelectionModel().getSelectedItem(), false);
        dao.WiwDAO.removeOV(tableView.getSelectionModel().getSelectedItem().getIdve());
        tableView.setItems(dao.VehiclesDAO.addToTable());
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        setTable();
        tableView.setItems(dao.VehiclesDAO.addToTable());
        ll.setText("Remove vehicle owner");
    }  
       
    
}
