package top;

import static dao.VehiclesDAO.*;
import entity.Vehicles;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static top.SessionHolder.*;

public class PLATESPromptController implements Initializable 
{
    @FXML
    private Label outInfo;
    @FXML
    private TextField inPlate;
    
    private String plates;
    
    @FXML
    private void actionCheckPlates(ActionEvent event) 
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
            //Save owner to custom session class
            
            setVehicle(vehicle);
            
            //Close search window & Open editor       
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
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
