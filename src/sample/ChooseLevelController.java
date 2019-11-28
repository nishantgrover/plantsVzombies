package sample;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ChooseLevelController {
    @FXML
    public ImageView lvl1;

    @FXML
    public void lvl1Hover(){
        lvl1.setImage(new Image("sample/imgs/lvl1-after.png"));
    }

    @FXML
    public void lvl1Leave(){
        lvl1.setImage(new Image("sample/imgs/lvl1.png"));
    }

    @FXML
    public void lvl1Click(){
        Main.primaryStage.setScene(new Scene(new lvl1Game().loadlvl1GameScreen(), Color.TRANSPARENT));
        Main.primaryStage.show();

    }
    @FXML
    public ImageView lvl2;

    @FXML
    public void lvl2Hover(){
        lvl2.setImage(new Image("sample/imgs/lvl2-after.png"));
    }

    @FXML
    public void lvl2Leave(){
        lvl2.setImage(new Image("sample/imgs/lvl2.png"));
    }
    @FXML
    public ImageView lvl3;

    @FXML
    public void lvl3Hover(){
        lvl3.setImage(new Image("sample/imgs/lvl3-after.png"));
    }

    @FXML
    public void lvl3Leave(){
        lvl3.setImage(new Image("sample/imgs/lvl3.png"));
    }

    @FXML
    public ImageView lvl4;

    @FXML
    public void lvl4Hover(){
        lvl4.setImage(new Image("sample/imgs/lvl4-after.png"));
    }

    @FXML
    public void lvl4Leave(){
        lvl4.setImage(new Image("sample/imgs/lvl4.png"));
    }

    @FXML
    public ImageView lvl5;

    @FXML
    public void lvl5Hover(){
        lvl5.setImage(new Image("sample/imgs/lvl5-after.png"));
    }

    @FXML
    public void lvl5Leave(){
        lvl5.setImage(new Image("sample/imgs/lvl5.png"));
    }
    @FXML
    public ImageView lvl6;

    @FXML
    public void lvl6Hover(){
        lvl6.setImage(new Image("sample/imgs/lvl6-after.png"));
    }

    @FXML
    public void lvl6Leave(){
        lvl6.setImage(new Image("sample/imgs/lvl6.png"));
    }

    @FXML
    public ImageView lvl7;

    @FXML
    public void lvl7Hover(){
        lvl7.setImage(new Image("sample/imgs/lvl7-after.png"));
    }

    @FXML
    public void lvl7Leave(){
        lvl7.setImage(new Image("sample/imgs/lvl7.png"));
    }

    @FXML
    public ImageView lvl8;

    @FXML
    public void lvl8Hover(){
        lvl8.setImage(new Image("sample/imgs/lvl8-after.png"));
    }

    @FXML
    public void lvl8Leave(){
        lvl8.setImage(new Image("sample/imgs/lvl8.png"));
    }
}
