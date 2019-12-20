package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class MainGridView {
    @FXML
    StackPane grid1;
    BigShape shape1;
    Rectangle[] allRec = new Rectangle[11];

    public MainGridView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/MainView.fxml"));
            grid1 = loader.load();
            shape1 = new BigShape();
            grid1.getChildren().add(shape1);
        }catch (IOException e) {
            System.out.println("sth worng here");
        }
    }

    public StackPane getGrid1(){
        return grid1;
    }
}
