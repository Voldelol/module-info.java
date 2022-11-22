package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Player extends AnimatedThing{
    private boolean isjumping,triggerGravity,dead;
    public Player(double x, double y, double speed, Image myIMG, Shape myShape) {
        super(x, y, speed, myIMG,myShape);
        this.isjumping=false;
        this.triggerGravity=false;
        this.dead=false;
    }

    public void setIsjumping(boolean isjumping) {
        this.isjumping = isjumping;
    }

    public boolean isIsjumping() {
        return isjumping;
    }

    public void setTriggerGravity(boolean triggerGravity) {
        this.triggerGravity = triggerGravity;
    }

    public boolean isTriggerGravity() {
        return triggerGravity;
    }

    public boolean isDead() {
        return dead;
    }
    public void kill(){
        this.dead=true;
    }
}

