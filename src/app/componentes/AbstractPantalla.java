package app.componentes;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class AbstractPantalla extends JFrame {
    private static int CORRECCION_BANNER = 30;

    private int[] dimension;

    public AbstractPantalla() {
        initialize();
    }

    protected void initialize() {
        // Obtén las dimensiones de la pantalla
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - CORRECCION_BANNER;

        dimension = new int[]{screenWidth, screenHeight};

        // Configura el tamaño de la ventana
        setSize(screenWidth, screenHeight);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Establece el cierre por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getAncho() {
        return dimension[0];
    }

    public int getAlto() {
        return dimension[1];
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
    }
}
