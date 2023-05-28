package com.example.richslaves;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CannedController {
    @FXML
    private TableView<Products> tableCanned;

    @FXML
    private TableColumn<Products, Integer> idCanned;

    @FXML
    private TableColumn<Products, String> nameCanned;

    @FXML
    private TableColumn<Products, Integer> countCanned;

    @FXML
    private TableColumn<Products, Double> priceCanned;

    public void initialize() {

        idCanned.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        nameCanned.setCellValueFactory(cellData -> cellData.getValue().getName());
        countCanned.setCellValueFactory(cellData -> cellData.getValue().getCount().asObject());
        priceCanned.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());

        try {
            Connection connection = ConnectionMySQL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT ID, Name, Count, Price FROM Products WHERE TypeID = 2");

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCount(resultSet.getInt("Count"));
                product.setPrice(resultSet.getDouble("Price"));
                tableCanned.getItems().add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
