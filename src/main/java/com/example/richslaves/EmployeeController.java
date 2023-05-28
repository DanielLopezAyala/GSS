package com.example.richslaves;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeController {

    @FXML
    private void loadWindows(String url){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    private void viewChangeEmailWindow(MouseEvent event){loadWindows("windows/window-change-email.fxml");}

    @FXML
    private void viewChangePasswordWindow(MouseEvent event){loadWindows("windows/window-change-password.fxml");}

}
