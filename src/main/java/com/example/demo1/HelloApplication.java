package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Music myMusic=new Music("TMNT_NES.mp4");
        myMusic.start();
        Player myPlayer=new Player(-200,200,10,new Image("file:src/main/resources/player_cloclo_right.png"),new Rectangle(400,200,250,300));
        Assets Background=new Assets(0,0,false,false,new Image("file:src/main/resources/space.png"));
        Assets Sun=new Assets(600,80,true,false,new Image("file:src/main/resources/sun.png"),new Rectangle(600,80,180,180));

        AnimationController myController=new AnimationController(myPlayer);
        Hell myHell=new Hell(myController);
        myController.addStaticAsset(Background);
        myController.addStaticAsset(Sun);

        stage.setScene(myController.getMyScene());
        myController.setup();

        stage.show();
        myController.start();
        myHell.setup();


    }

    public static void main(String[] args) {
        launch();
    }
}