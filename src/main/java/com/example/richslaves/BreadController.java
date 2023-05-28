package com.example.richslaves;

import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BreadController {
    @FXML
    private TableView<Products> tableBread;

    @FXML
    private TableColumn<Products, Integer> idBread;

    @FXML
    private TableColumn<Products, String> nameBread;

    @FXML
    private TableColumn<Products, Integer> countSBread;

    @FXML
    private TableColumn<Products, Double> priceBread;

    public void initialize() {

        idBread.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        nameBread.setCellValueFactory(cellData -> cellData.getValue().getName());
        countSBread.setCellValueFactory(cellData -> cellData.getValue().getCount().asObject());
        priceBread.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());

        try {
            Connection connection = ConnectionMySQL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT ID, Name, Count, Price FROM Products WHERE TypeID = 6");

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCount(resultSet.getInt("Count"));
                product.setPrice(resultSet.getDouble("Price"));
                tableBread.getItems().add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
