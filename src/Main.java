//https://www.gamefaces.com/product/flaming-soccer-ball-temporary-tattoo/ for the place holder picture


import controller.Controller;
import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Controller controller = Controller.getInstance();
       controller.update();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
