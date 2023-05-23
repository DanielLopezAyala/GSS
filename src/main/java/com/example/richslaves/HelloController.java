package com.example.richslaves;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = stage.getScene();

        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = stage.getScene();

        URL resourceUrl = this.getClass().getResource("register.css");
        if (resourceUrl != null) {
            String css = resourceUrl.toExternalForm();
            scene.getStylesheets().add(css);
        }

        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = stage.getScene();

        stage.setWidth(1000);
        stage.setHeight(600);

        URL resourceUrl = this.getClass().getResource("dashboard.css");
        if (resourceUrl != null) {
            String css = resourceUrl.toExternalForm();
            scene.getStylesheets().add(css);
        }

        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }
}