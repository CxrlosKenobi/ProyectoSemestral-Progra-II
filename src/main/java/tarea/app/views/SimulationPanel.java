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

    // Double buffer
    Dimension d; 
    Image offImage; //es el buffer donde se dibujara (como MiPanel)
    Graphics offGraphics; // es el pincel que dibujara en offImage
    Dimension offDimension;

    public synchronized void update(Graphics g) {
        d = getSize();
        if ( (offGraphics == null)
           || (d.width != offDimension.width)
           || (d.height != offDimension.height)
        ) { // dimensiona para que sea igual a MiPanel
            offDimension = d;
            offImage = createImage(d.width, d.height); // crea el objeto doble buffer
            offGraphics = offImage.getGraphics(); // le asocia el pincel offGraphics 
       }
       
       //Borra las imágenes previas del buffer, no está dibujando en MiPanel:
       offGraphics.setColor(new Color(0, 161, 191)); // ground
       offGraphics.fillRect(0, 500, 1280, 720);
       offGraphics.setColor(new Color(255, 255, 255)); // sky
       offGraphics.fillRect(0, 0,1280 , 500);

       misil.paint(offGraphics);
       avion.paint(offGraphics);
       objetivo.paint(offGraphics);

       g.drawImage(offImage, 0, 0, this); // hace el cambio instantáneo de lo dibujado en el buffer a MiPanel
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        avion.update(avionHeightController.getAltitude(), avionThrustController.getThrust());
        misil.update(missileLauncher.getStatus(), avionHeightController.getAltitude(), avionThrustController.getThrust());
        objetivo.update();
        repaint();
    }
}
