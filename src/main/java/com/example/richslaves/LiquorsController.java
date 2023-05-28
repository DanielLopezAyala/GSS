package com.example.richslaves;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LiquorsController {
    @FXML
    private TableView<Products> tableLiquors;

    @FXML
    private TableColumn<Products, Integer> idLiquors;

    @FXML
    private TableColumn<Products, String> nameLiquors;

    @FXML
    private TableColumn<Products, Integer> countLiquors;

    @FXML
    private TableColumn<Products, Double> priceLiquors;

    public void initialize() {
        idLiquors.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        nameLiquors.setCellValueFactory(cellData -> cellData.getValue().getName());
        countLiquors.setCellValueFactory(cellData -> cellData.getValue().getCount().asObject());
        priceLiquors.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());

        try {
            Connection connection = ConnectionMySQL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT ID, Name, Count, Price FROM Products WHERE TypeID = 4");

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCount(resultSet.getInt("Count"));
                product.setPrice(resultSet.getDouble("Price"));
                tableLiquors.getItems().add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
