/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import static dao.OwnersDAO.deleteOwner;
import dao.VehiclesDAO;
import dao.WiwDAO;
import entity.Owners;
import entity.Wiw;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 9
 */
public class OwnerDeleteController implements Initializable 
{

    @FXML
    private Label ll;
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
    private void actionDeleteOwner(ActionEvent event) throws ParseException 
    {

        if (tableView.getSelectionModel().getSelectedIndex() != -1) 
        {
            List<Wiw> list = WiwDAO.checkOwn(tableView.getSelectionModel().getSelectedItem().getIdow());
            Owners own = tableView.getSelectionModel().getSelectedItem();
            if (list.isEmpty()) 
            {
                deleteOwner(tableView.getSelectionModel().getSelectedItem().getIdow());
                tableView.setItems(dao.OwnersDAO.addTable());
            } else 
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Warning");
                alert.setHeaderText("Are you sure to delete this owner");
                alert.setResizable(false);
                alert.setContentText("This owner has vehicle");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) 
                {
                    
                    for (int i = 0; i < list.size(); i++) 
                    {
                        WiwDAO.removeOV(list.get(i).getVid());
                        dao.VehiclesDAO.editVehicleOV(VehiclesDAO.checkId(list.get(i).getVid()), false);
                    }
                    deleteOwner(own.getIdow());
                    tableView.setItems(dao.OwnersDAO.addTable());
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        tableView.setItems(dao.OwnersDAO.addTable());
        ll.setText("Select owner to delete");
    }

}
