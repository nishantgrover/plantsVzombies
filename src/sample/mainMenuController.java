package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class mainMenuController {
    @FXML
    public ImageView startAdventure;

    @FXML
    public ImageView profileSettings;

    @FXML
    public ImageView help_options;

    @FXML
    public ImageView exit;

    @FXML
    public void startAdventureHover(){
        startAdventure.setImage(new Image("sample/imgs/start adventure-after.png"));
    }

    @FXML
    public void startAdventureLeave(){
        startAdventure.setImage(new Image("sample/imgs/start adventure - before.png"));
    }

    @FXML
    public void profileSettingsHover(){
        profileSettings.setImage(new Image("sample/imgs/profile settings-after.png"));
    }

    @FXML
    public void profileSettingsLeave(){
        profileSettings.setImage(new Image("sample/imgs/profile settings-before.png"));
    }

    @FXML
    public void help_optionsHover(){
        help_options.setImage(new Image("sample/imgs/HelpOptions-after.png"));
    }

    @FXML
    public void help_optionsLeave(){
        help_options.setImage(new Image("sample/imgs/HelpOptions-before.png"));
    }

    @FXML
    public void exitHover(){
        exit.setImage(new Image("sample/imgs/Exit-after.png"));
    }

    @FXML
    public void exitLeave(){
        exit.setImage(new Image("sample/imgs/Exit-before.png"));
    }

    @FXML
    public void StartAdventureClick(){
        Main.primaryStage.setScene(new Scene(new PromptScreen().loadPrompt(), Color.TRANSPARENT));
        Main.primaryStage.show();
    }

    @FXML
    public void ExitClick(){
        System.exit(0);
    }



}