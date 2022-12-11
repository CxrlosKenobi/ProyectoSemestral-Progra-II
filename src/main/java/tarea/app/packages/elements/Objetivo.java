package tarea.app.packages.elements;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.awt.event.*;

import javax.imageio.*;
public class Objetivo {
    private int x;
    private int y;
    private int velX;
    private BufferedImage targetSprite;
    private boolean positiveDirection;
    public Objetivo() {
        this.positiveDirection = true;
        this.loadTargetImage();
        this.x = 30;
        this.y = 600;
        this.velX = 2;
    }
    public void loadTargetImage() {
        try {
            if (positiveDirection) {
                InputStream is = getClass().getResourceAsStream("../sprites/boatRight.png");
                targetSprite = ImageIO.read(is);

            } else {
                InputStream is = getClass().getResourceAsStream("../sprites/boatLeft.png");
                targetSprite = ImageIO.read(is);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.getImage(), this.x, this.y, null);

    }

    public void update() {
        this.x += this.velX;
    }

    public void update(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.velX = -2;
            this.positiveDirection = false;
            this.loadTargetImage();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.velX = 2;
            this.positiveDirection = true;
            this.loadTargetImage();
        }
    }

    public BufferedImage getImage() {
        return targetSprite;
    }
   
    
}
