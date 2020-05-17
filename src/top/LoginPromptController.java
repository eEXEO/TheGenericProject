package top;

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
import javafx.stage.Stage;

import static dao.OfficialsDAO.*;
import static top.SessionHolder.*;
import entity.Officials;
import javafx.scene.control.PasswordField;

public class LoginPromptController implements Initializable 
{

    @FXML
    private Label outInfo;
    @FXML
    private PasswordField inPass;
    @FXML
    private TextField inLogin;
    
    private String login;
    private String pass;
    
    @FXML
    private void actionLogin(ActionEvent event) 
    {
        login = inLogin.getText();
        pass = inPass.getText();

        Officials user = officialLogin(pass, login);
        
        if(user == null)
        {
            outInfo.setText("Incorrect login credentials");
        }
        else 
        {
            setServant(user);
       
            try 
            {
                FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("FXMLSheet.fxml"));
                Parent root1 = (Parent)fxmlloader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                stage.setResizable(false);
                stage.setTitle("Vehicles");
                stage.setResizable(false);
                stage = (Stage) outInfo.getScene().getWindow();
                stage.close();
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
       
    }
    
    @FXML
    private void actionExit(ActionEvent event) 
    {
        System.exit(1);
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
