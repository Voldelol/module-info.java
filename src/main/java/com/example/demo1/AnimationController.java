package com.example.demo1;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.Random;


public class AnimationController extends AnimationTimer {
    Random rand=new Random();
    private Group root;
    private Canvas myCanvas;
    private Scene myScene;
    GraphicsContext gc;
    private ArrayList<Assets> nonPlayerAssets;
    private Player myPlayer;
    private Gravity myGravity;
    private Collision myCollision;


    public AnimationController( Player myPlayer) {
        root=new Group();
        this.myScene=new Scene(root);
        myCanvas=new Canvas(800,800);
        root.getChildren().add(myCanvas);
        this.myPlayer = myPlayer;
        this.myCollision= new Collision(myPlayer);
        gc= myCanvas.getGraphicsContext2D();
        nonPlayerAssets=new ArrayList<>();
        myGravity=new Gravity(myPlayer);
        root.getChildren().add(myPlayer.getMyShape());


    }
    void assetHandler(){
        for(int i=0;i<nonPlayerAssets.size();i++){
            Assets myAsset=nonPlayerAssets.get(i);
            if(myAsset.isCollidable()&&!myAsset.isMovable()){
                myAsset.getMyShape().setLayoutX(myPlayer.getX()-400);
                myAsset.getMyShape().setLayoutY(myPlayer.getY()-200);

            }
            if(myAsset.isCollidable()&&myAsset.isMovable()){//bullet hell
                if(myAsset.getCtx()){
                    root.getChildren().add((myAsset.getMyShape()));
                    myAsset.setCtx(false);
                }

                myAsset.setX(myAsset.getX()+10);//Pour le sprite
                myAsset.getMyShape().setLayoutX(myAsset.getX()+nonPlayerAssets.get(0).getX()+700);
                myAsset.getMyShape().setLayoutY(myAsset.getY()+nonPlayerAssets.get(0).getY());




            }
        }
    }

    void addStaticAsset(Assets myAsset){
        nonPlayerAssets.add(myAsset);
    }

    public Scene getMyScene() {
        return myScene;
    }

    @Override
    public void handle(long currentNanoTime){

        nonPlayerAssets.get(0).setX(myPlayer.getX()-400);
        nonPlayerAssets.get(0).setY(myPlayer.getY()-200);
        nonPlayerAssets.get(1).getMyShape().setLayoutX(nonPlayerAssets.get(0).getX()+400);
        nonPlayerAssets.get(1).getMyShape().setLayoutY(nonPlayerAssets.get(0).getY()+200);

        gc.drawImage(nonPlayerAssets.get(0).getMyIMG(), nonPlayerAssets.get(0).getX()+400, nonPlayerAssets.get(0).getY());


        gc.drawImage(nonPlayerAssets.get(1).getMyIMG(),nonPlayerAssets.get(1).getX()+nonPlayerAssets.get(0).getX(),nonPlayerAssets.get(1).getY()+nonPlayerAssets.get(0).getY());

        gc.drawImage(myPlayer.getMyIMG(), 400, 200);
        for(int i=0;i<nonPlayerAssets.size();i++){
            Assets myAsset=nonPlayerAssets.get(i);
            if(myAsset.isCollidable()&&myAsset.isMovable()){
                gc.drawImage(myAsset.getMyIMG(),myAsset.getX()+nonPlayerAssets.get(0).getX(),myAsset.getY()+nonPlayerAssets.get(0).getY());
            }
        }
        myPlayer.getMyShape().setFill(Color.TRANSPARENT);
        myPlayer.getMyShape().setStroke(Color.RED);
        for(int i=0;i<nonPlayerAssets.size();i++){
            if(nonPlayerAssets.get(i).isCollidable()){

                nonPlayerAssets.get(i).getMyShape().setFill(Color.TRANSPARENT);

                nonPlayerAssets.get(i).getMyShape().setStroke(Color.RED);
            }
        }

        assetHandler();


    }
    public void setup() {
        myGravity.setup();
        for(int i=0;i<nonPlayerAssets.size();i++){
            if(nonPlayerAssets.get(i).isCollidable()){
                myCollision.addCollidables(nonPlayerAssets.get(i));//PB pour les balles
            }
        }
        myCollision.setup();
        for(int i=0;i<nonPlayerAssets.size();i++){
            if(nonPlayerAssets.get(i).isCollidable()) {
                root.getChildren().add(nonPlayerAssets.get(i).getMyShape());//PB pour les balles

            }
        }

        this.myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode code = keyEvent.getCode();
                if(code==KeyCode.D&&!myPlayer.isDead()){
                    myPlayer.setX(myPlayer.getX() - 10);

                    myPlayer.setMyIMG(new Image("file:src/main/resources/player_cloclo_right.png"));


                } else if (code==KeyCode.Q&&!myPlayer.isDead()) {
                    myPlayer.setX(myPlayer.getX() + 10);
                    myPlayer.setMyIMG(new Image("file:src/main/resources/player_cloclo_left.png"));


                } else if (code==KeyCode.Z&&!myPlayer.isDead()) {

                    System.out.println("hitbox X:"+myPlayer.getMyShape().getLayoutX());
                    System.out.println("hitbox Y:"+myPlayer.getMyShape().getLayoutY());
                    System.out.println("player X:"+myPlayer.getX());
                    System.out.println("player Y:"+myPlayer.getY());


                } else if (code==KeyCode.SPACE&&!myPlayer.isDead()) {
                    if(!myPlayer.isIsjumping()) {
                        myPlayer.setIsjumping(true);
                        Jumper myJumper = new Jumper(myPlayer);
                        myJumper.startJump();
                    }
                }

            }
        });

    }
    Player getMyPlayer(){
        return myPlayer;
    }
    Group getRoot(){
        return this.root;
    }
    Collision getMyCollision(){
        return this.myCollision;
    }
}
