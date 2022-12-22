package tarea.app.packages.elements;

import java.awt.*;
import java.awt.image.*;

public class Misil {
    private int x;
    private int y;
    private double velX;
    private double velY;
    private double angle;
    private double velAngle;
    private double gravity;
    private BufferedImage misilSprite;



    public Misil(){
        this.x = 0;
        this.y = 0;
        this.velX = 0;
        this.velY = 0;
        this.angle = 0;
        this.velAngle = 0;
        this.gravity = 10;
    }



    //getters and setters
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getVelX() {
        return velX;
    }
    public void setVelX(double velX) {
        this.velX = velX;
    }
    public double getVelY() {
        return velY;
    }
    public void setVelY(double velY) {
        this.velY = velY;
    }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public double getVelAngle() {
        return velAngle;
    }
    public void setVelAngle(double velAngle) {
        this.velAngle = velAngle;
    }
    public double getGravity() {
        return gravity;
    }
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
}
