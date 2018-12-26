package top;

import static dao.VehiclesDAO.*;
import entity.Vehicles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VehicleDeleteController implements Initializable 
{
    @FXML
    private Label outInfo;
    @FXML
    private TextField inPlate;
    
    private String plates;
    
    @FXML
    private void actionDeleteVehicle(ActionEvent event) 
    {
        //Get data from inputs
        
        plates = inPlate.getText();
        
        //Check if pesel exist
        
        Vehicles vehicle = checkPlates(plates);
        
        if(vehicle==null)
        {
            //~Exist
            outInfo.setText("Not Found");
        }
        else 
        {
            //Exist
            //Delete
            
            deleteVehicle(plates);
            outInfo.setText("Removed succesfully");
            
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
