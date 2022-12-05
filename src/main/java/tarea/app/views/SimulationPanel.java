package tarea.app.views;

import java.awt.*;
import javax.swing.*;

import tarea.app.classes.*;

import java.awt.event.*;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimulationPanel extends JPanel implements ActionListener {
    private Avion avion;
    private Timer timer;
    private Image sprite;


    public SimulationPanel() {
        avion = new Avion();
        timer = new Timer(1000 / 60, this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g){
        // g.setBackground(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;

        // g2d.setBackground(new java.awt.Color(255, 248, 191));
        // g2d.drawImage(avion.getImage().getScaledInstance(150, 100, 0), 0, 0, null);
        g2d.setColor(new Color(0,161,53));
        g2d.fillRect(0, 500, 1280, 720);
        g2d.setColor(new Color(212,244,237));
        g2d.fillRect(0, 0,1280 , 500);

        avion.paint(g);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        avion.update();
        repaint();        
    }
   
}
