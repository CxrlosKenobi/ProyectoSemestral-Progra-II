package tarea.app.packages.elements;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Misil {
  private boolean attached;
  private int x;
  private int y;
  private double velX;
  private BufferedImage missileSprite;
  private boolean positiveDirection;

  public Misil() {
    this.attached = true;
    this.positiveDirection = true;
    this.loadMissileImage();
    this.x = 45;
    this.y = 0;
    this.velX = 0;
  }

  public void paint(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;

    g2D.drawImage(this.getImage().getScaledInstance(
      110,
      30,
      0),
      this.x,
      this.y,
      null
    );
  }

  public void loadMissileImage() {
    try {
      if (positiveDirection) {
        InputStream is = getClass().getResourceAsStream("../sprites/missileRight.png");
        missileSprite = ImageIO.read(is);

      } else {
        InputStream is = getClass().getResourceAsStream("../sprites/missileLeft.png");
        missileSprite = ImageIO.read(is);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Image getImage() {
    return this.missileSprite;
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

  public void setAttached(boolean attached) {
    this.attached = attached;
  }
    
  public void update(boolean isAttached, int controlledY, int controlledVelX) {
    this.attached = isAttached;

    if (this.attached) {
      this.y = controlledY + 45;
      this.velX = controlledVelX;

      if (positiveDirection) {
        this.x += this.velX;
        if (this.x >= 1061) {
          positiveDirection = false;
          this.loadMissileImage();
        }
      
      } else {
        this.x -= this.velX;
  
        if (this.x <= -200) {
          positiveDirection = true;
          this.loadMissileImage();
        }
      }
    
    } else {
      // Start physics animation of the missile falling by gravity
      this.y += 10;


    }
  }
}
