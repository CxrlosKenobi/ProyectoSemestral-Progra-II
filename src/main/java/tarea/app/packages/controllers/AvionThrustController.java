package tarea.app.packages.controllers;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class AvionThrustController implements ChangeListener {
  private JLabel label;
  private JSlider slider;
  public int MAX_THRUST = 100;
  public int MIN_THRUST = 0;

  public AvionThrustController() {
    this.slider = new JSlider(JSlider.HORIZONTAL, MIN_THRUST, MAX_THRUST, 0);
    this.slider.setPreferredSize(new Dimension(200, 50));
    this.slider.setPaintTicks(true);
    this.slider.setPaintTrack(true);
    this.slider.setPaintLabels(true);
    this.slider.setMinorTickSpacing(10);
    this.slider.setMajorTickSpacing(20);
    this.slider.setForeground(Color.WHITE);
    this.slider.setFont(new Font("Helvetica", Font.PLAIN, 10));
    this.slider.addChangeListener(this);

    this.label = new JLabel("Fuerza de empuje de avión: " + this.slider.getValue() + "%");
    this.label.setFont(new Font("Helvetica", Font.PLAIN, 12));
    this.label.setForeground(Color.WHITE);
  }

  public void adhereToPanel(JPanel panel) {
    panel.add(this.label);
    panel.add(this.slider);
  }

  public void setBounds(int x, int y, int width, int height) {
    this.label.setBounds(x, y, width, height);
    this.slider.setBounds(x, y + 30, width, height);
  }

  public int getThrust() {
    return this.slider.getValue();
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    this.label.setText("Fuerza de empuje de avión: " + this.slider.getValue() + "%");
  }
}
