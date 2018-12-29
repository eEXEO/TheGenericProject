package top;

import static dao.OwnersDAO.*;
import entity.Owners;
import static java.lang.Long.parseLong;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static top.SessionHolder.getOwner;

public class OwnerModifyController implements Initializable {

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
    private void actionEditOwner(ActionEvent event) throws ParseException 
    {
        if(ne.getText().isEmpty()&&se.getText().isEmpty()&&as.getText().isEmpty())
        {
            ll.setText("Incorrect values");
        }
        else
        {
            name = ne.getText();
            surname = se.getText();
            pesel = parseLong(pl.getText());
            address = as.getText();
            
            editOwner(pesel, name, surname, address);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Owners owner = getOwner();
        
        ne.setText(owner.getName());
        se.setText(owner.getSurname());
        as.setText(owner.getAddress());
        pl.setText(Long.toString(owner.getPesel()));
    }    
    
}
