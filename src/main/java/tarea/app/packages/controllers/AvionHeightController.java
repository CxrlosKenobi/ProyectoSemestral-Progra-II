package tarea.app.packages.controllers;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class AvionHeightController implements ChangeListener {
  private JLabel label;
  private JSlider slider;
  public int MAX_ALT = 410;
  public int MIN_ALT = 0;

  public AvionHeightController() {
    this.slider = new JSlider(JSlider.HORIZONTAL, MIN_ALT, MAX_ALT, 0 );
    this.slider.setPreferredSize(new Dimension(200, 50));
    this.slider.setPaintTicks(true);
    this.slider.setPaintTrack(true);
    this.slider.setPaintLabels(true);
    this.slider.setMinorTickSpacing(10);
    this.slider.setMajorTickSpacing(80);
    this.slider.setFont(new Font("Helvetica", Font.PLAIN, 10));
    this.slider.setForeground(Color.WHITE);
    this.slider.addChangeListener(this);
    this.slider.setFocusable(false);

    this.label = new JLabel("Altura de vuelo: " + this.slider.getValue() + " m.s.n.m");
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

  public int getAltitude() {
    return this.slider.getValue();
  }

  public int getMaxAltitude() {
    return this.MAX_ALT;
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    this.label.setText("Altura de vuelo: " + this.slider.getValue() + " m.s.n.m");
  }
}
