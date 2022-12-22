package tarea.app.packages.controllers;

import java.awt.*;
import javax.swing.*;

public class MisilController {
    // makes a button

    private JButton button;

    public MisilController() {
        button = new JButton("Lanzar misil");
        button.setPreferredSize(new Dimension(200, 50));
        button.setFont(new Font("Helvetica", Font.PLAIN, 12));
        button.setFocusable(false);
    }

    public void adhereToPanel(JPanel panel) {
        panel.add(this.button);
    }

    public void setBounds(int x, int y, int width, int height) {
        this.button.setBounds(x, y, width, height);
    }
    
    public JButton getButton() {
        
        return this.button;
    }
}
