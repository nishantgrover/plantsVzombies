package sample;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.util.Duration;

import java.io.IOException;


public class Main extends Application {
    protected static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        this.primaryStage.initStyle(StageStyle.TRANSPARENT);
//        loadOpeningScreen();
        primaryStage.setScene(new Scene(loadOpeningScreen(), Color.TRANSPARENT));
        primaryStage.setTitle("PvZ");
        primaryStage.show();
    }
    public Parent loadOpeningScreen(){
        StackPane openingPane = new StackPane();
        try {
            FXMLLoader fxml_opening_load = new FXMLLoader(getClass().getResource("openingScreen.fxml"));

//            fxml_opening_load.setLocation(Main.class.getResource("sample/openingScreen.fxml"));
            openingPane = fxml_opening_load.load();
            //Scene scene = new Scene(openingPane);
            //primaryStage.setScene(scene);
//            System.out.print("dasd");
            FadeTransition FadeAppear = new FadeTransition();
            FadeAppear.setDuration(Duration.seconds(3));
            FadeAppear.setNode(openingPane);
            FadeAppear.setFromValue(0);
            FadeAppear.setToValue(1);
            FadeAppear.setCycleCount(1);
            FadeAppear.setAutoReverse(false);
            FadeTransition FadeDisappear = new FadeTransition();
            FadeDisappear.setDuration(Duration.seconds(1.5));
            FadeDisappear.setNode(openingPane);
            FadeDisappear.setFromValue(1);
            FadeDisappear.setToValue(0);
            FadeDisappear.setCycleCount(1);
            FadeAppear.play();
            FadeAppear.setOnFinished(e->{
                FadeDisappear.play();
                FadeDisappear.setOnFinished(e1->{
                    primaryStage.setScene(new Scene(new loadingScreenDisp().loadLoadingScreen(),Color.TRANSPARENT));
                    primaryStage.show();
                });
            });
            return openingPane;
        }catch (IOException e){
            e.printStackTrace();
            return openingPane;
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
