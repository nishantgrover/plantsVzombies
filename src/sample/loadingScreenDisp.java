package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

import static java.lang.Thread.*;

public class loadingScreenDisp {
    public Parent loadLoadingScreen(){
        StackPane loadingPane = new StackPane();
        try {
            FXMLLoader fxml_loading_load = new FXMLLoader(getClass().getResource("loadingScreen.fxml"));
            loadingPane = fxml_loading_load.load();
            FadeTransition FadeAppear = new FadeTransition();
            FadeAppear.setDuration(Duration.seconds(3));
            FadeAppear.setNode(loadingPane);
            FadeAppear.setFromValue(0);
            FadeAppear.setToValue(1);
            FadeAppear.setCycleCount(1);
            FadeAppear.setAutoReverse(false);
            FadeAppear.play();
            FadeAppear.setOnFinished(e->{

                Main.primaryStage.setScene(new Scene(new mainMenu().loadMainMenuScreen(), Color.TRANSPARENT));
                Main.primaryStage.show();


            });
            return loadingPane;
        }catch (IOException e){
            e.printStackTrace();
            return loadingPane;
        }
    }
}
