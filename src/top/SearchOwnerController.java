/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Owners;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static top.SessionHolder.getAnchor;

/**
 * FXML Controller class
 *
 * @author 9
 */
public class SearchOwnerController implements Initializable {

     @FXML
    private TableView<Owners> tableView;
    @FXML
    private TableColumn<?, ?> pesel;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> surname;
    @FXML
    private TableColumn<?, ?> address;


public void setTable()
    {
        pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));    
    }
    
    
    
    
    @FXML
    private void actionCreateOV(ActionEvent event) throws ParseException
    {
        if(SessionHolder.getVehicle().getHasOwner() == false && tableView.getSelectionModel().getSelectedIndex() != -1)
        {
        dao.WiwDAO.insertOV(SessionHolder.getVehicle().getIdve(), tableView.getSelectionModel().getSelectedItem().getIdow());
        dao.VehiclesDAO.editVehicleOV(SessionHolder.getVehicle(), true);
        
        
                         
            try 
            {
                AnchorPane ap = getAnchor();
                AnchorPane apx = FXMLLoader.load(getClass().getResource("ConnectOV.fxml"));
                ap.getChildren().setAll(apx);
                
            }
            catch (IOException e) 
            {
                System.out.println(e);
            }
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        setTable();
        tableView.setItems(dao.OwnersDAO.addTable());

    }    
    
}
