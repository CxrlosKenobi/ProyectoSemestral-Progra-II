package tarea.app.packages;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.*;

import javax.swing.*;
import java.io.*;

public class Avion {
    private int x;
    private int y;
    private double velX;
    private double angulo;
    private double velAngulo;
    private double aceleracion;
    private double aceleracionAngular;
    private BufferedImage avionSprite;

    public Avion() {
        this.loadPlaneImage();
        this.x = 0;
        this.y = 0;
        this.velX = 5;
        this.angulo = 0;
        this.velAngulo = 0;
        this.aceleracion = 0;
        this.aceleracionAngular = 0;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(this.getImage().getScaledInstance(150, 100, 0), x, 0, null);
        if (this.x > 1280) {
            this.x = 0;
        }

    }

    public void loadPlaneImage() {
        try {
            if (this.velX < 0) {
                InputStream is = getClass().getResourceAsStream("sprites/planeLeft.png");
                avionSprite = ImageIO.read(is);

            } else {
                InputStream is = getClass().getResourceAsStream("sprites/planeRight.png");
                avionSprite = ImageIO.read(is);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return avionSprite;
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

    public void update() {
        this.x += this.velX;
        if (this.x > 1010) {
            velX = velX * -1;
            this.x += this.velX;
            loadPlaneImage();
        }if (this.x <-150) {
            velX = velX * -1;
            this.x += this.velX;
            loadPlaneImage();
        }
    }
}
