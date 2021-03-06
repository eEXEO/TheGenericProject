package top;

import entity.Owners;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static top.SessionHolder.*;

public class PESELPromptController implements Initializable 
{
    @FXML
    private TableView<Owners> tableView;
    @FXML
    private TableColumn<?, ?> pesel;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> surname;
    @FXML
    private TableColumn<?, ?> address;
    
    public void setTable()
    {
        pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));    
    }
    
    @FXML
    private void actionCheckPesel(ActionEvent event) 
    {
        Owners owner = tableView.getSelectionModel().getSelectedItem();
            setOwner(owner);
                 
            try 
            {
                AnchorPane ap = getAnchor();
                System.out.println("sdf");
                AnchorPane apx = FXMLLoader.load(getClass().getResource("OwnerModify.fxml"));
                ap.getChildren().setAll(apx);
                
            }
            catch (IOException e) 
            {
                System.out.println(e);
            }
        
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        setTable();
        tableView.setItems(dao.OwnersDAO.addTable());
    }    
    
}
