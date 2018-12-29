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
    private Label ll;
    
    @FXML
    private void actionAddOwner(ActionEvent event) throws ParseException 
    {
        if(ne.getText().isEmpty()&&se.getText().isEmpty()&&as.getText().isEmpty()&&pl.getText().isEmpty())
        {
            ll.setText("Incorrect values");
        }
        else
        {
            name = ne.getText();
            surname = se.getText();
            pesel = parseLong(pl.getText());
            address = as.getText();
            
            insertOwner(pesel, name, surname, address);
            ll.setText("Inserted correctly");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
