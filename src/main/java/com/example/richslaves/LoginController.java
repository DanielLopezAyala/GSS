package com.example.richslaves;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = stage.getScene();

        URL resourceUrl = this.getClass().getResource("styles/register.css");
        if (resourceUrl != null) {
            String css = resourceUrl.toExternalForm();
            scene.getStylesheets().add(css);
        }

        stage.setResizable(false);

        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = stage.getScene();

        stage.setResizable(false);
        stage.setWidth(1000);
        stage.setHeight(600);

        URL resourceUrl = this.getClass().getResource("styles/dashboard.css");
        if (resourceUrl != null) {
            String css = resourceUrl.toExternalForm();
            scene.getStylesheets().add(css);
        }

        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }
}