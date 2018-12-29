package top;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import static top.SessionHolder.*;

public class FXMLSheetController implements Initializable 
{
    @FXML
    private AnchorPane ap;
    
    @FXML
    private Label labelx;
    @FXML
    private Label labely;
    
    @FXML
    private void vehicleNew(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("VehicleAdd.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void vehicleEdit(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("PLATESPrompt.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void vehicleDelete(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("VehicleDelete.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void ownerNew(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("OwnerAdd.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void ownerEdit(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("PESELPrompt.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void ownerDelete(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("OwnerDelete.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void viewPESEL(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("ViewPESEL.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void viewPLATES(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("ViewPLATES.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void connectOV(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("ConnectOV.fxml"));
        ap.getChildren().setAll(apx);
    }
    @FXML
    private void removeOV(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("RemoveOV.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        setAnchor(ap);
        String name = getServant().getName();
        String surname = getServant().getSurname();
        String fn = getServant().getFunction();
        
        labelx.setText("Welcome back "+name+" "+surname);
        labely.setText("Your current status is: "+fn);
    }    
    
}
