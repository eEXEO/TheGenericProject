/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Owners;
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
public class ViewOwnersController implements Initializable {

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
    @FXML
    private ComboBox comboBox;
    @FXML
    private TextField find;
    @FXML
    private Label ll;

public void setTable()
    {
        pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    @FXML
    private void actionFindOwner(ActionEvent event) 
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
                    if (Long.toString(tableView.getItems().get(i).getPesel()).contains(find.getText()) && !find.getText().isEmpty())
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
                    if (tableView.getItems().get(i).getName().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty())
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
                    if (tableView.getItems().get(i).getSurname().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty()) 
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
                    if (tableView.getItems().get(i).getAddress().toLowerCase().contains(find.getText().toLowerCase()) && !find.getText().isEmpty())
                    {
                        tableView.getSelectionModel().select(i);
                    }
                }
                break;
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        setTable();
        tableView.setItems(dao.OwnersDAO.addTable());
        comboBox.getItems().addAll("Pesel", "Name", "Surname", "Address");
        comboBox.setValue("Pesel");
        ll.setText("Find owner");
    }

}
