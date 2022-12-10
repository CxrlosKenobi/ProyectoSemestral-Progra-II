package tarea.app.classes;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
public class Objetivo {
    private int x;
    private int y;
    private double velX;
    private double velY;
    private double angle;
    private BufferedImage carSprite;

    public Objetivo() {
        this.loadCarImage();
        this.x = 0;
        this.y = 600;
        this.velX = 0;
        this.velY = 0;
        this.angle = 0;

    }



    //paint
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // g2D.drawImage(this.getImage().getScaledInstance(160, 90, 0), x, y, null);

    }







    //methods
    public void loadCarImage() {
        try {
            InputStream is = getClass().getResourceAsStream("sprites/car.png");
            carSprite = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    //getters and setters
    public Image getImage() {
        return carSprite;
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
