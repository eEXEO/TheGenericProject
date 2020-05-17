package top;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static dao.OwnersDAO.*;
import static java.lang.Long.parseLong;
import java.text.ParseException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OwnerAddController implements Initializable 
{
    private String name;
    private String surname;
    private String address;
    private long pesel;
    
    @FXML
    private TextField ne;
    @FXML
    private TextField se;
    @FXML
    private TextField as;
    @FXML
    private TextField pl;
    @FXML
    private Label outInfo;
    
    @FXML
    private void actionAddOwner(ActionEvent event) throws ParseException 
    {
        if(ne.getText().isEmpty() || se.getText().isEmpty() || as.getText().isEmpty() || pl.getText().isEmpty() || !pl.getText().matches("[0-9]+") || pl.getText().length() != 11)
        {
            outInfo.setText("Incorrect values");
        }
        else if(dao.OwnersDAO.checkPesel(pl.getText()) != null)
        {
            outInfo.setText("Inserted PESEL exist in database");
        }
        else
        {
            name = ne.getText();
            surname = se.getText();
            pesel = parseLong(pl.getText());
            address = as.getText();
            
            insertOwner(pesel, name, surname, address);
            outInfo.setText("Inserted correctly");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
}
