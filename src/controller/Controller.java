package controller;

import javafx.beans.NamedArg;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import util.FileIO;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane pictureGrid;
    @FXML
    private VBox menuControl, difficultyControl;
    @FXML
    private Button increaseDifficulty, decreaseDifficulty, start;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private Label levelLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCardGrid();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        double width = screenSize.getWidth();
        setBorderPane(width, height);
        pictureGrid.setPrefSize(width*0.90,height*0.85);
    }

    @FXML
    private void clickIncreaseDifficulty(){
        levelLabel.setText("PLACE HOLDER LEVEL INCREASE");
    }

    @FXML
    private void clickDecreaseDifficulty(){
        levelLabel.setText("PLACE HOLDER LEVEL DECREASE");
    }

    @FXML
    private void clickStart(){
        pictureGrid.setVisible(true);
        difficultyControl.setVisible(false);
    }

    @FXML
    private void clickCard(MouseEvent event){
        try {
            ImageView button = (ImageView) event.getSource();
            int index = Integer.valueOf(button.getId());

        }catch (ClassCastException e){
            System.out.println("Item is not ImageView");
        }
    }

    @FXML
    private void quitGame(){
        System.exit(0);
    }

    private void initCardGrid(){
        ObservableList<Node> imageList = pictureGrid.getChildren();
        int index = 0;
        for (Node node: imageList){
            Image placeHolder = new Image("file:" + FileIO.getFilePath("placeholder.png"));
            if (node instanceof ImageView) {
                ((ImageView) node).setImage(placeHolder);
                node.setId(index + "");
                index++;
            }
        }
        pictureGrid.setVisible(false);
    }

    private void setBorderPane(@NamedArg("width") double width, @NamedArg("height") double height){
        borderPane.setPrefSize(width,height);
        BackgroundImage myBI= new BackgroundImage(new Image("file:" + FileIO.getFilePath("background2.png"), width, height, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        borderPane.setBackground(new Background(myBI));
        borderPane.setPadding(new Insets(15));
    }
}
