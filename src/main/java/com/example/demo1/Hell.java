package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class Hell {
    private AnimationController myAnimControl;
    private Timer myTimer;
    private TimerTask myTask;
    Random generator;

    public Hell(AnimationController myAnimControl){
        this.myAnimControl=myAnimControl;
        this.generator=new Random();
        this.myTimer=new Timer();
        this.myTask=new TimerTask() {
            @Override
            public void run() {
                int offset=-200+ generator.nextInt(401);
                double x=myAnimControl.getMyPlayer().getX()-500;
                double y=200+offset;
                Assets Bullet=new Assets(x,y,true,true,new Image("file:src/main/resources/bullet2.png"),new Rectangle(x,y,150,30),true);
                myAnimControl.addStaticAsset(Bullet);
                //add bullet to collidables
                myAnimControl.getMyCollision().addCollidables(Bullet);
                //myAnimControl.getRoot().getChildren().add(Bullet.getMyShape());
            }
        };
    }
    public void setup(){myTimer.schedule(myTask,2500,2500);}
}
