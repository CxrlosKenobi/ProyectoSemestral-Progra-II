package tarea.app.views;

import java.awt.*;
import javax.swing.*;

import tarea.app.classes.*;

import java.awt.event.*;

public class SimulationPanel extends JPanel implements ActionListener {
    private Avion avion;
    private Misil misil;
    private Objetivo objetivo;
    private Timer timer;
    


    public SimulationPanel() {
        objetivo = new Objetivo();
        avion = new Avion();
        misil = new Misil();
        timer = new Timer(1000 / 60, this);
        timer.start();
    }
    // Double buffer
    Dimension d; 
    Image offImage; //es el buffer donde se dibujara (como MiPanel)
    Graphics offGraphics; // es el pincel que dibujara en offImage
    Dimension offDimension;
    public synchronized void update(Graphics g){ 
        d = getSize();
        if ( (offGraphics == null)
           || (d.width != offDimension.width)
           || (d.height != offDimension.height) ) { //dimensiona para que sea igual a MiPanel
                offDimension = d;
                offImage = createImage(d.width, d.height); //crea el objeto doble buffer
                offGraphics = offImage.getGraphics();      //le asocia el pincel offGraphics 
       }
       //Borra las imágenes previas del buffer, no está dibujando en MiPanel:
       
       offGraphics.setColor(new Color(0,161,53));
       offGraphics.fillRect(0, 500, 1280, 720);
       offGraphics.setColor(new Color(212,244,237));
       offGraphics.fillRect(0, 0,1280 , 500);

       avion.paint(offGraphics);
       misil.paint(offGraphics);
       objetivo.paint(offGraphics);


       g.drawImage(offImage, 0, 0, this); //hace el cambio instantáneo de lo dibujado en el buffer a MiPanel
   }

    //end of Double Buffer










    
    @Override
    public void paint(Graphics g){
        // Graphics2D g2d = (Graphics2D) g;

        // g.setColor(new Color(0,161,53));
        // g.fillRect(0, 500, 1280, 720);
        // g.setColor(new Color(212,244,237));
        // g.fillRect(0, 0,1280 , 500);

        // avion.paint(g);
        // misil.paint(g);
        // objetivo.paint(g);
        update(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        avion.update();
        repaint();        
    }
   
}
