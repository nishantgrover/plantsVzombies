package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class ChooseLevelScreen {
    public Parent loadChooseLevel() {
        StackPane ChooseLevelPane = new StackPane();
        try {
            FXMLLoader fxml_ChooseLevel_load = new FXMLLoader(getClass().getResource("ChooseLevelScreen.fxml"));
            fxml_ChooseLevel_load.setLocation(getClass().getResource("ChooseLevelScreen.fxml"));
            ChooseLevelPane = fxml_ChooseLevel_load.load();
            return ChooseLevelPane;
        } catch (IOException e) {
            e.printStackTrace();
            return ChooseLevelPane;
        }
    }
}
