package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class AnimatedThing {
    protected double x,y,speed;
    Shape myShape;
    Image myIMG;

    public AnimatedThing(double x, double y, double speed, Image myIMG,Shape myShape) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.myIMG = myIMG;
        this.myShape=myShape;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Image getMyIMG() {
        return myIMG;
    }

    public void setMyIMG(Image myIMG) {
        this.myIMG = myIMG;
    }

    public Shape getMyShape() {
        return myShape;
    }
}
