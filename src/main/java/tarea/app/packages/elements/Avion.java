package tarea.app.packages.elements;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;

public class Avion {
    private int x;
    private int y;
    private double velX;
    private BufferedImage avionSprite;
    private boolean positiveDirection;
    private ArrayList<Misil> misiles = new ArrayList<Misil>();
    private Objetivo objetivo;

    public Avion(Objetivo objetivo) {
        this.objetivo = objetivo;
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
        
        if(!misiles.isEmpty()) {
            for (int i = 0; i < misiles.size(); i++) {
                try{
                    misiles.get(i).update();
                    misiles.get(i).paint(g);
                    if(misiles.get(i).getY() > 720){
                        misiles.remove(i);
                    }

                }catch(Exception e){
                    System.out.println("Se ha borrado un misil");
                }
            }
        }
    }

    public void missileLaunch() {
        System.out.println("Lanzando misil");
        misiles.add(new Misil(this, objetivo, this.positiveDirection));
        System.out.println("Misiles: " + misiles.size());
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
    public boolean getPossitiveDirection(){
        return this.positiveDirection;
    }

    public Image getImage() {
        return this.avionSprite;
    }

    public double getVelX() {
        return this.velX;
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
