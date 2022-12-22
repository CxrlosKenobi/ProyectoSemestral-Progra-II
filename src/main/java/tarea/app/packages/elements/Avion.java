package tarea.app.packages.elements;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Avion {
    private int x;
    private int y;
    private double velX;
    private BufferedImage avionSprite;
    private boolean positiveDirection;
    private Misil[] misiles;

    public Avion() {
        this.positiveDirection = true;
        this.loadPlaneImage();
        this.x = 0;
        this.y = 0;
        this.velX = 0;

    }
    
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(this.getImage().getScaledInstance(
                200,
                120,
                0),
                this.x,
                this.y,
                null);

        // for (Misil misil : misiles) {
        // }

    }

    public void missileLaunch() {
        System.out.println("Lanzando misil");
    }

    public void loadPlaneImage() {
        try {
            if (positiveDirection) {
                InputStream is = getClass().getResourceAsStream("../sprites/planeRight.png");
                avionSprite = ImageIO.read(is);
                avionSprite.getScaledInstance(1500,100, 0);

            } else {
                InputStream is = getClass().getResourceAsStream("../sprites/planeLeft.png");
                avionSprite = ImageIO.read(is);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return this.avionSprite;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void update(int controlledY, int controlledVelX) {
        this.y = controlledY;
        this.velX = controlledVelX;

        if (positiveDirection) {
            this.x += this.velX;
            if (this.x >= 1061) {
                positiveDirection = false;
                this.loadPlaneImage();
            }
        } else {
            this.x -= this.velX;
            if (this.x <= -200) { // -200 is the width of the plane
                positiveDirection = true;
                this.loadPlaneImage();
            }
        }
    }
}
