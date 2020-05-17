package top;

import static dao.VehiclesDAO.*;
import entity.Vehicles;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static top.SessionHolder.getVehicle;

public class VehicleModifyController implements Initializable {

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
    private Label outInfo;
    
    @FXML
    private void actionEditVehicle(ActionEvent event) throws ParseException 
    {
        if(mk.getText().isEmpty() && ml.getText().isEmpty() && yr.getText().isEmpty() && cr.getText().isEmpty() && ps.getText().isEmpty())
        {
            outInfo.setText("Incorrect values");
        }
        else
        {
            make = mk.getText();
            model = ml.getText();
            year = yr.getText();
            color = cr.getText();
            plates = ps.getText();
            
            
            editVehicle(make, model, year, color, plates) ;
            outInfo.setText("Edited successfully");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Vehicles veh = getVehicle();
        
        mk.setText(veh.getMake());
        ml.setText(veh.getModel());
        cr.setText(veh.getColor());
        ps.setText(veh.getPlates());
        
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        yr.setText(df.format(veh.getYear()));
    }    
    
}
