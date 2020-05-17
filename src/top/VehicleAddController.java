package top;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static dao.VehiclesDAO.*;
import java.text.ParseException;
import javafx.scene.control.DatePicker;
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
    private DatePicker yr;
    @FXML
    private TextField cr;
    @FXML
    private TextField ps;
    @FXML
    private Label outInfo;
    
    @FXML
    private void actionAddVehicle(ActionEvent event) throws ParseException 
    {
        if(mk.getText().isEmpty() || ml.getText().isEmpty() || yr.getValue() == null || cr.getText().isEmpty() || ps.getText().isEmpty())
        {
            outInfo.setText("Incorrect values");
        }
        else if(dao.VehiclesDAO.checkPlates(ps.getText()) != null)
        {
            outInfo.setText("Inserted plates exist in database");
        }
        else
        {
            make = mk.getText();
            model = ml.getText();
            year = yr.getValue().toString();
            color = cr.getText();
            plates = ps.getText();
            
            insertVehicle(make, model, year, color, plates);
            outInfo.setText("Inserted correctly");  
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}
