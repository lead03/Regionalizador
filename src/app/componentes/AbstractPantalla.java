package app.componentes;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class AbstractPantalla extends JFrame {
    protected static int CORRECCION_BANNER = 30;


    public AbstractPantalla() {
        initialize();
    }

    protected void initialize() {
        // Obtén las dimensiones de la pantalla
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - CORRECCION_BANNER;
        
        setBounds(0, 0, screenWidth, screenHeight);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
