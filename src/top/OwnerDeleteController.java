/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import static dao.OwnersDAO.*;
import entity.Owners;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static top.SessionHolder.setVehicle;

/**
 * FXML Controller class
 *
 * @author Tomek
 */
public class OwnerDeleteController implements Initializable {

    @FXML
    private Label outInfo;
    @FXML
    private TextField inPesel;
    
    private String pesel;
    
    @FXML
    private void actionDeleteOwner(ActionEvent event) 
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
            //Delete
            
            deleteOwner(pesel);
            outInfo.setText("Removed succesfully");
            
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
