package top;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static dao.VehiclesDAO.*;
import java.text.ParseException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VehicleAddController implements Initializable 
{
    private String make;
    private String model;
    private String year;
    private String color;
    private String plates;
    
    @FXML
    private TextField mk;
    @FXML
    private TextField ml;
    @FXML
    private TextField yr;
    @FXML
    private TextField cr;
    @FXML
    private TextField ps;
    
    @FXML
    private Label ll;
    
    @FXML
    private void actionAddVehicle(ActionEvent event) throws ParseException 
    {
        if(mk.getText().isEmpty()&&ml.getText().isEmpty()&&yr.getText().isEmpty()&&cr.getText().isEmpty()&&ps.getText().isEmpty())
        {
            ll.setText("Incorrect values");
        }
        else
        {
            make = mk.getText();
            model = ml.getText();
            year = yr.getText();
            color = cr.getText();
            plates = ps.getText();
            
            insertVehicle(make, model, year, color, plates);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
