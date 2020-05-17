package top;

import entity.Vehicles;
import java.io.IOException;
import java.net.URL;
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
import static top.SessionHolder.*;

public class PLATESPromptController implements Initializable 
{
    @FXML
    private Label outInfo;
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

                        

public void setTable()
    {
        make.setCellValueFactory(new PropertyValueFactory<>("make"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        plates.setCellValueFactory(new PropertyValueFactory<>("plates"));
    }  
    
    @FXML
    private void actionCheckPlates(ActionEvent event) 
    {

        
        Vehicles vehicle = tableView.getSelectionModel().getSelectedItem();
        

            setVehicle(vehicle);
     
            try 
            {
                AnchorPane ap = getAnchor();
                
                AnchorPane apx = FXMLLoader.load(getClass().getResource("VehicleModify.fxml"));
                ap.getChildren().setAll(apx);
                
            }
            catch (IOException e) 
            {
                System.out.println(e);
            }
        
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        tableView.setItems(dao.VehiclesDAO.addToTable());
    }    
    
}
