package tarea.app.packages.controllers;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MissileLauncher {
  private boolean attached;
  private JButton button;

  public MissileLauncher() {
    this.attached = true;
    this.button = new JButton("Lanzar misil");
    this.button.setFocusable(false);
    this.button.addActionListener(e -> {
      this.detach();
    });
  }

  public void detach() {
    this.attached = false;
  }

  public void adhereToPanel(JPanel panel) {
    panel.add(this.button);
  }

  public void setBounds(int x, int y, int width, int height) {
    this.button.setBounds(x, y, width, height);
  }

  public boolean getStatus() {
    return this.attached;
  }
}
