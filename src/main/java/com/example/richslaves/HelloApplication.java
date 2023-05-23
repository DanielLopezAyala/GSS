package com.example.richslaves;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 400);

        URL resourceUrl = this.getClass().getResource("hello-style.css");
        if (resourceUrl != null) {
            String css = resourceUrl.toExternalForm();
            scene1.getStylesheets().add(css);
        }

        stage.setTitle("RichSlaves");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}