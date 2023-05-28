package com.example.richslaves;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SnacksController {
    @FXML
    private TableView<Products> tableSnacks;

    @FXML
    private TableColumn<Products, Integer> idSnacks;

    @FXML
    private TableColumn<Products, String> nameSnacks;

    @FXML
    private TableColumn<Products, Integer> countSnacks;

    @FXML
    private TableColumn<Products, Double> priceSnacks;

    public void initialize() {

        idSnacks.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        nameSnacks.setCellValueFactory(cellData -> cellData.getValue().getName());
        countSnacks.setCellValueFactory(cellData -> cellData.getValue().getCount().asObject());
        priceSnacks.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());

        try {
            Connection connection = ConnectionMySQL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT ID, Name, Count, Price FROM Products WHERE TypeID = 5");

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCount(resultSet.getInt("Count"));
                product.setPrice(resultSet.getDouble("Price"));
                tableSnacks.getItems().add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
