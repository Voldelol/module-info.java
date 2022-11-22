package com.example.demo1;
import java.util.*;

public class Gravity {
    private Player myPlayer;
    private int gravityIterations;
    private Timer myTimer;
    private TimerTask myTask;

    public Gravity(Player myPlayer){
        this.myPlayer=myPlayer;
        this.myTimer=new Timer();
        this.myTask=new TimerTask() {
            @Override
            public void run() {
                if(myPlayer.getY()>200 && myPlayer.isTriggerGravity()){
                    myPlayer.setY(myPlayer.getY()-10);
                    //myPlayer.getMyShape().setLayoutY(myPlayer.getY());
                }
                else{
                    myPlayer.setTriggerGravity(false);
                }

            }
        };
    }
    public void setup(){
        myTimer.schedule(myTask,0,50);
    }
}
