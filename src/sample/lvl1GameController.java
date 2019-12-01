package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import sun.reflect.generics.scope.DummyScope;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.*;

import static sample.Zombie.*;


public class lvl1GameController implements Initializable {
    private static int x=0;
    @FXML
    public ImageView peashooter;
    @FXML
    public GridPane backyardGrid = new GridPane();
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
    public ArrayList<Zombie> levelZombies = new ArrayList<>();
    public ArrayList<Plant> levelPlants = new ArrayList<>();
    @FXML
    public void placeZombies(int n){
            int RnG = 1 + new Random().nextInt(4);
            Zombie madeZombie = new Zombie();
            String selectZombie = new Integer(RnG).toString();
            madeZombie = (Zombie) ZombieFactory.getInstance().createCreature(selectZombie);
            int row = new Random().nextInt(5) + 4;
            int col = 12;
        System.out.println("Rng: "+RnG);
            madeZombie.resetXY();
            levelZombies.add(madeZombie);
            Zombie.getAllZombies().add(madeZombie);
            if (selectZombie.equals("1")) {
                madeZombie.getMyImage().setFitWidth(z2.getFitWidth());
                madeZombie.getMyImage().setFitHeight(z2.getFitHeight());
            }
            else {
                madeZombie.getMyImage().setFitWidth(z1.getFitWidth());
                madeZombie.getMyImage().setFitHeight(z1.getFitHeight());
            }
            if(RnG==3){
                madeZombie.getMyImage().setFitHeight(madeZombie.getMyImage().getFitHeight() - 10);
            }
            if(RnG==4){
                madeZombie.getMyImage().setFitHeight(madeZombie.getMyImage().getFitHeight() - 10);
            }
            madeZombie.getMyImage().setFitHeight(madeZombie.getMyImage().getFitHeight() - 20);
            madeZombie.getMyImage().setFitWidth(madeZombie.getMyImage().getFitWidth() - 20);
            backyardGrid.add(madeZombie.getMyImage(), col, row);
            moveZombie(madeZombie);
    }
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
    public void addStackPanes(){
        for(int i=4; i<=8;i++){
            for(int j=1;j<=9;j++){
                StackPane cell = new StackPane();
                backyardGrid.add(cell,j,i);
                final int row = i;
                final int col = j;
                cell.setOnMouseClicked(event -> {
                        StackPane s = (StackPane) event.getSource();
                    System.out.println("dsabjdkas");
                        if(s.getChildren().isEmpty()){
                            ImageView i1;
                            switch(x){
                                case 2:Plant p = (Plant) PlantFactory.getInstance().createCreature("peashooter");
                                    p.setParent(s);
                                    i1=new ImageView(new Image("sample/imgs/pea_shooter.gif"));
                                    i1.setFitHeight(40);
                                    i1.setFitWidth(30);
                                    p.setImage(i1);
                                    levelPlants.add(p);
                                    s.getChildren().add(i1);
                                    s.toFront();
                                    i1.toFront();
//                                    s.toFront();
                                    shootPea(col,row);
                                    System.out.println("PLaced");
                                    break;
                                case 1:p = (Plant) PlantFactory.getInstance().createCreature("sunflower");
                                    p.setParent(s);
                                    i1=new ImageView(new Image("sample/imgs/sun_flower.gif"));
                                    i1.setFitHeight(40);
                                    i1.setFitWidth(30);
                                    p.setImage(i1);
                                    s.getChildren().add(i1);
                                    produceSunToken(col,row);
                                    levelPlants.add(p);
                                    break;
                                case 4: p = (Plant) PlantFactory.getInstance().createCreature("wallnut");
                                    p.setParent(s);
                                    System.out.println("wallnut placed");
                                    i1=new ImageView(new Image("sample/imgs/lvl4.png"));
                                    i1.setFitHeight(50);
                                    i1.setFitWidth(45);
                                    p.setImage(i1);
                                    s.getChildren().add(i1);
                                    levelPlants.add(p);
                                    break;

                                case 3: p = (Plant) PlantFactory.getInstance().createCreature("cherrybomb");
                                    p.setParent(s);
                                    System.out.println("CBomb placed");
                                    i1=new ImageView(new Image("sample/imgs/cherrybmb.jpg"));
                                    i1.setFitHeight(40);
                                    i1.setFitWidth(30);
                                    p.setImage(i1);
                                    s.getChildren().add(i1);
                                    levelPlants.add(p);
                                    break;
                            }
                        }
                        else if(x==5 && !(s.getChildren().isEmpty())){
                            s.getChildren().removeAll();
                        }

                });
            }
        }
    }

    private void produceSunToken(int col, int row) {
        Timeline produceSunTimeline =new Timeline(new KeyFrame(Duration.millis(10000),e->{
            produce_the_sun(col,row);
        }));
        produceSunTimeline.setCycleCount(Timeline.INDEFINITE);
        produceSunTimeline.play();
    }

    private void produce_the_sun(int col, int row) {
        ImageView sunDefault = new ImageView(new Image("sample/imgs/sun.gif"));
        sunDefault.setFitHeight(suntoken1.getFitHeight());
        sunDefault.setFitWidth(suntoken1.getFitWidth());
        backyardGrid.add(sunDefault,col,row);
        sunDefault.setOnMouseClicked((Event e)-> {
            sunDefault.setOpacity(0);
            backyardGrid.getChildren().remove(sunDefault);
            sunTokenCounter.setText(Integer.toString(Integer.parseInt(sunTokenCounter.getText())+25));
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        addStackPanes();
        movePBar();
        backyardGrid.toFront();
        menu.toFront();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    Timeline timeline=new Timeline();
                    ImageView sunDefault = new ImageView(new Image("sample/imgs/sun.gif"));
                    Random r= new Random();
                    int col=1+r.nextInt(9);
                    sunDefault.setFitHeight(suntoken1.getFitHeight());
                    sunDefault.setFitWidth(suntoken1.getFitWidth());
                    int X=5;
                    backyardGrid.add(sunDefault,col,0);
                    sunDefault.setOnMouseClicked((Event e)-> {
                        sunDefault.setOpacity(0);
                        backyardGrid.getChildren().remove(sunDefault);
                        sunTokenCounter.setText(Integer.toString(Integer.parseInt(sunTokenCounter.getText())+25));
                    });
                    timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(sunDefault.translateYProperty(),0)), new KeyFrame(Duration.seconds(X), new KeyValue(sunDefault.translateYProperty(),150 + r.nextInt(200))));
                    timeline.play();
                });
            }
        }, 0, 10000);
        Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(7), e->placeZombies(10)));
        t1.setCycleCount(10);
        t1.play();
    }

    public void moveZombie(Zombie Z){
        TranslateTransition t = new TranslateTransition();
        t.setByX(-450);
        System.out.println("Plant size : "+levelPlants.size());
        if(!levelPlants.isEmpty()) {
            for (Plant p : levelPlants) {
                System.out.println("Plant size : "+levelPlants.size());
                Z.getMyImage().translateXProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (p.getParent().getBoundsInParent().intersects(Z.getMyImage().getBoundsInParent())) {
                            System.out.println("me here?");
                            t.pause();
                            Thread t2=new Thread(()->{
                                while(p.getHP()>0) {
                                    System.out.println(p.getHP());
                                    p.setHP(p.getHP() - Z.getAtkpwr());
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println(p.getHP());
                                if(p.getHP()<=0){
                                    Platform.runLater(()->{
                                        p.getParent().getChildren().remove(p.getMyImage());
                                        t.play();
                                    });
                                }
                            });
                            t2.start();
                        }
                        else if(Z.getMyImage().getBoundsInParent().intersects(lawn_mower1.getBoundsInParent())){
                            System.out.println("lm1");
                            LawnMower1Click();
                        }
                        else if(Z.getMyImage().getBoundsInParent().intersects(lawn_mower2.getBoundsInParent())){
                            LawnMower2Click();
                        }
                        else if(Z.getMyImage().getBoundsInParent().intersects(lawn_mower3.getBoundsInParent())){
                            LawnMower3Click();
                        }
                        else if(Z.getMyImage().getBoundsInParent().intersects(lawn_mower4.getBoundsInParent())){
                            LawnMower4Click();
                        }
                        else if(Z.getMyImage().getBoundsInParent().intersects(lawn_mower5.getBoundsInParent())){
                            LawnMower5Click();
                        }
                    }
                });
            }
        }
        t.setDuration(Duration.millis(35000/Z.getSpeed()));
        t.setNode(Z.getMyImage());
        t.play();

    }

    public void movePBar(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(-123);
        t.setDuration(Duration.millis(68000));
        t.setNode(pbar);
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
        t.setNode(lawn_mower1);
        if(!levelZombies.isEmpty()) {
            for (Zombie z : levelZombies) {
                lawn_mower1.translateXProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (lawn_mower1.getBoundsInParent().intersects(z.getMyImage().getBoundsInParent())) {
                            backyardGrid.getChildren().remove(z.getMyImage());
                        }
                    }
                });
            }
        }
        t.play();
    }
    @FXML
    public void LawnMower2Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode(lawn_mower2);
        if(!levelZombies.isEmpty()) {
            for (Zombie z : levelZombies) {
                lawn_mower2.translateXProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (lawn_mower2.getBoundsInParent().intersects(z.getMyImage().getBoundsInParent())) {
                            backyardGrid.getChildren().remove(z.getMyImage());
                        }
                    }
                });
            }
        }
        t.play();
    }
    @FXML
    public void LawnMower3Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode(lawn_mower3);
        if(!levelZombies.isEmpty()) {
            for (Zombie z : levelZombies) {
                lawn_mower3.translateXProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (lawn_mower3.getBoundsInParent().intersects(z.getMyImage().getBoundsInParent())) {
                            backyardGrid.getChildren().remove(z.getMyImage());
                        }
                    }
                });
            }
        }
        t.play();
    }
    @FXML
    public void LawnMower4Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode(lawn_mower4);
        if(!levelZombies.isEmpty()) {
            for (Zombie z : levelZombies) {
                lawn_mower4.translateXProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (lawn_mower4.getBoundsInParent().intersects(z.getMyImage().getBoundsInParent())) {
                            backyardGrid.getChildren().remove(z.getMyImage());
                        }
                    }
                });
            }
        }
        t.play();
    }
    @FXML
    public void LawnMower5Click(){
        TranslateTransition t = new TranslateTransition();
        t.setByX(700);
        t.setDuration(Duration.millis(5000));
        t.setNode(lawn_mower5);
        if(!levelZombies.isEmpty()) {
            for (Zombie z : levelZombies) {
                lawn_mower5.translateXProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (lawn_mower5.getBoundsInParent().intersects(z.getMyImage().getBoundsInParent())) {
                            backyardGrid.getChildren().remove(z.getMyImage());
                        }
                    }
                });
            }
        }
        t.play();
    }
    @FXML
    public ImageView suntoken1;

    public void shootPea(int col, int row){
        Timeline shootPeatimeline =new Timeline(new KeyFrame(Duration.millis(3200),e->{
            shoot_the_pea(col,row);
        }));
        shootPeatimeline.setCycleCount(Timeline.INDEFINITE);
        shootPeatimeline.play();
    }
    public void shoot_the_pea(int col, int row){
        Pea bullet = new Pea(1);
        ImageView shoot=new ImageView(pea);
        bullet.setMyImage(shoot);
        backyardGrid.add(shoot,col,row);
        ImageView pea = new ImageView();
        pea = bullet.getMyImage();
        TranslateTransition t = new TranslateTransition();
        t.setByX(600);
        t.setNode(pea);
        pea.setVisible(true);
        t.setDuration(Duration.millis(3200));
        if(!levelZombies.isEmpty()) {
            for (Zombie z : levelZombies) {
                ImageView finalPea = pea;
                finalPea.toFront();
                pea.translateXProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (finalPea.getBoundsInParent().intersects(z.getMyImage().getBoundsInParent())) {
                            finalPea.toFront();
                            finalPea.setVisible(false);
                            z.setHP(z.getHP()-bullet.getPower());
                            System.out.println("Bullet Power"+bullet.getPower()+ " HP: "+z.getHP());
                            if(z.getHP()<=0){
                                backyardGrid.getChildren().remove(z.getMyImage());
                            }
                        }

                    }
                });
            }
        }
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

    }
}
