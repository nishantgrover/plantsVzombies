package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class mainMenu {
    public Parent loadMainMenuScreen() {
        StackPane mainMenuPane = new StackPane();
        try {
            FXMLLoader fxml_mainMenu_load = new FXMLLoader(getClass().getResource("mainMenuScreen.fxml"));
            fxml_mainMenu_load.setLocation(getClass().getResource("mainMenuScreen.fxml"));
            mainMenuPane = fxml_mainMenu_load.load();
            FadeTransition FadeAppear = new FadeTransition();
            FadeAppear.setDuration(Duration.seconds(2));
            FadeAppear.setNode(mainMenuPane);
            FadeAppear.setFromValue(0);
            FadeAppear.setToValue(1);
            FadeAppear.setCycleCount(1);
            FadeAppear.setAutoReverse(false);
            FadeAppear.play();
//            FadeAppear.setOnFinished(e->{
//                Main.primaryStage.setScene(new Scene(new mainMenu().loadMainMenuScreen(), Color.TRANSPARENT));
//                Main.primaryStage.show();
//
//
//            });
            return mainMenuPane;
        } catch (IOException e) {
            e.printStackTrace();
            return mainMenuPane;
        }
    }
}
