/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static dao.WiwDAO.*;

/**
 * FXML Controller class
 *
 * @author Tomek
 */
public class RemoveOVController implements Initializable {

    private String plate;
    private String pesel;
    
    @FXML
    private TextField pl;
    @FXML
    private TextField ps;
    @FXML
    private Label ll;
    
    @FXML
    private void actionOVC(ActionEvent event) throws ParseException 
    {
        if(pl.getText().isEmpty()&&ps.getText().isEmpty())
        {
            ll.setText("Incorrect values");
        }
        else
        {
            plate = pl.getText();
            pesel = ps.getText();
            
            if(removeOV(plate, pesel))
            {
                ll.setText("Success");
            }else
            {
                ll.setText("Something went wrong");
            }
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
