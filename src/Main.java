//https://www.gamefaces.com/product/flaming-soccer-ball-temporary-tattoo/ for the place holder picture


import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Card Matching");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getMaxHeight()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
