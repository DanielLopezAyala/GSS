package com.example.richslaves;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MeatController {
    @FXML
    private TableView<Products> tableMeat;

    @FXML
    private TableColumn<Products, Integer> idMeat;

    @FXML
    private TableColumn<Products, String> nameMeat;

    @FXML
    private TableColumn<Products, Integer> countSMeat;

    @FXML
    private TableColumn<Products, Double> priceMeat;

    public void initialize() {

        idMeat.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        nameMeat.setCellValueFactory(cellData -> cellData.getValue().getName());
        countSMeat.setCellValueFactory(cellData -> cellData.getValue().getCount().asObject());
        priceMeat.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());

        try {
            Connection connection = ConnectionMySQL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT ID, Name, Count, Price FROM Products WHERE TypeID = 3");

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCount(resultSet.getInt("Count"));
                product.setPrice(resultSet.getDouble("Price"));
                tableMeat.getItems().add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
