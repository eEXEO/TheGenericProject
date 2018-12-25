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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tomek
 */
public class LoginPromptController implements Initializable {

    @FXML
    private Label outInfo;
    @FXML
    private TextField inLogin;
    @FXML
    private TextField inPass;
    
    @FXML
    private void actionLogin(ActionEvent event) {
        System.out.println("LOGIN");
    }
    
    @FXML
    private void actionExit(ActionEvent event) {
        System.out.println("EXIT");
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
