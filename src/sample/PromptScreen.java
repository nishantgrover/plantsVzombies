package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class PromptScreen {
    public Parent loadPrompt() {
        StackPane promptPane = new StackPane();
        try {
            FXMLLoader fxml_prompt_load = new FXMLLoader(getClass().getResource("promptScreen.fxml"));
            fxml_prompt_load.setLocation(getClass().getResource("promptScreen.fxml"));
            promptPane = fxml_prompt_load.load();
//            FadeTransition FadeAppear = new FadeTransition();
//            FadeAppear.setDuration(Duration.seconds(2));
//            FadeAppear.setNode(promptPane);
//            FadeAppear.setFromValue(0);
//            FadeAppear.setToValue(1);
//            FadeAppear.setCycleCount(1);
//            FadeAppear.setAutoReverse(false);
//            FadeAppear.play();
//            FadeAppear.setOnFinished(e->{
//                Main.primaryStage.setScene(new Scene(new prompt().loadpromptScreen(), Color.TRANSPARENT));
//                Main.primaryStage.show();
//
//
//            });
            return promptPane;
        } catch (IOException e) {
            e.printStackTrace();
            return promptPane;
        }
    }
}
