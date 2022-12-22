package tarea.app.views;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import tarea.app.packages.controllers.*;
import java.io.*;

public class SimulationScreen extends JFrame {
    public SimulationScreen() {
        super("Destroy your enemies!");
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    private void initComponents() {
        try{
            icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/icons/icon.png")));            
        }catch(Exception e){
            System.out.println("Icon not found");
        }

        
        setIconImage(icon.getImage());



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        ButtonsPanel = new javax.swing.JPanel();
        ButtonsPanel.setBackground(new java.awt.Color(90, 90, 90));
        javax.swing.GroupLayout ButtonsPanelLayout = new javax.swing.GroupLayout(ButtonsPanel);
        ButtonsPanel.setLayout(ButtonsPanelLayout);
        ButtonsPanelLayout.setHorizontalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        ButtonsPanelLayout.setVerticalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        JLabel title = new JLabel("Controllers");
        title.setFont(new Font("Helvetica", Font.PLAIN, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(20, 20, 200, 30);
        ButtonsPanel.add(title);

        AvionHeightController avionHeightController = new AvionHeightController();
        avionHeightController.adhereToPanel(ButtonsPanel);
        avionHeightController.setBounds(20, 50, 200, 100);

        AvionThrustController avionThrustController = new AvionThrustController();
        avionThrustController.adhereToPanel(ButtonsPanel);
        avionThrustController.setBounds(20, 150, 200, 100);

        MisilController misilController = new MisilController();
        misilController.adhereToPanel(ButtonsPanel);
        misilController.setBounds(20, 350, 200, 100);


        GamePanel = new SimulationPanel(avionHeightController, avionThrustController, misilController);
        
        GamePanel.setBackground(new java.awt.Color(255, 248, 191));
        javax.swing.GroupLayout GamePanelLayout = new javax.swing.GroupLayout(GamePanel);
        GamePanel.setLayout(GamePanelLayout);
        GamePanelLayout.setHorizontalGroup(
            GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        GamePanelLayout.setVerticalGroup(
            GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(GamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    
   
    
    // Variables declaration - do not modify      
    private ImageIcon icon;               
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JPanel GamePanel;
}
