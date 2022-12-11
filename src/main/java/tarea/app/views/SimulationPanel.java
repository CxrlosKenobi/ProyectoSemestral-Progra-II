package tarea.app.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//
import tarea.app.packages.elements.*;
import tarea.app.packages.controllers.*;


public class SimulationPanel extends JPanel implements ActionListener {
    private Avion avion;
    private AvionHeightController avionHeightController;
    private AvionThrustController avionThrustController;
    public int avionHeight = 10;

    private Timer fpsTimer;
    // private Image sprite;

    public SimulationPanel(AvionHeightController avionHeightController, AvionThrustController avionThrustController) {
        this.avion = new Avion(avionHeight);
        this.avionHeightController = avionHeightController;
        this.avionThrustController = avionThrustController;
        this.fpsTimer = new Timer(1000 / 60, this);
        this.fpsTimer.start();
    }
    
    @Override
    public void paint(Graphics g) {
        // g.setBackground(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;

        // g2d.setBackground(new java.awt.Color(255, 248, 191));
        // g2d.drawImage(avion.getImage().getScaledInstance(150, 100, 0), 0, 0, null);
        g2d.setColor(new Color(0,161,191)); // ground
        g2d.fillRect(0, 500, 1280, 720);
        g2d.setColor(new Color(255,255,255)); // sky
        g2d.fillRect(0, 0,1280 , 500);

        avion.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int avionHeight = avionHeightController.getMaxAltitude() - avionHeightController.getAltitude();
        avion.update(avionHeight, avionThrustController.getThrust());
        repaint();
    }
}
