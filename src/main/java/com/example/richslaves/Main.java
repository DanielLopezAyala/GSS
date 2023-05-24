package com.example.richslaves;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 400);

        URL resourceUrl = this.getClass().getResource("styles/hello-style.css");
        if (resourceUrl != null) {
            String css = resourceUrl.toExternalForm();
            scene1.getStylesheets().add(css);
        }

        stage.setResizable(false);

        stage.setTitle("RichSlaves");
        stage.setScene(scene1);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}