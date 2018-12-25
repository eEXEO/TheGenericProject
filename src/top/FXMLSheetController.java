package top;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class FXMLSheetController implements Initializable 
{
    @FXML
    private AnchorPane ap;
    
    @FXML
    private void vehicleNew(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("VehicleAdd.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void vehicleEdit(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("VehicleModify.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void vehicleDelete(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("VehicleRemove.fxml"));
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
        AnchorPane apx = FXMLLoader.load(getClass().getResource("OwnerModify.fxml"));
        ap.getChildren().setAll(apx);
    }
    
    @FXML
    private void ownerDelete(ActionEvent event) throws IOException 
    {
        AnchorPane apx = FXMLLoader.load(getClass().getResource("OwnerRemove.fxml"));
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
