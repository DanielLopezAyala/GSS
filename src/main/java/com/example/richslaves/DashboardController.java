package com.example.richslaves;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Objects;

public class DashboardController {
    @FXML
    private BorderPane mainEdge;

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

    private void loadPage(String page) {
        Parent root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        mainEdge.setCenter(root);
    }
}
