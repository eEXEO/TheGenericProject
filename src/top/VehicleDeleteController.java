package top;

import static dao.VehiclesDAO.*;
import entity.Vehicles;
import java.net.URL;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehicleDeleteController implements Initializable {

    @FXML
    private TableView<Vehicles> tableView;

    @FXML
    private TableColumn<?, ?> make;

    @FXML
    private TableColumn<?, ?> model;

    @FXML
    private TableColumn<?, ?> year;

    @FXML
    private TableColumn<?, ?> color;

    @FXML
    private TableColumn<?, ?> plates;


    public void setTable() {
        make.setCellValueFactory(new PropertyValueFactory<>("make"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        plates.setCellValueFactory(new PropertyValueFactory<>("plates"));
    }

    @FXML
    private void actionDeleteVehicle(ActionEvent event) throws ParseException 
    {

        if (tableView.getSelectionModel().getSelectedIndex() != -1) 
        {
            if (dao.WiwDAO.checkV(tableView.getSelectionModel().getSelectedItem().getIdve()) == true) 
            {
                deleteVehicle(tableView.getSelectionModel().getSelectedItem().getIdve());
                tableView.setItems(dao.VehiclesDAO.addToTable());
            } else 
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Warning");
                alert.setHeaderText("Are you sure to delete this vehicle");
                alert.setResizable(false);
                alert.setContentText("This vehicle has an owner");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) 
                {
                    Vehicles veh = tableView.getSelectionModel().getSelectedItem();
                    dao.VehiclesDAO.editVehicleOV(veh, false);
                    dao.WiwDAO.removeOV(veh.getIdve());
                    tableView.setItems(dao.VehiclesDAO.addToTable());
                    deleteVehicle(veh.getIdve());
                    tableView.setItems(dao.VehiclesDAO.addToTable());
                }
            }
        }
    }
        @Override
        public void initialize (URL url, ResourceBundle rb) 
        {
            setTable();
            tableView.setItems(dao.VehiclesDAO.addToTable());
        }

    }
