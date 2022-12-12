package tarea.app.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//
import tarea.app.packages.elements.*;
import tarea.app.packages.controllers.*;

public class SimulationPanel extends JPanel implements ActionListener {
    private Avion avion;
    private Misil misil;
    private Objetivo objetivo;
    private AvionHeightController avionHeightController;
    private AvionThrustController avionThrustController;
    private Timer fpsTimer;

    public SimulationPanel(AvionHeightController avionHeightController, AvionThrustController avionThrustController) {
        this.avion = new Avion();
        this.misil = new Misil();
        this.objetivo = new Objetivo();
        this.avionHeightController = avionHeightController;
        this.avionThrustController = avionThrustController;
        this.fpsTimer = new Timer(1000 / 60, this);
        this.fpsTimer.start();
        this.setFocusable(isFocusable());
        this.requestFocus();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                objetivo.update(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 161, 191)); // ground
        g2d.fillRect(0, 500, 1280, 720);
        g2d.setColor(new Color(255, 255, 255)); // sky
        g2d.fillRect(0, 0, 1280, 500);

        objetivo.paint(g);
        misil.paint(g);
        avion.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        avion.update(avionHeightController.getAltitude(), avionThrustController.getThrust());
        misil.update(avionHeightController.getAltitude(), avionThrustController.getThrust());
        objetivo.update();
        repaint();
    }
}
