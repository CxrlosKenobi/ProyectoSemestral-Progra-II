package tarea.app;

import tarea.app.views.LoadingScreen;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author cxrloskenobi
 * @author sebasinmas
 */

public class App {

    public static void main(String[] args) throws FontFormatException, IOException {
        // This loads an UI Style for the app
        try {
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

        LoadingScreen loadingScreen = new LoadingScreen("Missile Launch System");
    }
}
