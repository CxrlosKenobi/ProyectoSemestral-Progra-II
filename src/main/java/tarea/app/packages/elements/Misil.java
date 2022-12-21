package tarea.app.packages.elements;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class Misil {
    private int x;
    private int y;
    private double velX;
    private double velY;
    private double angle;
    private double velAngle;
    private double gravity;
    private boolean positiveDirection;
    private BufferedImage misilSprite;
    private Avion avion;
    private Objetivo objetivo;

    public Misil(Avion avion, Objetivo objetivo, Boolean positiveDirection) {
        this.positiveDirection = positiveDirection;
        this.objetivo = objetivo;
        this.avion = avion;
        this.x = avion.getX();
        this.y = avion.getY();
        this.velX = 0;
        this.velY = 0;
        this.angle = 0;
        this.velAngle = 0;
        this.gravity = 10;
        this.loadMissilImage();
    }


    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.rotate(angle, this.x, this.y);
        g2D.drawImage(this.getImage(), this.x, this.y, null);

    }
    public void update(){
        if(positiveDirection == true){
            this.x += this.velX;
        }else{
            this.x -= this.velX;
        }
        this.y += this.gravity;
    }



    public void loadMissilImage() {
        try{
            this.velX = avion.getVelX();
            if(avion.getPossitiveDirection()){
                InputStream is = getClass().getResourceAsStream("../sprites/misilRight.png");
                misilSprite = ImageIO.read(is);
            }else{
                InputStream is = getClass().getResourceAsStream("../sprites/misilLeft.png");
                misilSprite = ImageIO.read(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getters and setters
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
    
    public BufferedImage getImage() {
        return misilSprite;
    }

}
