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
                null
        );

        // Add a border to the plane
        // g2D.setColor(Color.CYAN);
        // g2D.drawRect(this.x, this.y, 200, 120);
    }

    public void loadPlaneImage() {
        try {
            if (positiveDirection) {
                InputStream is = getClass().getResourceAsStream("../sprites/planeRight.png");
                avionSprite = ImageIO.read(is);

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
            if (this.x > 1061) {
                positiveDirection = false;
                this.loadPlaneImage();
            }
        } else {
            this.x -= this.velX;
            if (this.x < -200) {
                positiveDirection = true;
                this.loadPlaneImage();
            }
        }
    }
}
