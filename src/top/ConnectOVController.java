/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import entity.Vehicles;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
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
public class ConnectOVController implements Initializable 
{
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
    @FXML
    private Label outInfo;
    
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
    private void actionOVC(ActionEvent event)
   {
        if(tableView.getSelectionModel().getSelectedIndex() == -1)
        {
            
        }
        else if(tableView.getSelectionModel().getSelectedItem().getHasOwner() == true)
        {
            outInfo.setText("Selected vehicle has owner");
        }
        else
        {
            try 
            {
                SessionHolder.setVehicle(tableView.getSelectionModel().getSelectedItem());
                AnchorPane ap = getAnchor();
                
                AnchorPane apx = FXMLLoader.load(getClass().getResource("SearchOwner.fxml"));
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
        tableView.setItems(dao.VehiclesDAO.addToTable());
        ll.setText("Add owner to vehicle");
    }    
    
}
