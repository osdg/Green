package org.osdg.green;

import javafx.application.Application;
import javafx.stage.Stage;
import org.osdg.green.controllers.Browser;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Browser.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
