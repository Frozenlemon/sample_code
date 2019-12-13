package controller;

import javafx.beans.NamedArg;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import util.FileIO;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private GridPane pictureGrid;
    @FXML
    private VBox difficultyControl;
    @FXML
    private Label levelLabel;
    private int clickCounter = 0;
    private ArrayList<Integer> turnCard = new ArrayList();
    private final Image placeHolder = new Image("file:" + FileIO.getFilePath("placeholder.png"));

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
        turnUpCard(event);
    }

    @FXML
    private void quitGame(){
        System.exit(0);
    }

    private void initCardGrid(){
        ObservableList<Node> imageList = pictureGrid.getChildren();
        int index = 0;
        for (Node node: imageList){
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

    private void turnUpCard(MouseEvent event){
        if (event.getSource() instanceof ImageView) {
            clickCounter += 1;
            ((ImageView) event.getSource()).setImage(new Image("file:" + FileIO.getFilePath("1.png")));
            int index = Integer.valueOf(((ImageView) event.getSource()).getId());
            turnCard.add(index);
        }
    }

    public void turnDownCard(){
        if (clickCounter % 2 ==0){
            pause(2);
            clickCounter = 0;
            ObservableList<Node> ImageViews = pictureGrid.getChildren();
            for (int i = 0; i < turnCard.size(); i++) {
                ((ImageView)ImageViews.get(turnCard.get(i))).setImage(placeHolder);
            }
        }
    }

    private void pause(int second){
        try{
            Thread.sleep(second*1000);
        }catch (InterruptedException e){
            System.out.println("System interrupted");
        }
    }
}
