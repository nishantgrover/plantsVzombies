package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class lvl1Game {
    public Parent loadlvl1GameScreen() {
        AnchorPane lvl1GamePane = new AnchorPane();
        try {
            FXMLLoader fxml_lvl1Game_load = new FXMLLoader(getClass().getResource("lvl1GameScreen.fxml"));
            fxml_lvl1Game_load.setLocation(getClass().getResource("lvl1GameScreen.fxml"));
            lvl1GamePane = fxml_lvl1Game_load.load();
            FadeTransition FadeAppear = new FadeTransition();
            FadeAppear.setDuration(Duration.seconds(2));
            FadeAppear.setNode(lvl1GamePane);
            FadeAppear.setFromValue(0);
            FadeAppear.setToValue(1);
            FadeAppear.setCycleCount(1);
            FadeAppear.setAutoReverse(false);
            FadeAppear.play();

//            FadeAppear.setOnFinished(e->{
//                Main.primaryStage.setScene(new Scene(new lvl1Game().loadlvl1GameScreen(), Color.TRANSPARENT));
//                Main.primaryStage.show();
//
//
//            });
            return lvl1GamePane;
        } catch (IOException e) {
            e.printStackTrace();
            return lvl1GamePane;
        }
    }
}
