package com.example.richslaves;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {
    @FXML
    private BorderPane mainEdge;


    public void initialize(){

    }

    public void switchToSceneLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = stage.getScene();

        stage.setResizable(false);

        stage.setWidth(800);
        stage.setHeight(400);

        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sausagesPage(MouseEvent event){loadPage("panel/sausages-page");}
    @FXML
    private void cannedPage(MouseEvent event){loadPage("panel/canned-page");}
    @FXML
    private void meatPage(MouseEvent event){loadPage("panel/meat-page");}
    @FXML
    private void breadPage(MouseEvent event){loadPage("panel/bread-page");}
    @FXML
    private void liquorsPage(MouseEvent event){loadPage("panel/liquors-page");}
    @FXML
    private void snacksPage(MouseEvent event){loadPage("panel/snacks-page");}

    @FXML
    private void viewDevelopers(MouseEvent event){loadWindows("windows/window-developers.fxml");}

    @FXML
    private void viewEmployee(MouseEvent event){loadWindows("windows/window-employee.fxml");}

    @FXML
    private void viewShowItemWindow(MouseEvent event){loadWindows("windows-buttons-dashboard/window-show.fxml");}

    @FXML
    private void viewModifyWindow(MouseEvent event){loadWindows("windows-buttons-dashboard/window-modify.fxml");}

    @FXML
    private void viewDeleteWindow(MouseEvent event){loadWindows("windows-buttons-dashboard/window-delete.fxml");}

    @FXML
    private void viewAddWindow(MouseEvent event){loadWindows("windows-buttons-dashboard/window-add.fxml");}

    private void loadPage(String page) {
        Parent root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        mainEdge.setCenter(root);
    }

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
}
