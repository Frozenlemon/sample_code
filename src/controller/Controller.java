package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import util.FileIO;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane pictureGrid;
    @FXML
    private VBox menuVbox, dynamicVbox;
    @FXML
    private Button quit, increaseDifficulty, decreaseDifficulty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Node> imageList = pictureGrid.getChildren();
        for (Node node: imageList){
            Image placeHolder = new Image("file:" + FileIO.getFilePath("placeholder.png"));
            if (node instanceof ImageView)
                ((ImageView) node).setImage(placeHolder);
        }
    }

    @FXML
    private void quitGame(MouseEvent e){
        System.exit(0);
    }

}
