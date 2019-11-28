package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class promptScreenController {
    @FXML
    public ImageView newG;

    @FXML
    public ImageView loadG;

    @FXML
    public void newGHover(){
        newG.setImage(new javafx.scene.image.Image("sample/imgs/newGamebtn-after.png"));
    }

    @FXML
    public void newGLeave(){
        newG.setImage(new Image("sample/imgs/newGamebtn-before.png"));
    }

    @FXML
    public void loadGHover(){
        loadG.setImage(new javafx.scene.image.Image("sample/imgs/loadGamebtn-after.png"));
    }

    @FXML
    public void loadGLeave(){
        loadG.setImage(new Image("sample/imgs/loadGamebtn-before.png"));
    }

    @FXML
    public void newGClick(){
        Main.primaryStage.setScene(new Scene(new ChooseLevelScreen().loadChooseLevel(), Color.TRANSPARENT));
        Main.primaryStage.show();
    }
    @FXML
    public void loadGClick(){
        Main.primaryStage.setScene(new Scene(new lvl1Game().loadlvl1GameScreen(), Color.TRANSPARENT));
        Main.primaryStage.show();
    }
}
