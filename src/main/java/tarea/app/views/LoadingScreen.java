package tarea.app.views;
import java.awt.*;
import java.io.InputStream;

public class LoadingScreen extends javax.swing.JFrame {
    private Font cFont = loadFuentePersonalizada("miPoster.ttf",0 , 50);
    
    public LoadingScreen(String name) {
        super(name);
        setUndecorated(true);
        initComponents();
        ProgramTitle.setFont(cFont);
        setLocationRelativeTo(null);
        setVisible(true);
        playApp();
    }

    private Font loadFuentePersonalizada(String fontName, int style, int size) {
        Font font = null;
        try{
            InputStream is = getClass().getResourceAsStream("/tarea/app/views/assets/fonts/" + fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(style, size);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return font;
    }
   
    private void initComponents() {
        LoadingScreen = new javax.swing.JPanel();
        ProgramTitle = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        LoadingScreen.setBackground(new java.awt.Color(16, 24, 32));

        // ProgramTitle.setFont();
        ProgramTitle.setForeground(new java.awt.Color(254, 231, 21));
        ProgramTitle.setText("Missile Launch System");

        LoadingBar.setForeground(new java.awt.Color(254, 231, 21));

        jLabel1.setForeground(new java.awt.Color(254, 231, 21));
        jLabel1.setText("Loading  ...");

        javax.swing.GroupLayout LoadingScreenLayout = new javax.swing.GroupLayout(LoadingScreen);
        LoadingScreen.setLayout(LoadingScreenLayout);
        LoadingScreenLayout.setHorizontalGroup(
                LoadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoadingScreenLayout.createSequentialGroup()
                                .addGroup(LoadingScreenLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(LoadingScreenLayout.createSequentialGroup()
                                                .addGap(452, 452, 452)
                                                .addComponent(ProgramTitle))
                                        .addGroup(LoadingScreenLayout.createSequentialGroup()
                                                .addGap(305, 305, 305)
                                                .addGroup(LoadingScreenLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LoadingBar,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 664,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(305, 305, 305)));
        LoadingScreenLayout.setVerticalGroup(
                LoadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoadingScreenLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(ProgramTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 12,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(280, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LoadingScreen, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LoadingScreen, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    

    private void playApp() {
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(25);
                switch (i) {
                    case (10) -> {
                        this.jLabel1.setText("Loading trigonometry...");
                        break;
                    }
                    case (20) -> {
                        this.jLabel1.setText("Loading nuclear bombs...");
                        break;
                    }
                    case (30) -> {
                        this.jLabel1.setText("Loading guns...");
                        break;
                    }
                    case (40) -> {
                        this.jLabel1.setText("Loading secret features...");
                        break;
                    }
                    case (50) -> {
                        this.jLabel1.setText("Loading easter eggs...");
                        break;
                    }
                    case (60) -> {
                        this.jLabel1.setText("Loading funny quotes...");
                        break;
                    }
                    case (70) -> {
                        this.jLabel1.setText("Loading databases...");
                        break;
                    }
                    case (80) -> {
                        this.jLabel1.setText("Loading secret information...");
                        break;
                    }
                    case (90) -> {
                        this.jLabel1.setText("Loading declassified CIA documents...");
                        break;
                    }
                    case (100) -> {
                        this.jLabel1.setText("Loaded!");
                        this.LoadingScreen.setVisible(false);
                        this.dispose();
                        break;

                    }
                }
                this.LoadingBar.setValue(i);

            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
    // Variables declaration - do not modify
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JPanel LoadingScreen;
    private javax.swing.JLabel ProgramTitle;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}