package top;

import static dao.OwnersDAO.*;
import entity.Owners;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static top.SessionHolder.*;

public class PESELPromptController implements Initializable 
{
    @FXML
    private Label outInfo;
    @FXML
    private TextField inPesel;
    
    private String pesel;
    
    @FXML
    private void actionCheckPesel(ActionEvent event) 
    {
        //Get data from inputs
        
        pesel = inPesel.getText();
        
        //Check if pesel exist
        
        Owners owner = checkPesel(pesel);
        
        if(owner==null)
        {
            //~Exist
            outInfo.setText("Not Found");
        }
        else 
        {
            //Exist
            //Save owner to custom session class
            
            setOwner(owner);
            
            //Close search window & Open editor       
            try 
            {
                AnchorPane ap = getAnchor();
                
                AnchorPane apx = FXMLLoader.load(getClass().getResource("OwnerModify.fxml"));
                ap.getChildren().setAll(apx);
                
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
