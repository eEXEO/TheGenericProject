/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Vehicles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 9
 */
public class ViewVehiclesController implements Initializable {

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

    @FXML
    private ComboBox comboBox;

    @FXML
    private TextField find;
    
    @FXML
    private Label ll;

    public void setTable() 
    {
        make.setCellValueFactory(new PropertyValueFactory<>("make"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        plates.setCellValueFactory(new PropertyValueFactory<>("plates"));
    }

    @FXML
    private void actionFindVehicle(ActionEvent event) 
    {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.getSelectionModel().clearSelection();
        int id = comboBox.getSelectionModel().getSelectedIndex();

        switch (id) 
        {
            case 0: 
            {
                for (int i = 0; i < tableView.getItems().size(); i++) 
                {
                    if (tableView.getItems().get(i).getMake().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty())
                    {
                        tableView.getSelectionModel().select(i);
                    }
                }
                break;
            }
            
            case 1: 
            {
                for (int i = 0; i < tableView.getItems().size(); i++) 
                {
                    if (tableView.getItems().get(i).getModel().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty())
                    {
                        tableView.getSelectionModel().select(i);
                    }
                }
                break;
            }
            
            case 2: 
            {
                for (int i = 0; i < tableView.getItems().size(); i++) 
                {
                    if (tableView.getItems().get(i).getYear().toString().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty())
                    {
                        tableView.getSelectionModel().select(i);
                    }
                }
                break;
            }
            
            case 3: 
            {
                for (int i = 0; i < tableView.getItems().size(); i++) 
                {
                    if (tableView.getItems().get(i).getColor().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty())
                    {
                        tableView.getSelectionModel().select(i);
                    }
                }
                break;
            }
            
            case 4: 
            {
                for (int i = 0; i < tableView.getItems().size(); i++) 
                {
                    if (tableView.getItems().get(i).getPlates().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty()) 
                    {
                        tableView.getSelectionModel().select(i);
                    }
                }
                break;
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        tableView.setItems(dao.VehiclesDAO.addToTable());
        comboBox.getItems().addAll("Make", "Model", "Year", "Color", "Plates");
        comboBox.setValue("Make");
        ll.setText("Find vehicle");

    }

}
