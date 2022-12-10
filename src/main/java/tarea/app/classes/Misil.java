package tarea.app.classes;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Misil {
    private int x;
    private int y;
    private double velX;
    private double velY;
    private double angle;
    private BufferedImage missileSprite;

    public Misil() {
        this.loadMissileImage();
        this.x = 0;
        this.y = 0;
        this.velX = 0;
        this.velY = 0;
        this.angle = 0;

    }



    //paint
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // g2D.drawImage(missileSprite, x, y, null);

    }







    //methods
    public void loadMissileImage() {
        try {
            InputStream is = getClass().getResourceAsStream("sprites/missile.png");
            missileSprite =ImageIO.read(is);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    //getters and setters
    public Image getImage() {
        return missileSprite;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public double getVelX() {
        return this.velX;
    }
    public double getVelY() {
        return this.velY;
    }
    public double getAngle() {
        return this.angle;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setVelX(double velX) {
        this.velX = velX;
    }
    public void setVelY(double velY) {
        this.velY = velY;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }

}
