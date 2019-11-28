package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class inGameMenuController {
    @FXML
    public ImageView cont;
    @FXML
    public ImageView restart;
    @FXML
    public ImageView mainMenu;
    @FXML
    public ImageView saveExit;
    @FXML
    public void continueClick(){
        Main.primaryStage.setScene(new Scene(new lvl1Game().loadlvl1GameScreen(), Color.TRANSPARENT));
        Main.primaryStage.show();
    }
    @FXML
    public void restartClick(){
        Main.primaryStage.setScene(new Scene(new lvl1Game().loadlvl1GameScreen(), Color.TRANSPARENT));
        Main.primaryStage.show();
    }
    @FXML
    public void mainMenuClick(){
        Main.primaryStage.setScene(new Scene(new mainMenu().loadMainMenuScreen(), Color.TRANSPARENT));
        Main.primaryStage.show();
    }
    @FXML
    public void saveExitClick(){
        System.exit(0);
    }

}
