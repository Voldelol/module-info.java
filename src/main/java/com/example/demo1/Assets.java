package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Assets {
    private double x,y;
    private boolean collidable,movable;
    private Image myIMG;
    private Shape myShape;
    private boolean addToCtx;

    private int patternIndex;//à utiliser plus tard quand on importe une liste de coordonnées à partir d'un csv

    public Assets(double x, double y, boolean collidable, boolean movable, Image myIMG,Shape myShape) {
        this.x = x;
        this.y = y;
        this.collidable = collidable;
        this.movable = movable;
        this.myIMG = myIMG;
        this.patternIndex=0;
        this.myShape=myShape;
        this.addToCtx=false;
    }
    public Assets(double x, double y, boolean collidable, boolean movable, Image myIMG,Shape myShape,boolean ctx) {
        this.x = x;
        this.y = y;
        this.collidable = collidable;
        this.movable = movable;
        this.myIMG = myIMG;
        this.patternIndex=0;
        this.myShape=myShape;
        this.addToCtx=ctx;
    }
    public Assets(double x, double y, boolean collidable, boolean movable, Image myIMG) {
        this.x = x;
        this.y = y;
        this.collidable = collidable;
        this.movable = movable;
        this.myIMG = myIMG;
        this.patternIndex=0;
        this.addToCtx=false;

    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Image getMyIMG() {
        return myIMG;
    }

    public int getPatternIndex() {
        return patternIndex;
    }

    public void setPatternIndex(int patternIndex) {
        this.patternIndex = patternIndex;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public Shape getMyShape() {
        return myShape;
    }

    public boolean isMovable() {
        return movable;
    }
    public void setCtx(boolean ctx){
        this.addToCtx=ctx;
    }
    public boolean getCtx(){
        return addToCtx;
    }
}
