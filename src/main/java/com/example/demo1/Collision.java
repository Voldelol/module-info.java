package com.example.demo1;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class Collision {
    private Player myPlayer;
    private ArrayList<Assets> collidables;
    private Timer myTimer;
    private TimerTask myTask;
    private Timer endTimer;
    private TimerTask endGame;
    private boolean atRightBorder ;
    private boolean atLeftBorder ;
    private boolean atBottomBorder;
    private boolean atTopBorder;
    //private Bounds myBounds;
    private ArrayList<Assets> collisionList;
    private Music deathSound;
    public Collision(Player myPlayer){
        this.atRightBorder=false;
        this.atBottomBorder=false;
        this.atLeftBorder=false;
        this.atTopBorder=false;
        this.deathSound=new Music("explosion.mp4");
        this.myPlayer=myPlayer;
        this.collidables=new ArrayList<>();
        //this.myBounds=myPlayer.getMyShape().getBoundsInParent();
        this.collisionList=new ArrayList<>();
        this.myTimer=new Timer();
        this.endTimer=new Timer();
        this.myTask=new TimerTask() {
            @Override
            public void run() {
                if(isCollided()){
                    //myPlayer.kill();
                    myPlayer.setMyIMG(new Image("file:src/main/resources/explosion.png"));
                    deathSound.start();
                    endTimer.schedule(endGame,1000,10);

                    //Ajouter le handler qui détermine quelle partie de la hitbox du joueur est en collision avec le décor
                    //Pour le cas des collisions multiples il faudra rajouter une liste comprenant les indices des assets en collision
                    //à ce moment là
                    //collisionHandler();


                }
                else {
                    //myPlayer.setTriggerGravity(true);
                }
            }
        };
        this.endGame=new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        };
    }
    void addCollidables(Assets myAsset){
        collidables.add(myAsset);

    }
    void collisionHandler(){
        for(int i=0;i<collisionList.size();i++){
            Bounds myBounds=collisionList.get(i).getMyShape().getBoundsInParent();
            System.out.println("OBSTACLE:"+myBounds);
            System.out.println("JOUEUR"+myPlayer.getMyShape().getBoundsInParent());


        }
    }

    public boolean isCollided(){

        for(int i=0;i< collidables.size();i++){
            Assets collider=collidables.get(i);
            if(collider.isCollidable()){
                //System.out.println(collisionList);
                if(myPlayer.getMyShape().intersects(collider.getMyShape().getBoundsInParent())){
                    System.out.println("COLLISION");
                    if(!collisionList.contains(collider)){
                        collisionList.add(collider);
                    }
                    return true;
                }
                /*
                else {
                    if(collisionList.contains(collider)){
                        collisionList.remove(collider);
                    }

                 */
                }
            }
        return false;
        }




    public void setup(){
        myTimer.schedule(myTask,1000,10);
    }
    //Bug louche où la collision est détectée sans raison au début du jeu
    //Fixé ??? en délayant l'activation du timer

}
