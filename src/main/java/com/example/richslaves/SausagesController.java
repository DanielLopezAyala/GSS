package com.example.richslaves;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SausagesController {

    @FXML
    private TableView<Products> tableSausages;

    @FXML
    private TableColumn<Products, Integer> idSausages;

    @FXML
    private TableColumn<Products, String> nameSausages;

    @FXML
    private TableColumn<Products, Integer> countSausages;

    @FXML
    private TableColumn<Products, Double> priceSausages;

    public void initialize() {

        idSausages.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        nameSausages.setCellValueFactory(cellData -> cellData.getValue().getName());
        countSausages.setCellValueFactory(cellData -> cellData.getValue().getCount().asObject());
        priceSausages.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());

        try {
            Connection connection = ConnectionMySQL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT ID, Name, Count, Price FROM Products WHERE TypeID = 1");

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCount(resultSet.getInt("Count"));
                product.setPrice(resultSet.getDouble("Price"));
                tableSausages.getItems().add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



