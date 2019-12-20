package controller;

import javafx.beans.NamedArg;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import util.FileIO;
import view.MainGridView;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller{

    static Controller instance;
    Stage stage;
    MainGridView mainGridView;

    private Controller(){
        stage = new Stage();
        stage.setTitle("Test");
        mainGridView = new MainGridView();
        Scene scene = new Scene(mainGridView.getGrid1());
        stage.setScene(scene);
    }

    public static Controller getInstance(){
        if (instance == null)
           instance = new Controller();
        return instance;
    }

    public void update(){
        stage.show();
    }
}
