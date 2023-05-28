package com.example.richslaves;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WindowController {
    @FXML
    private TextField idTextFieldProduct;
    @FXML
    private TextField nameTextFieldProduct;
    @FXML
    private TextField amountTextFieldProduct;
    @FXML
    private TextField priceTextFieldProduct;
    @FXML
    private TextField urlTextFieldProduct;

    public void addButtonDatabase(ActionEvent event){
        String id = idTextFieldProduct.getText();
        String name = nameTextFieldProduct.getText();
        String amount = amountTextFieldProduct.getText();
        String price = priceTextFieldProduct.getText();
        String urlText = urlTextFieldProduct.getText();

        if (id.isEmpty() || name.isEmpty() || amount.isEmpty() || price.isEmpty() || urlText.isEmpty()) {


        } else {


        }


    }



}
