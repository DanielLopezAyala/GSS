package com.example.richslaves;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField inputTextLogin;

    @FXML
    private PasswordField inputPasswordLogin;

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
        String userInput = inputTextLogin.getText();
        String passwordInput = inputPasswordLogin.getText();

        boolean validCredentials = validateCredentials(userInput, passwordInput);

        if (validCredentials) {
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

            inputTextLogin.clear();
            inputPasswordLogin.clear();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Log In Error");
            alert.setHeaderText("Incorrect credentials");
            alert.setContentText("Please verify your data and try again.");

            alert.showAndWait();

            inputTextLogin.clear();
            inputPasswordLogin.clear();
        }
    }

    private boolean validateCredentials(String usernameOrEmail, String password) {
        try {
            Connection connection = ConnectionMySQL.getConnection();
            String query = "SELECT COUNT(*) FROM Employees WHERE (UserName = ? OR Email = ?) AND Password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usernameOrEmail);
            statement.setString(2, usernameOrEmail);
            statement.setString(3, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}