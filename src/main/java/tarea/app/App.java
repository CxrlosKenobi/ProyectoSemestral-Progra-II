package tarea.app;

import tarea.app.views.LoadingScreen;
import tarea.app.views.SimulationScreen;

import java.awt.*;
import java.io.IOException;
/**
 *
 * @author cxrloskenobi
 * @author sebasinmas
 */

public class App {
    public static void main(String[] args) throws FontFormatException, IOException {
        try { // Loading a cozy UI style for the app
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        Thread t = new Thread(() -> {
            new LoadingScreen("Missile Launch System");
            new SimulationScreen();
        });

        t.start();
    }
}
