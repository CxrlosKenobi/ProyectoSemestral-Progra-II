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
    private Misil misil;
    private MissileLauncher missileLauncher;
    private Objetivo objetivo;
    private Timer fpsTimer;

    public SimulationPanel(
        MissileLauncher missileController,
        AvionHeightController avionHeightController,
        AvionThrustController avionThrustController
    ) {
        this.avion = new Avion();
        this.avionHeightController = avionHeightController;
        this.avionThrustController = avionThrustController;
        this.misil = new Misil();
        this.missileLauncher = missileController;
        this.objetivo = new Objetivo();
        this.fpsTimer = new Timer(1000 / 60, this);
        this.fpsTimer.start();
        this.setFocusable(isFocusable());
        this.requestFocus();
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
        misil.update(missileLauncher.getStatus(), avionHeightController.getAltitude(), avionThrustController.getThrust());
        objetivo.update();
        repaint();
    }
}
