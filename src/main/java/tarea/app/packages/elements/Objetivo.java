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
    private boolean struck;
    private BufferedImage targetSprite;
    private boolean positiveDirection;
    

    public Objetivo() {
        this.positiveDirection = true;
        this.loadTargetImage();
        this.x = 0;
        //sets height between 490 and 680
        this.y = (int) (Math.random() * 190) + 490;
        //sets velocity between 2 and 10;
        this.velX = (int) (Math.random() * 8) + 2;
    }

    public void loadTargetImage() {
        try {
            if (positiveDirection) {
                InputStream is = getClass().getResourceAsStream("../sprites/boatRight.png");
                targetSprite = ImageIO.read(is);
                // System.out.println(targetSprite.getHeight()+" "+targetSprite.getWidth());
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
        if (!struck) this.x += this.velX;

        if( this.x > 1011 || this.x < -100){
            this.velX = this.velX * -1;
            this.positiveDirection = !this.positiveDirection;
            this.loadTargetImage();
        }
    }

    public void update(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if (this.velX > 0) {
                this.velX = this.velX * -1;
                this.positiveDirection = false;
                this.loadTargetImage();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            if(this.velX < 0){
                this.velX = this.velX * -1;
                this.positiveDirection = true;
                this.loadTargetImage();
            }
        }
    }

    public BufferedImage getImage() {
        return targetSprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStruck(boolean value) {
        this.struck = value;
    }
}
