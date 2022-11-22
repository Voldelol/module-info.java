package com.example.demo1;
import java.util.*;

public class Jumper {
    private Player myPlayer;
    private Timer myTimer;
    private TimerTask myTask;
    private int runIterations;

    public Jumper(Player myPlayer){
        this.runIterations=14;
        this.myPlayer=myPlayer;
        this.myTimer=new Timer();
        this.myTask=new TimerTask() {
            @Override
            public void run(){
                if(runIterations!=0) {
                    myPlayer.setY(myPlayer.getY() + 10);
                    //myPlayer.getMyShape().setLayoutY(myPlayer.getY());
                    runIterations--;
                }
                else{
                    myTimer.cancel();
                    myPlayer.setIsjumping(false);
                    myPlayer.setTriggerGravity(true);
                }

            }
        };


    }

    public void startJump(){
        myTimer.schedule(myTask,0,25);
    }

    public void cancelTimer(){
        myTimer.cancel();
    }


}
