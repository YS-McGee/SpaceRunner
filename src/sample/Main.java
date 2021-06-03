package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;

import javax.swing.text.View;

public class Main extends Application {

    // start() is where it start to run, not main()
    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            ViewManager manager = new ViewManager();
            primaryStage = manager.getMainStage();
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
