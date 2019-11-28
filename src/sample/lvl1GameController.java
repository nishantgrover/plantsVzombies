package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class lvl1GameController implements Initializable {
    private static int x=0;
    @FXML
    public ImageView peashooter;
    @FXML
    public Rectangle r_sunflower;
    @FXML
    public Rectangle r_peashooter;
    @FXML
    public Rectangle r_cherrybomb;
    @FXML
    public Rectangle r_walnut;
    @FXML
    public ImageView z1;
    @FXML
    public ImageView z2;
    @FXML
    public ImageView z3;
    @FXML
    public TextField sunTokenCounter;

    @FXML
    public void peashooterClick(){
        x=2;
        selectPlant();
    }
    @FXML
    public void sunflowerClick(){
        x=1;
        selectPlant();
    }
    @FXML
    public void shovelClick(){
        x=5;
//        selectPlant();
    }
    @FXML
    public void cherrybombClick(){
        x=3;
        selectPlant();
    }
    @FXML
    public void walnutClick(){
        x=4;
        selectPlant();
    }
    @FXML
    public void selectPlant(){
        switch(x){
            case 1: r_sunflower.setFill(Color.WHITE);
                    r_peashooter.setFill(Color.BLACK);
                    r_cherrybomb.setFill(Color.BLACK);
                    r_walnut.setFill(Color.BLACK);
                    break;
            case 2: r_sunflower.setFill(Color.BLACK);
                    r_peashooter.setFill(Color.WHITE);
                    r_cherrybomb.setFill(Color.BLACK);
                    r_walnut.setFill(Color.BLACK);
                    break;
            case 3: r_sunflower.setFill(Color.BLACK);
                    r_peashooter.setFill(Color.BLACK);
                    r_cherrybomb.setFill(Color.WHITE);
                    r_walnut.setFill(Color.BLACK);
                    break;
            case 4: r_sunflower.setFill(Color.BLACK);
                    r_peashooter.setFill(Color.BLACK);
                    r_cherrybomb.setFill(Color.BLACK);
                    r_walnut.setFill(Color.WHITE);
                    break;
        }
    }
    @FXML
    private ImageView pbar;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        moveZombie(z1);
        moveZombie(z2);
        moveZombie(z3);
        movePBar();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(suntoken1.getX()+" "+suntoken1.getLayoutX());
        suntoken1move();

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        suntoken2move();


    }

    public void moveZombie(ImageView Z){
        TranslateTransition t = new TranslateTransition();
        t.setByX(-400);
        t.setDuration(Duration.millis(65000));
        t.setNode((Node) Z);
        t.play();

    }
    public void movePBar(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(-123);
        t.setDuration(Duration.millis(68000));
        t.setNode((Node) pbar);
        t.play();
    }
    public Image pea=new Image("sample/imgs/Pea.png");
    @FXML
    public ImageView lawn_mower1;
    @FXML
    public ImageView lawn_mower2;
    @FXML
    public ImageView lawn_mower3;
    @FXML
    public ImageView lawn_mower4;
    @FXML
    public ImageView lawn_mower5;
    @FXML
    public ImageView menu;

    @FXML
    public void menuClick(){
        AnchorPane inGameMenuPane= new AnchorPane();
        FXMLLoader fxml_inGameMenu_load = new FXMLLoader(getClass().getResource("inGameMenuScreen.fxml"));
        fxml_inGameMenu_load.setLocation(getClass().getResource("inGameMenuScreen.fxml"));
        try {
            inGameMenuPane = fxml_inGameMenu_load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.primaryStage.setScene(new Scene(inGameMenuPane, Color.TRANSPARENT));
        Main.primaryStage.show();
    }
    @FXML
    public void LawnMower1Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode((Node) lawn_mower1);
        t.play();
    }
    @FXML
    public void LawnMower2Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode((Node) lawn_mower2);
        t.play();
    }
    @FXML
    public void LawnMower3Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode((Node) lawn_mower3);
        t.play();
        int i=0;
        while(i<1000){
            int j=0;
            i++;
            while(j<100) {
                System.out.println(z1.getX());
                System.out.println(z1.getTranslateX());
                j++;
            }
        }
    }
    @FXML
    public void LawnMower4Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode((Node) lawn_mower4);
        t.play();
        int i=0;
        while(i<1000){
            int j=0;
            i++;
            while(j<100) {
                System.out.println(z1.getX());
                System.out.println(z1.getTranslateX());
                j++;
            }
        }
    }
    @FXML
    public void LawnMower5Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode((Node) lawn_mower5);
        t.play();
    }
    @FXML
    public ImageView suntoken1;
    @FXML
    public ImageView suntoken2;
    @FXML
    public void suntoken1move(){
        TranslateTransition t = new TranslateTransition();
        System.out.print(suntoken1.getX());
//        suntoken1.setY(700);
        suntoken1.setX(200);
        suntoken1.setOpacity(1);
        t.setByY(200);
        t.setDuration(Duration.millis(8000));
        t.setNode((Node) suntoken1);
        t.play();

    }
    @FXML
    public void suntoken2move(){
        TranslateTransition t = new TranslateTransition();
        t.setByY(200);
        t.setDuration(Duration.millis(13000));
        t.setNode((Node) suntoken2);
        t.play();
    }
    @FXML
    public void suntoken1Click(){
        suntoken1.setOpacity(0);
        suntoken1=null;
        sunTokenCounter.setText(Integer.toString(Integer.parseInt(sunTokenCounter.getText())+25));
    }
    @FXML
    public void suntoken2Click(){
        suntoken2.setOpacity(0);
    }
    @FXML
    public void setOnGrid(MouseEvent m){
        StackPane s = (StackPane) m.getSource();
        ImageView i;
        if(x>=1 && x<=2 && s.getChildren().isEmpty()){
            switch(x){
                case 2: i=new ImageView(new Image("sample/imgs/pea_shooter.gif"));
                        i.setFitHeight(40);
                        i.setFitWidth(30);
                        s.getChildren().add(i);

                        ImageView shoot=new ImageView(pea);
                        s.getChildren().add(shoot);
                        shoot.toBack();
                        shoot_the_pea(shoot);

                        break;
                case 1: i=new ImageView(new Image("sample/imgs/sun_flower.gif"));
                        i.setFitHeight(40);
                        i.setFitWidth(30);
                        s.getChildren().add(i);
                        break;

            }
        }
        else if(x==5 && !(s.getChildren().isEmpty())){
            s.getChildren().removeAll();
        }
    }

    public void shoot_the_pea(ImageView pea){
        TranslateTransition t = new TranslateTransition();
        t.setByX(600);
        t.setDuration(Duration.millis(2000));
        t.setNode((Node) pea);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

    }


}
